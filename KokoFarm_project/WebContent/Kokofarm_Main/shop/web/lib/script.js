
document.createElement('header');
document.createElement('nav');
document.createElement('article');
document.createElement('section');
document.createElement('aside');
document.createElement('footer');

var userAgt=navigator.userAgent;
var topbanner_H;
var scrollTop;

function setPlanlist(){
	if ( $(window).width() > 1624 ){ 
		var plans_list_wrap_H;
		if ( scrollTop < topbanner_H){
			plans_list_wrap_H = $(window).height() - (
				topbanner_H // top banner
				+ 36 // util menu
				+ 150 // logo
				+ 64 // search box
				+ 42 // all menu
				+ $('.menu_category').height()
			);
			$('.plans_list_wrap').height(plans_list_wrap_H + scrollTop);
		}else{
			plans_list_wrap_H = $(window).height() - (
				36 // util menu
				+ 150 // logo
				+ 64 // search box
				+ 42 // all menu
				+ $('.menu_category').height()
			);
			$('.plans_list_wrap').height(plans_list_wrap_H);
		}

		$('.plans_list_wrap').mCustomScrollbar({
			theme : "planList"
			,autoHideScrollbar : true
		});
	}else{
		$('.plans_list_wrap').mCustomScrollbar('destroy');
		$('.plans_list_wrap').css('height','auto');
	}
}

// 결제취소 후 다시결제  권혁기 2016.05.24
function resettle(){

	var resettle = parent.document.getElementById('resettle');
	var buyProgessbar = parent.document.getElementById('buyProgessbar');

	alert("결제를 취소하셨습니다.\n\n 다시결제하기 버튼을 클릭하면 다시결제가 가능합니다.");

	$(buyProgessbar).removeClass('on');

	$(resettle).css('display','inline-block');

}

function setGnb(){
	scrollTop = $(window).scrollTop();

	if ( scrollTop > topbanner_H ){
		$('.in_head').addClass('scSetW1 scSetS1');
		$('.utile_area').addClass('scSetS1');
	}else{
		$('.in_head').removeClass('scSetW1 scSetS1');
		$('.utile_area').removeClass('scSetS1');
	}
	if ( scrollTop > topbanner_H + 75){ // 75 is gnb height
		$('.in_head').addClass('scSetS2');
		$('.main_logo').addClass('scSetS1');
		$('.menu_all').addClass('scSetS1');
		$('.gnb').addClass('scSetS1');
		$('.header').addClass('scSetS2');
	}else{
		$('.in_head').removeClass('scSetS2');
		$('.main_logo').removeClass('scSetS1');
		$('.menu_all').removeClass('scSetS1');
		$('.gnb').removeClass('scSetS1');
		$('.header').removeClass('scSetS2');
	}
}


/* 신규 쿠키 생성 */
	function setCookieSbg(cname,cvalue,exdays) {
		var d = new Date();
		d.setTime(d.getTime() + (exdays*24*60*60*1000));
		var expires = "expires=" + d.toGMTString();
		document.cookie = cname+"="+cvalue+"; "+expires+"; path=/";
	}

	function getCookieSbg(cname) {
		var name = cname + "=";
		var ca = document.cookie.split(';');
		for(var i=0; i<ca.length; i++) {
			var c = ca[i];
			while (c.charAt(0)==' ') c = c.substring(1);
			if (c.indexOf(name) == 0) {
				return c.substring(name.length, c.length);
			}
		}
		return "";
	}

	function frmMake(url,frmName,title,ipin){
		
	  //       var _font = ipin === true?'28':'20';
	  //       //var _height = $("#wrap").innerHeight() + $("#footer").innerHeight();
	  //       var _height = window.screen.availHeight;
	  //       var _frm = "<div id='frmMask' onclick=\"frmMaskRemove('" + frmName + "')\"></div>";
	  //       _frm+="<div id='" + frmName + "_area' class='mobileLayerArea' name='" + frmName + "_area'>";
	  //       if (title)
	  //               _frm += "<div id='frmTitle' name='frmTitle' style='font-size:" + _font + "px;'>"+title+"<div id='frmClose' onclick=\"frmMaskRemove('" + frmName + "')\"></div></div>";
	  //       _frm += "<iframe id='" + frmName + "' class='mobileLayerFrame' name='" + frmName + "' src='" + url + "'></iframe>";
	  //       _frm += "</div>";

	  //       $("body").append(_frm);
			// $('html,body').addClass('popon');
	}

	/*
	오픈한 레이어프레임을 닫음
	function frmMaskRemove(레이어 프레임 이름){
	*/
	function frmMaskRemove(frmName){
	        $("#frmMask").remove();
	        $("#"+frmName+"_area").remove();
	        $("meta[name='viewport']").attr({"content":"user-scalable=yes, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height"});
	}

	// 예약배송 휴일검토 SKT개발자 센터 API -> php function call 
	function chkHolidays(date, freq, cycle){

		chkResultText = "";
		$.ajax({
			url: "../proc/holiday_chk.php",
			type: 'post',
			cache:false,
			async: false,
			dataType : 'JSON',
			data: {
				"date" : date,
				"freq" : freq,
				"cycle" : cycle
			},
			success: function (data){
				// console.log(data);
				if(data.length > 0){
					for(i=0;i<data.length;i++){
						var chkHolidaysResult = data[i];
						var chkResultMonth = chkHolidaysResult.slice(5, 7);
						var chkResultDay = chkHolidaysResult.slice(8, chkHolidaysResult.length);
						chkResultText = chkResultMonth+"월"+" " +chkResultDay+"일은 공휴일로 예약배송주문이 불가합니다. \n배송횟수 또는 받는주기를 변경해주세요.";
					}
				}else{
					chk_holidays = "N";
				}
			},
			fail: function (e){
				console.log(e);
			}
		});
		return chkResultText;
	}

	/*  layer popup */
	/* 레이엎팝업 함수 - frmMake생성 2016.08.25 권혁기*/
	/* 웹버전이기 때문에 이미지와 동영상만 레이어팝으로 사용할 것이며, 동영상은 기존소스로 사용하고 추가시에 통합으로 사용한다. */
	/* 기본은 이미지레이어 팝업 용도와 DOM을 기본으로 제작함  */
	function popMaker(popName, title, type, pathUrl){	//파라미터(팝업이름, 팝업내용/형식(image or htmlDom))
		var output = "";
		if(!type) type = 'htmlDom';
		if( type === 'image'){
			var img = new Image();
			img.src = pathUrl;
			// console.log("aaaaa");
			img.onload = function(){
				// console.log("bbbbb");
				output += '<div class="layer_pop" id="'+popName+'" onClick="popRemover('+popName+')" style="margin: -'+img.height/2 +'px 0 0 -'+img.width/2+'px">';
				output += 		'<img src="'+pathUrl+'" >';
				output += '</div>';
				// console.log("cccccc");
				$('body').append(output);
			}
		}else{
			// htmlDom 일때 
			console.log(popName);
			console.log(type);
			console.log(pathUrl);
		}
		// console.log("dddddd");
		$('.background_layer').fadeIn();

		// $(output).on('click',function(){

		// });
	}

	/*
	오픈한 레이어프레임을 닫음
	function frmMaskRemove(레이어 프레임 이름){
	*/
	function popRemover(popName){
		$(popName).remove();
		$('.background_layer').fadeOut();
	}


// common
$(function() {


	if (userAgt.indexOf('safari')){
		//$('head').append('<link rel="stylesheet" href="/shop/web/css/style_safari.css">');
	}

	//$.srSmoothscroll({step: 100,speed: 600});

	$(window).load(function (){
		// Gnb seting
		topbanner_H = $('.topbanner').outerHeight();
		setGnb();
		setPlanlist();

	}); // window load


	$(window).scroll(function (){
		scrollTop = $(window).scrollTop();
		setGnb();
		setPlanlist();
	}); // window scroll



	$(window).resize(function (){
		setPlanlist();
	}); // window resize


	// search box open
		$('.open_search').click(function (){
			if ( !$(this).data('click') ){
				$('.search_box').animate({right:'-300px'},400,'easeOutExpo');
				$(this).data('click',1).text('닫기').addClass('on');
			}else{
				$('.search_box').animate({right:'0'},400,'easeOutExpo');
				$(this).data('click',0).text('검색').removeClass('on');
			}
		});

	// play moview
		/*$('.container').on('click','.btn_movie_open',function (){
			var movieUrl = $(this).val();
			var fornt_box = $(this).parent();
			fornt_box.siblings('.btn_close_movie').show();
			fornt_box.fadeOut();
			fornt_box.siblings('iframe').attr('src',movieUrl);
		});
		$('.container').on('click','.btn_close_movie',function (){
			$(this).siblings('iframe').attr('src','');
			$(this).siblings('.front_box').fadeIn();
			$(this).hide();
		});*/

		$('.container').on('click','.btn_movie_open',function (){
			var movieUrl = $(this).val();
			$('.background_layer').fadeIn();
			$('.movie_popup').show();
			$('.movie_popup .movie_box iframe').attr('src',movieUrl);
			$('.movie_popup').find('.prod_item').eq(0).show();
		});
		$('.movie_popup').on('click','.btn_close_movie',function (){
			$('.background_layer').fadeOut();
			$('.movie_popup').hide();
			$('.movie_popup .movie_box iframe').attr('src','')
		});
		// $('.background_layer').click(function (){
		// 	$('.background_layer').fadeOut();
		// 	$('.movie_popup').hide();
		// 	$('.movie_popup .movie_box iframe').attr('src','')
		// });

	// 상품리스트 hover 기능 삭제 노재훈 요청. 2016.05.09
	// prod item type1 hover event
		// $('.item_type1').hover(function (){
		// 	$(this).find('.back').stop().animate({left:'-185'},2000);
		// },function (){
		// 	$(this).find('.back').stop().css({left:'0'});
		// });

	// input click check
		$('.ch_label').click(function (){
			var $label = $(this);
			if ( $label.find("input").is(":checked")){
				$label.addClass('on');
			}else{
				$label.removeClass('on');
			}
		});

		$('.rd_label').click(function (){
			$(this).siblings('label').removeClass('on');
			$(this).addClass('on');
		});

	$('.pop_btn_close').on('click', function(){
		var targetVal = $(this).data('parents');
		
		if(targetVal){
			$('.'+targetVal).hide();
			$('.background_layer').hide();
		}


	});

});


/* 파라미터 스트링 추출 2015-11-24 */
	var pamalChUrl = window.location.href;
	if (pamalChUrl.indexOf('goods_search') == -1){ // goods_search 에서는 비활성화
		(function($) {
			$.QueryString = (function(a) {
				if (a == "") return {};
				var b = {};
				for (var i = 0; i < a.length; i++){
					var p=a[i].split('=');
					if (p.length != 2) continue;
					b[p[0]] = decodeURIComponent(p[1].replace(/\+/g, " ")); //공백으로 변환 후 디코딩
				}
				return b;
			})(window.location.search.substr(1).split('&')) //파라미터 정보만 분리
		})(jQuery);
	}

