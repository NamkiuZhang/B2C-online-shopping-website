<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>

		<title>My JSP 'productDetails.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script language="javascript" src="js/zmj.js">
</script>
		<script>
function goLast() {
	history.go(-1);
}
</script>

<style>
.content1 {
	padding: 0;
	width: 700px;
	height: 700px;
	float: left;
	border: 1px solid #cccccc;
}
</style>
	</head>

	<body>
		<jsp:include page="top.jsp"></jsp:include>
		<div class="w">
			<jsp:include page="left.jsp"></jsp:include>
			<div id="addManager" class="content1">

				<h1
					style="color: #1FD1B7; font-family: '微软雅黑'; font-size: 30px; margin-left: 50px">
					修改商品信息
				</h1>
				<br>

				<form action="product.servlet?action=updateProductInfo"
					method="post">

					<span> 图片：</span><input  type="hidden" name="img" value="${requestScope.productvo.picPath}"/>
					<span>商品ID:</span>
					<input readonly type="text" name="productId"
						value="${requestScope.productvo.id}" />

					<div class="item">
						<span>商品名称: </span>
						<input type="text" name="pname" id="productName"
							value="${requestScope.productvo.pname}" onblur="checkProductName()"/>
							<span id="tip1"></span>
					</div>

					<div class="item">
						<b>*</b>重新选择商品分类：
						<select id="firstType" name="firstType"
							onchange="checkFirstType()"
							onblur="checkSelectFirstType() class="select">
							<option value="-1">
								请选择一级分类
							</option>
							<c:forEach items="${ applicationScope.lptv }" var="ptv" step="1"
								varStatus="pt">
								<option value="${ptv.id}">
									${ptv.t_name}
								</option>
							</c:forEach>
						</select>
						<span id="tip2"></span>
						<select id="secondType" name="secondType"
							onblur="checkSelectSecondType()" class="select">
							<option value="-2">
								请选择二级分类
							</option>
						</select>
						<span id="tip3"></span>
						<br>
					</div>

					<div class="item">
						<span>单价：</span>
						<input type="text" name="pprice"
							value="${requestScope.productvo.pprice}" onblur="checkProPrice()" id="price"/>
							<span id="tip5"></span>
					</div>

					<div class="item">
						<span>库存量：</span>
						<input type="text" name="storage"
							value="${requestScope.productvo.storage}" onblur="checkStorage()" id="amount"/>
							<span id="tip4"></span>
					</div>

					<div class="item">
						<span>brand：</span>
						<input type="text" name="brand"
							value="${requestScope.productvo.brand}" />
					</div><h2>

					<input type="submit" value="修改" onclick="return checkModProduct()"></h2>
				</form>
			</div>
		</div>

	</body>
</html>

