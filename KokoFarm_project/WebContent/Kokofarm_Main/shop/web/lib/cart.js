
$(function() {

	$.fn.cart = function( count){
		
		var cartProd_W = 142;
		var $cart_container		= $(this).find("#cart_container");
		var $open_cart_btn		= $(this).find("#open_cart");
		var $cart_prod_list		= $cart_container.find("#cart_prod_list");
		var $cart_total_info	= $cart_container.find("#cart_total_info");
		var $cart_product		= $cart_container.find("#cart_product");
		var $cart_list_table	= $(this).find("#cart_list_table");
		var isCilck = false;

		$(document).on("click", '.btn_cart, .btn_cart_p, .btn_cart_m, .btn_prod_p, .btn_prod_m, #btn_in_cart, .btn_in_cart', function (){
			
			
			if( $(this).hasClass('reload'))
			{
				var goodsData = $(this).getGoodsData();

				$cart_prod_list.addCart(goodsData, true);
			}
			else if($(this).hasClass('refresh'))
			{
				var goodsData = $(this).getGoodsData();
				$cart_prod_list.addCart(goodsData);
			}
			else if(!$(this).hasClass('off'))
			{
				var goodsData = $(this).getGoodsData();

				$cart_prod_list.addCart(goodsData);
			}

		});

		$(document).on("click", '.btn_addCart', function (){
			
			if( $(this).hasClass('reload'))
			{
				var goodsData = $(this).getGoodsData();

				$cart_prod_list.addCart(goodsData, true);
			}
			else if(!$(this).hasClass('off'))
			{
				var goodsData = $(this).getGoodsData();

				$cart_prod_list.addCart(goodsData);
			}

		});


		// cart open
		$open_cart_btn.click(function (){
			if ( !$(this).data('ch') ){
				$(this).data('ch',1).addClass('on');
				$('.cart_area').animate({bottom:'0'},200);
			}else{
				$(this).data('ch',0).removeClass('on');
				if (isCilck == true ){
					$('.cart_area').delay(1500).animate({bottom:'-254px'},200);
				}else{
					$('.cart_area').animate({bottom:'-254px'},200);
				}
				isCilck = false;
			}
		});
		
		$cart_product.mCustomScrollbar({
			axis:"x",
			theme:"cart",
			advanced:{ autoExpandHorizontalScroll:true },
			scrollButtons:{
				enable:true,
				scrollType:"stepped"
			},
			keyboard:{scrollType:"stepped"},
			snapAmount:cartProd_W,
			mouseWheel:{scrollAmount:cartProd_W}
		});

		$.fn.addCart = function( goodsData, isReload)
		{
			goodsData.mode = "addCartAjax";

			$.ajax({
				type: "POST",
				url: "../goods/goods_cart.php",
				data: goodsData,
				dataType: "json"
			}).done(function(obj) {
				
				if(obj.status =="success") 
				{
					cartGAProcess(goodsData.type, goodsData.goodsno);

					if(isReload === true)
						document.location.reload();
					else
					{
						$(this).makeCartItem( obj, goodsData.goodsno);
						

						if ( !$open_cart_btn.data('ch') )
						{	
							isCilck = true;
							$open_cart_btn.click().click();
						}
					}
									
				} else if(obj.msg) {
					var tst_msg = obj.msg.split('@@');
					if(tst_msg[0] == 'CONFIRM') {
						var r_msg = tst_msg[1].split('|');
						if(confirm(r_msg[0])) location.href= r_msg[1];
						
					}
					else alert(obj.msg);
				}
				
			}).fail(function(){
				popup_msg("잠시 후 다시시도해주세요.", e ,'red');
			});
		};

		$.fn.makeCartItem = function( obj, goodsno){

			$cart_prod_list.empty();

			if(obj.items.length > 0)
			{
				
				$(obj.items).each(function(i, cart_item){
					var tag = '';
						tag+='<li class="cart_prod">';
						tag+='<div class="prod_box">';
						tag+='<div class="img_con">';
						//tag+='<a href="../goods/goods_view.php?goodsno='+ this.goodsno +'" id="itemno_'+ this.goodsno +'"><img src="' + this.img + '" title="' + this.goodsnm + '"  class="mCS_img_loaded"></a>';
						tag+='<a href="../goods/goods_view.php?goodsno='+ this.goodsno +'" id="itemno_'+ this.goodsno +'">' + this.cart_img + '</a>';
						tag+='</div>';
						tag+='<div class="bot_con">';
						tag+='<div class="cnt_box">';
						tag+='<span>수량</span>';
						tag+='<input type="text" class="prod_cnt" readonly="readonly" value="' + comma(this.ea) + '">';
						tag+='</div>';
						tag+='<div class="btn_box">';
						tag+='<div class="btn_prod_box btn_top_box"><button class="btn_prod btn_prod_p" data-goodsno="' + this.goodsno + '" data-opt="' + this.opt1 + '" data-type="cart" data-goodsnm="' + this.goodsnm + '" data-ea="1" type="button">추가</button></div>';
						tag+='<div class="btn_prod_box btn_bot_box"><button class="btn_prod btn_prod_m" data-goodsno="' + this.goodsno + '" data-opt="' + this.opt1 + '" data-type="cart" data-goodsnm="' + this.goodsnm + '" data-ea="-1" type="button">감소</button></div>';
						tag+='</div>';
						tag+='</div>';
						tag+='</div>';
						tag+='<div class="prod_cost_box">';
						tag+='<span class="prod_cost">' + comma(this.price*this.ea) + '</span><span class="yg76">원</span>';
						tag+='</div>';
						tag+='</li>';
						$cart_prod_list.append(tag);
				});
			}

			cartBgSet();

			$("#cart_cnt_box").text(comma(obj.items.length));
			

			//console.log("#itemno_" + goodsno);
			$cart_product.mCustomScrollbar("scrollTo", $("#itemno_" + goodsno));



			$cart_total_info.find("#cart_prod_total").text( comma(obj.goodsprice));
			$cart_total_info.find("#cart_deli_total").text( comma(obj.delivery));
			$cart_total_info.find("#cart_settle_total").text( comma(parseInt(obj.goodsprice) + parseInt(obj.delivery)));

			
		}

		$(window).resize(function (){
			cartBgSet();
		}); // window resize

		function cartBgSet(){

			var cartProd_num = $cart_prod_list.find('.cart_prod').length;

			if ( $(window).width() > 1624 ){ 
				if (cartProd_num > 5){
					$cart_product.addClass('over');
				}else{
					$cart_product.removeClass('over');
				}
			}else{
				if (cartProd_num > 3){
					$cart_product.addClass('over');
				}else{
					$cart_product.removeClass('over');
				}
			}

			$cart_prod_list.width(cartProd_W * cartProd_num);
			//$open_cart_btn.click();
		}

		// top btn
		$('#btn_top').click(function (){
			$('html,body').animate({scrollTop:'0'},400);
		});

		function init()
		{
			$.ajax({
				type: "POST",
				url: "../goods/goods_cart.php",
				data: {
					"mode": 'getCartItems'
				},
				dataType: "json"
			}).done(function(obj) {
				if(obj.status =="success") 
				{
					$(document).makeCartItem( obj);
				} else if(obj.msg) {
					alert(obj.msg);
				}
			}).fail(function(){
				popup_msg("잠시 후 다시시도해주세요.", e ,'red');
			});
		}

		init();
	}; // end cart plugin

	
	$.fn.getGoodsData = function(){

		return {
					"goodsno":$(this).attr("data-goodsno"),
					"opt":[$(this).attr("data-opt"),''],
					"type":$(this).attr("data-type"),
					"goodsnm":$(this).attr("data-goodsnm"),
					"ea": $(this).attr("data-ea")
				};
	};

	

});


function cartGAProcess( type, goodsno)
{
	if(type == 'main'){
		ga('send', 'event', '메인화면','장바구니', goodsno);
	}else if(type == 'list'){
		ga('send', 'event', '상품목록','장바구니', goodsno);
	}else if(type == 'search'){
		ga('send', 'event', '상품검색','장바구니', goodsno);
	}else if(type == 'blist'){
		ga('send', 'event', '상품목록베스트','장바구니', goodsno);
	}else if(type == 'slist'){
		ga('send', 'event', '상품목록서브베스트','장바구니', goodsno);
	}else if(type == 'goods'){
		ga('send', 'event', '상품상세페이지','장바구니', goodsno);
	}else if(type == 'cart'){
		ga('send', 'event', '장바구니','장바구니', goodsno);
	}else if(type == 'cart_best'){
		ga('send', 'event', '장바구니베스트','장바구니', goodsno);
	}else if(type == 'time'){
		ga('send', 'event', '타임세일','장바구니', goodsno);
	}
};



