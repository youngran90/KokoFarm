<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KokoFarm</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script src="jquery.js" type="text/javascript"></script>

<link href="/KokoFarm_project/Kokofarm_Main/shop/web/images/common/favicon.ico" rel="shortcut icon">
<link href="/KokoFarm_project/Kokofarm_Main/shop/web/css/font2.css" rel="stylesheet">
<link href="/KokoFarm_project/Kokofarm_Main/shop/web/css/jquery.mCustomScrollbar.css" rel="stylesheet">
<link href="/KokoFarm_project/Kokofarm_Main/shop/web/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="/KokoFarm_project/Kokofarm_Main/slider/flexslider.css" type="text/css">

<script type="text/javascript" charset="utf-8">
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation : "slide"
		});
	});
</script>

<script src="shop/web/lib/jquery-1.11.3.min.js"></script>
<script src="shop/web/lib/jquery-ui.js"></script>
<script src="slider/jquery.flexslider.js"></script>
<script src="shop/web/lib/isotope.pkgd.min.js"></script>
<script src="shop/web/lib/jquery.mCustomScrollbar.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery-mousewheel/3.1.12/jquery.mousewheel.min.js"></script>
<script src="shop/web/lib/script.js"></script>
<script src="shop/web/lib/prefixfree.min.js"></script>
<script src="shop/web/lib/cart.js"></script>
<script src="shop/web/lib/dashboard.js"></script>
<script src="shop/web/lib/osinfo.js"></script>
<script src="shop/web/lib/IE9_fix_for_imagesLoaded_plugin_issue.js"></script>
<script src="shop/data/skin/renew/jquery.slides.js"></script>
<script src="shop/data/skin/renew/common.js"></script>
<script src="shop/data/skin/renew/cart_tab/godo.cart_tab.js"></script>
<script src="shop/web/lib/countdown.js"></script>
<!-- 카카오 API링크 -->
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<!--// 카카오 API링크 -->

<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();a = s.createElement(o),
		m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

	ga('create', 'UA-28184252-1', 'auto');
	ga('require', 'linkid', '//www.google-analytics.com/plugins/ua/linkid.js');
	ga('require', 'displayfeatures');

	ga('send', 'pageview');
</script>


<script>
	(function(d, a, b, l, e, _) {
		d[b] = d[b] || function() {
			(d[b].q = d[b].q || []).push(arguments)
		};
		e = a.createElement(l);
		e.async = 1;
		e.charset = 'utf-8';
		e.src = '//static.dable.io/dist/plugin.min.js';
		_ = a.getElementsByTagName(l)[0];_.parentNode.insertBefore(e, _);
	})(window, document, 'dable', 'script');
	dable('setService', 'hellonature.net');
	dable('sendMallLog', 'godomall');
</script>

</head>



<body ondragstart="return false" onselectstart="return false"
	oncontextmenu="return false">
	<div class="wrapper">
		
		<div class="container" id="hn_container">
		
				<div class="content_area">
			
			
			
				</div>	<!-- content_area  -->
			
			
			
			
			
		</div><!--//container-->

		<footer class="footer">
		<div class="footer_wrap">
			<div class="footer_info_box">
				<ul class="company_menu_list">
					<li><a href="/shop/service/company_intro01.php"><span>회사소개</span></a></li>
					<li><a href="/shop/board/list.php?id=recruit"><span>채용</span></a></li>
					<li><a href="/shop/service/company_intro02.php"><span>입점
								· 제휴</span></a></li>
					<li><a href="/shop/service/agreement.php"><span>이용약관</span></a></li>
					<li><a href="/shop/service/agreement_privacy.php"><span>개인정보처리방침</span></a></li>
					<li><a href="shop/service/sitemap.php"><span>서비스맵</span></a></li>
				</ul>
				<div class="company_info">
					<span>(주)코코팜 대표이사 박동훈</span> <span>사업자등록번호 105-87-66628</span> <span>통신판매업신고번호
						제2012-서울강남-02931호</span> <span>개인정보관리자 박동훈 help@hellonature.net</span>
				</div>
				<address>서울특별시 강남구 언주로79길 12, 2층 (역삼동) 우.135-080 | 고객센터 :
					1644-4339 (광고전화 수신거부) | 팩스 : 02-6280-1360</address>
				<div class="copyright">Copyright(c) 2012 헬로네이처. All right
					reserved</div>
				<div class="certification_box">
					<a
						href="https://mark.inicis.com/mark/escrow_popup.php?no=53917&amp;st=1397617269"
						target="_blank"><img alt="이니페이 에스크로"
						src="shop/web/images/common/ico_certification1.gif"></a> <a
						href="http://ftc.go.kr/info/bizinfo/communicationView.jsp?apv_perm_no=2012322016230202931&amp;area1=&amp;area2=&amp;currpage=1&amp;searchKey=03&amp;searchVal=%B9%DA%BA%B4%BF%AD&amp;stdate=&amp;enddate="
						target="_blank"><img alt="통신판매사업자"
						src="shop/web/images/common/ico_certification2.gif"></a>
				</div>

				<aside class="share_link"> <a
					href="https://www.instagram.com/hello._.nature/" target="_blank"><img
					title="instagram" alt="instagram"
					src="shop/web/images/common/link_instagram.gif"></a> <a
					href="http://facebook.com/HelloNature" target="_blank"><img
					title="facebook" alt="facebook"
					src="shop/web/images/common/link_facebook.gif"></a> <!-- <a target="_blank" href="http://twitter.com/HelloNatureNet"><img src="shop/web/images/common/link_twitter.gif" alt="twitter" title="twitter"></a> -->
				<a href="https://story.kakao.com/ch/hellonature/app" target="_blank"><img
					title="kakao story" alt="kakao story"
					src="shop/web/images/common/link_kakaos.gif"></a> <a
					href="http://blog.naver.com/hnblog" target="_blank"><img
					title="blog" alt="blog" src="shop/web/images/common/link_blog.gif"></a>
				</aside>
			</div>
		</div>
		</footer>
		<!--//footer-->

	</div>
	<!-- wrapper -->

	<div class="load_ajax">
		<img alt="" src="shop/web/images/common/loader.svg">
	</div>

</body>
</html>