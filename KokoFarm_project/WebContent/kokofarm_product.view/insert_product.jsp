<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Product.product" method="post" enctype="multipart/form-data">
		<br>

		<table border="1" cellpadding="0" cellspacing="0">
			<tr height="30" align="center">
				<td width="200">상품이름</td>
				<td width="170"><input type="text" name="product_name"
					size="10"></td>
			</tr>

			<tr height="30" align="center">
				<td width="200">상품단위</td>
				<td width="170"><input type="text" name="product_unit"
					size="10"></td>
			</tr>

			<tr height="30" align="center">
				<td width="200">상품가격</td>
				<td width="170"><input type="text" name="product_price"
					size="10"></td>
			</tr>

			<tr height="30" align="center">
				<td width="200">판매자코드</td>
				<td width="170"><input type="text" name="seller_no" size="10">
				</td>
			</tr>

			<tr height="30" align="center">
				<td width="200">메인사진</td>
				<td width="170"><input type="file" name="mainimage"
					size="10"></td>
			</tr>

			<tr height="30" align="center">
				<td width="200">상세사진</td>
				<td width="170"><input type="file" name="detailimage"
					size="10"></td>
			</tr>

			<tr height="30" align="center">
				<td width="200">제조업자사진</td>
				<td width="170"><input type="file" name="sellerimage"
					size="10"></td>
			</tr>

			<tr height="30">
				<td colspan="4" align="center"><input type="submit"
					value="상품저장">&nbsp;&nbsp; <input type="reset" value="취소">
				</td>
			</tr>
		</table>


	</form>

</body>
</html>