$(document).ready(function() {

	var goodslist_form = document.frmList;
	var maxCategoryIndex = 7;
	var currCategoryIndex = 0;
	var currPage = 1;
	var totalPage = 1;
	var isoOptions = {itemSelector: 'li', columnWidth: 246};
	var $iso;


	$(window).scroll(function(){
		if( $(window).scrollTop() == ($(document).height() - $(window).height()) ){ 
			if($('#btn_allshopping').data('click') && currCategoryIndex < maxCategoryIndex){
				getDashGoodsData(currCategoryIndex, currPage);
				//console.log('dash');
			}
		}
	});

	// all product shopping
	$('#btn_allshopping').click(function (){
		if ( !$(this).data('click') ){
			openDashBoard = true;
			if(currCategoryIndex == 0){
				getDashGoodsData(0, 1);
			}
			$(this).data('click',1).addClass('open');
			$('.curtain_layer').animate({top:0},1000,'easeOutExpo',function (){
				$('.allshopping_area').css({position:'static'});
				$('.content_area').hide();
				$('.curtain_layer').animate({top:'100%'},'easeOutExpo',function (){
					$('.curtain_layer').css('top','-100%');
				});
			});
			$iso =  $('#allprod_section .prod_list').isotope(isoOptions);

		}else{
			openDashBoard = true;
			$(this).data('click',0).removeClass('open');
			$('.curtain_layer').animate({top:0},1000,'easeOutExpo',function (){
				$('.content_area').show();
				$('.allshopping_area').css({position:'fixed'});
				$('.curtain_layer').animate({top:'100%'},'easeOutExpo',function (){
					$('.curtain_layer').css('top','-100%');
				});
			});
			$iso.isotope('destroy');
			$('#dash_prod_list').find("li:not(:first)").remove();
			currCategoryIndex = 0;
			currPage = 1;
			totalPage = 1;
		}
	});

	function getDashGoodsData( categoryIndex, page){
		$.ajax({
			type: "get",
			url: "/shop/goods/getGoodsListAjax.php",
			cache:false,
			async:true,
			data: {
				'mode' : 'get_dashboard',
				'categoryIndex' : categoryIndex,
				'sort' : 'goods',
				'page_num' : 30,
				'page' : page
			},
			success: function (res) {
				totalPage = res['totalpage'];
				makeDashGoodsList(res.goods_data, res.review);
			},
			beforeSend:function(){
				$('.load_ajax').show();
			},
			complete:function(){
				$('.load_ajax').hide();
			},
			fail : function ( e) {
				alert(e);
			},
			dataType:"json"
		});
	}

	function makeDashGoodsList( data, review){

		var goods_src	= "/shop/goods/goods_view.php?goodsno=";
		var img_path	= "/shop/web/images/common";
		var $dash_prod_list = $("#dash_prod_list");

		if(data.length > 0 ) {

			var add_html = "";
			var reviewIndex = 0;
			for(var i=0; i<data.length; i++) {

				var add_html = "";

				if(i == 0 && currPage == 1)
				{
					add_html += '<li class="category_item type1">';
					add_html +=		'<div class="txt1">'+data[i].categorynm+'</div>';
					add_html += '</li>';
				}
				
				if(review && review.length > 0 && i != 0 && i % 6 == 0){
					var reviewdata = review[reviewIndex];
					if(!reviewdata) reviewdata = review[reviewIndex-1];

					add_html += '<li class="review_item">';
					add_html += '	<a href="'+goods_src + reviewdata.goodsno+'">';
					add_html += '		<div class="inbox">';
					add_html += '			<div class="review_tit">'+reviewdata.goodsnm+'</div>';
					add_html += '			<p class="review_txt">'+reviewdata.contents+'</p>';
					add_html += '			<div class="bot_con">';
					add_html += '				<div class="grade_box type2">';
														for(var x = 0; x < parseInt(reviewdata.point); x++){
															add_html += '<span class="full">full</span>';
														}
														for(var z = 0; z < (5-parseInt(reviewdata.point)); z++){
															add_html += '<span class="full">empty</span>';
														}
					add_html += '				</div>';
					add_html += '				<span class="user_id">';
													add_html += masking(reviewdata.m_id);
													/*
													if(reviewdata.name) add_html += masking(reviewdata.name);
													else if(reviewdata.m_name) add_html += masking(reviewdata.m_name);
													else if(reviewdata.m_id) add_html += masking(reviewdata.m_id);
													else add_html += masking(reviewdata.m_id);
													*/
					add_html += '				</span>';
					add_html += '			</div>';
					add_html += '		</div>';
					add_html += '	</a>';
					add_html += '</li>';

					reviewIndex++ ;
				}


				if(data[i].type == 4){
					add_html += '<li class="movie_item">';
					add_html +=		'<iframe src="" scrolling="no" frameborder="0" allowfullscreen></iframe>';
					add_html +=		'<div class="front_box front_box_bg_' +data[i].goodsno+'">';
					add_html +=			'<button class="btn_movie_open" type="button" value="'+ data[i].external_video_url+'">';
					add_html +=				'<img src="/shop/web/images/common/btn_movie_open.png" alt="play">';
					add_html +=			'</button>';
					add_html +=			'<div class="prod_box">';
					add_html +=				'<a href="'+ goods_src + data[i].goodsno+'">';
					add_html +=					'<div class="img_con">'+data[i].goodsimg_cst+'</div>';
					add_html +=					'<div class="info_con">';
					add_html +=						'<div class="prod_name">'+ data[i].goodsnm+'</div>';
					add_html +=						'<div class="prod_option">'+ data[i].ex1.substring(0,40)+'</div>';
					add_html +=						'<div class="prod_cost">';
														if(!data[i].strprice){
															if( data[i].price){
																//if( data[i].consumer > 0)
																	//add_html += '<span class="before_cost"><span>'+comma(data[i].consumer)+'</span>원</span>';
																add_html += '<span>'+comma(data[i].price)+'</span>원';
															}
															if( data[i].soldout_price_string)	add_html += '<span>'+data[i].soldout_price_string+'</span>';
															if( data[i].soldout_price_image)	add_html += '<span>'+data[i].soldout_price_image+'</span>';
														} else
														add_html += data[i].strprice;
					add_html +=						'</div>';
					add_html +=					'</div>';
					add_html +=				'</a>';
					add_html +=			'</div>';
					add_html +=		'</div>';
					add_html +=		'<div class="tag_box">';
					add_html +=			'<img class="tag_country" src="/shop/web/images/common/tag_prod_country.gif" alt="전국최고" />';
					add_html +=		'</div>';
					add_html +=		'<button type="button" class="btn_close_movie"><img src="/shop/web/images/common/btn_close_topbanner.png" alt="close movie"></button>';
					add_html += '</li>';

				}else{
					if(data[i].type != 3){
						if(data[i].thebest == 1)
							add_html += '<li class="prod_item item_type1 country_prod_item">';
						else
							add_html += '<li class="prod_item item_type1">';

					}else
						add_html += '<li class="prod_item item_type2">';

					add_html +=		'<div class="top_box">';
					add_html +=			'<a class="prod_anchor" href="'+ goods_src + data[i].goodsno+'" title="'+ data[i].goodsnm+'">';
					add_html +=				'<div class="img_box">';

					add_html +=					'<div class="back">'+ data[i].goodsimg_nt+'</div>';

					if(data[i].thebest != 1 || data[i].type == 3)
						add_html +=				'<div class="front">'+ data[i].goodsimg_ct+'</div>';
					else
						add_html +=				'<div class="front">'+ data[i].goodsimg_ct+'</div>';

					add_html +=				'</div>';
					add_html +=				'<div class="tag_box">';

					if(data[i].thebest == 1)							
						add_html +=				'<img class="tag_country" src="/shop/web/images/common/tag_prod_country.gif" alt="전국최고" />';
					
					if(data[i].today_deli == 1)
						add_html +=				'<img src="/shop/web/images/common/tag_prod_fresh.gif" alt="오늘수확" />';

					if(data[i].goods_new == 1)
						add_html +=				'<img src="/shop/web/images/common/tag_prod_new.gif" alt="new" />';

					add_html +=				'</div>';

					if(data[i].ex5 && data[i].ex5.indexOf('dc') > 0)
						add_html +=			'<div class="sale_box"><span>'+data[i].ex5.replace(/dc/,'')+'</span>%</div>';

					if(data[i].thebest == 1 && data[i].type != 3){
						add_html +=			'<div class="master_box">';
						add_html +=				'<div class="master_icon">'+ data[i].goodsimg_person+'</div>';
						add_html +=			'</div>';
					}

					if(data[i].runout == 1){
						if( data[i].usestock == 'o' && data[i].buyrunout == 1){
							add_html +=		'<div class="soldout_option">입고예정, 1~2일 지연 배송상품</div>';
						}else{
							add_html +=		'<div class="soldout_con"></div>';
						}
					}

					add_html +=			'</a>';

					if(data[i].runout != 1 || (data[i].runout == 1 && data[i].usestock == 'o' && data[i].buyrunout == 1)){
						add_html +=		'<div class="btn_box">';
						add_html +=			'<button type="button" class="btn_cart_p" data-goodsno="'+ data[i].goodsno+'" data-opt="'+ data[i].moredata.opt1+'" data-type="list" data-goodsnm="'+ data[i].goodsnm+'" data-ea="1">카트에 담기</button>';
						add_html +=			'<button type="button" class="btn_cart_m" data-goodsno="'+ data[i].goodsno+'" data-opt="'+ data[i].moredata.opt1+'" data-type="list" data-goodsnm="'+ data[i].goodsnm+'" data-ea="-1">카트에서 빼기</button>';
						add_html +=		'</div>';
					}

					add_html +=		'</div>';
					add_html +=		'<div class="bot_box">';
					add_html +=			'<div class="prod_name">';
					add_html +=				'<a href="'+ goods_src + data[i].goodsno+'">'+ data[i].goodsnm+'</a>';
					add_html +=			'</div>';
					add_html +=			'<div class="prod_option">';
					add_html +=				'<div class="grade_box">';
											for(var y=0; y<5; y++) {
												if((y + 1) <= data[i].moredata.avg_point)
													add_html +=	'<span class="full"></span>';
												else if((y + 1) > data[i].moredata.avg_point && y < data[i].moredata.avg_point)
													add_html +=	'<span class="half"></span>';
												else
													add_html +=	'<span class="empty"></span>';
											}
					add_html +=				'</div>';
					add_html +=				'<span class="grade_count"><span>'+ data[i].moredata.review_cnt+'</span>건</span>';

					if(data[i].deli_type != 1)
						add_html +=			'<img class="tag_delivery" src="/shop/web/images/common/ico_prod_delivery.png" alt="개별배송" />';

					add_html +=			'</div>';
					add_html +=			'<div class="cost_box">';
					add_html +=				'<span class="prod_standard">'+data[i].ex1.substring(0,40)+'</span>';

											if(!data[i].strprice){
												if( data[i].price){
													if( data[i].consumer > 0)
														add_html += '<span class="before_cost"><span>'+comma(data[i].consumer)+'</span>원</span>';

													add_html += '<span class="after_cost"><span>'+comma(data[i].price)+'</span>원</span>';
												}
												if( data[i].soldout_price_string)	add_html += '<span class="after_cost">'+data[i].soldout_price_string+'</span>';
												if( data[i].soldout_price_image)	add_html += '<span class="after_cost">'+data[i].soldout_price_image+'</span>';

											}else
											add_html += data[i].strprice;

					add_html +=			'</div>';
					add_html +=		'</div>';
					add_html += '</li>';
				}
				var $appendItem = $(add_html);
				$('#allprod_section .prod_list').append($appendItem).isotope( 'appended', $appendItem );
			}
		}

		$('#allprod_section').find('.item_type1').off("hover");

		// $('#allprod_section').find('.item_type1').hover(function (){
		// 	$(this).find('.back').stop().animate({left:'-185'},2000);
		// },function (){
		// 	$(this).find('.back').stop().css({left:'0'});
		// });

		if(currPage == totalPage){
			currCategoryIndex++;
			currPage = 1;

		}else{
			currPage++;
		}

	}

});

function masking( value){
	if(value && value.length > 0){
		var temp = value.substring(0,2);
		var tempsize = value.length - 2;

		if(value.length == 3){
			temp = value.substring(0,1);
			tempsize = 2;
		}

		if(value.length == 2){
			temp = value.substring(0,1);
			tempsize = 1;
		}

		for(var i = 0; i < tempsize; i++){
			temp += "*";
		}
		return temp;
	}
	return value;
}

