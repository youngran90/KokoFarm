<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
	
		//체크박스 전체 선택 / 선택 해제 이벤트
		$('#all').on('click', function() {
			var cnt = $('#allcheck:checked').length;
			for(var i=0; i<list_cart.order.length; i++){
				if(cnt == 0){
					list_cart.order[i].checked = true;
				}else if(cnt >0){
					list_cart.order[i].checked = false;
				}
			}
		}); 
		// 선택 이벤트 종료
		
		//체크박스 선택 없이 주문하기 눌렀을때...
		$('#submit_order').on('click',function() {
			for(var i=0; i<list_cart.order.length; i++){
					if(list_cart.order[i].checked == 0 ){
					alert("상품을 선택해주세요.");
					return false; //for문의 break;기능
				}
			}
		}); 
		//체크박스 선택없이 주문하기... 종료
		
		
		// 수량 구하기 
			$(".price").each(function(index){
				var index = index+1; // 반복문 인덱스 (each메소드는 0번째부터 시작한다)
				var price = $(this).attr("value"); // 각 해당하는 값 불러온다.
				
				var price_format = numberFormat(price); //정규화 조건으로 캐스팅
				
				$(this).text(price_format + " 원"); // 가격표 캐스팅
				var total = $('label[name='+index+']').text(price_format + " 원"); //총 금액
				
				$(document).on("click","#up", function(){ //증가버튼
					var cnt = $(this).attr("value"); // 각 버튼 인덱스
					var amount = $('input[name='+cnt+']').val();
					if(index == cnt){
						amount++;
						$('input[name='+cnt+']').val(amount);
						var num1 = price_format.replace(/[^0-9]/g,"");
						var total = num1 * amount; // 총 금액 ( 제품 가격 * 수량)
						var total_price = numberFormat(total); // 총 금액 3자리마다 , 로 다시 정규화
						
						$('label[name='+cnt+']').text(total_price + " 원"); 
					}
				});
				
				$(document).on("click","#down", function(){ //감소버튼
					var cnt = $(this).attr("value"); // 각 버튼 인덱스
					var amount = $('input[name='+cnt+']').val();
					if(index == cnt){
						if( amount < 1){
							alert("0 이하 입력 불가");
						}else{
							amount--;
						}
						var num1 = price_format.replace(/[^0-9]/g,""); //숫자로 정규화 - 제품 가격
						$('input[name='+cnt+']').val(amount);
						var total = num1 * amount; // 총 금액 ( 제품 가격 * 수량)
						var total_price = numberFormat(total); // 총 금액 3자리마다 , 로 다시 정규화 
						
						$('label[name='+cnt+']').text(total_price + " 원");
					}
				});
				
			/* 	$(document).on("ketpress",".product_amount", function(e){ //엔터로 수량 변경
					
					
					if(e.which == 13){
					var cnt = $(this).attr("name"); // 각 텍스트 필드 인덱스
					var amount = $('input[name='+cnt+']').val(); //수량값
					if(index == cnt){
							alert("tttt");	
					 	amount++;
						$('input[name='+cnt+']').val(amount);
						var num1 = price_format.replace(/[^0-9]/g,"");
						var total = num1 * amount; // 총 금액 ( 제품 가격 * 수량)
						var total_price = numberFormat(total); // 총 금액 3자리마다 , 로 다시 정규화
						
						$('label[name='+cnt+']').text(total_price + " 원");  
					}
				}
			}); */
		
			function numberFormat(x) { //3 자리수 마다 , 표시
				return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
			}
			
		})
		
		var cnt = $('.total').length;
		for(var i = 0; i<cnt; i++){
			var sum = $('.total').text();
			alert(sum);
		}
		
		$(.total).each(function(i){
			
		})
		
		
	});

</script>

</head>
<body>
	<h3>장바구니</h3>
	<a href="ActionList.cart?member_id=${member_id }">회원 번호  : ${member_id }</a>&nbsp;&nbsp;
	<table border="1" cellpadding="3">
	<thead align="center"> 
		<tr>
			<td width="90"><button id="all" name="all" onclick="check()">전체선택</button></td>
			<td width="80" style="display: none">숨길항목</td>
			<td width="150">상품명</td>
			<td width="200">배송종류</td>
			<td width="300">배송비</td>
			<td width="200">가격</td>
			<td width="100" colspan="2">수량</td>
			<td width="130">주문금액</td>
			<td width="100">삭제하기</td>
		</tr>
	</thead>
	<thead align="center" id="cart">
		<form action="ActionRoutingCart.cart" method="post" name="list_cart">
			<input type="button" name="delete" onclick="location.href='ActionCartDeleteALL.cart?m_id=${member_id}'" value="전체삭제">
			&nbsp;&nbsp;
			<input type = "submit" value="주문하기" id="submit_order"><br><br>
		<c:forEach var="cart_list" items="${cartlist }" varStatus="status">
			<tr>
					<td><input type="checkbox" id="allcheck" name="order" value ="${cart_list.product_no }"></td>
					<td style="display: none"><input type="hidden" id="product_no" value="${cart_list.product_no }"></td>
					<td><label id="product_name">${cart_list.product_name }</label></td>
					<td><label id="delivery">테스트용~</label></td>
					<td><label id="delivey_price">2,500 원</label></td>
					<td><label id="${status.count}" value="${cart_list.product_price }" class="price">${cart_list.product_price }</label></td>
					<td><input type="text" name="${status.count}" class="product_amount" value="1" readonly="true" style="text-align: center;"></td>
			<td>
					<span id="button_amount">
						<button id="up" name="up" type="button" value="${status.count}">증가</button>
						<button id="down" name="down"  type="button" value="${status.count}">감소</button>
					</span>
			</td>
			<td>
				<label id="total" name="${status.count}" class="total">0</label>
			</td>
			<td>
					<input type="button" name="delete" onclick="location.href='ActionCartDelete.cart?product_no=${cart_list.product_no }'" value="삭제">
			</td>
			</tr>
			</c:forEach>	
			</form>
		</thead>
	</table>
	<br><br>
	<div class = "cart_total">
				<table border="1" width="1150" height="200">
					<thead align="center">
						<tr>
							<td>주문금액</td>
							<td>배송비</td>
							<td>예상 결제 금액</td>
						</tr>
					</thead>
					<thead>
						<tr>
							<th><span id="result_price" name="result_price" >0</span></th>
							<th><span id="result_delivery" name="result_delivery" >0</span></th>
							<th><span id="result_total" name="result_total" >0</span></th>
						</tr>
					</thead>
				</table>
	</div>
</body>
</html> 