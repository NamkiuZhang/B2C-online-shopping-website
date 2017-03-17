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

		<title>My JSP 'addProduct.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="./CSS/styles.css">
		<script language="javascript" src="js/zmj.js"></script>
	
		<style>
#addProduct {
	background: #e8e8e8;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	padding: 5px;
	margin: 0 auto 55px 50px;
	position: relative;
	float: left;
}

#addProduct  .mc {
	border: 1px solid #e1e1e1;
	background: #ffffff;
	height: 500px;
}

#addProduct  .form {
	float: left;
	width: 500px;
	position: relative;
	top: 20px;
}

#addProduct  .item {
	padding-top: 9px;
	height: 55px;
	line-height: 34px;
	position: relative;
	z-index: 1;
}

#addProduct  .label {
	width: 190px;
	text-align: right;
	font-size: 14px;
	padding-right: 10px;
}

#addProduct  .label b {
	font-family: "????";
	margin-right: 5px;
	font-weight: normal;
	color: #F00;
}

#addProduct  .text {
	width: 238px;
	height: 16px;
	padding: 10px 2px 10px 5px;
	border: 1px solid #cccccc;
	float: none;
	font-size: 14px;
	font-family: arial, "����";
	color: #999;
}

form {
	display: inline;
}

.content1 {
	padding: 0;
	width: 700px;
	height: 700px;
	float: left;
	border: 1px solid #cccccc;
}
</style>

		<script>

</script>
	</head>

	<body>
		<jsp:include page="top.jsp"></jsp:include>
		<div class="w">
			<jsp:include page="left.jsp"></jsp:include>

			<div id="addProduct" class="content1">
				<h1
					style="color: #1FD1B7; font-family: '微软雅黑'; font-size: 30px; margin-left: 50px">
					添加商品
				</h1>
				<br>
				<form method="post" enctype="multipart/form-data"
					action="fup.servlet">
					<div class="item">
						<span class="label"><b>*</b>请选取商品图片:</span>
						<input type="file" name="upfile" />
						<input type="submit" value="upload" name="add"/>
					</div>
				</form>
				<br>
				<form action="product.servlet?action=addProduct" method="post">
					<div class="item">
						<span class="label"><b>*</b>商品图片路径：</span>
						<input readonly name="img" value="${ requestScope.imgUrl }"  id="img" onblur="checkProPicPath()"/>
						<span id="tip6"></span>
					</div>
					<div class="item">
						<span class="label"><b>*</b>商品名称：</span>
						<input name="productName" id="productName" type="text"  onblur="checkProductName()"/>
						<span id="tip1"></span>
						<br>
					</div>
					<div class="item">
						<span class="label"><b>*</b>单价：</span>
						<input name="price" id="price" type="text" onblur="checkProPrice()"/>
						<span id="tip5"></span>
						<br>
					</div>
					<div class="item">
						<span class="label"><b>*</b>选择商品分类：</span>
						<select id="firstType" name="firstType"
							onchange="checkFirstType()" onblur="checkSelectFirstType() class="select">
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
						<select id="secondType" name="secondType" onblur="checkSelectSecondType()" class="select">
							<option value="-2">
								请选择二级分类
							</option>
						</select>
						<span id="tip3"></span>
						<br>
					</div>
					<div class="item">
						<span class="label"><b>*</b>添加数量：</span>
						<input name="amount" id="amount" type="text" onblur="checkStorage()" />
						<span id="tip4"></span>
						<br>
					</div>

					<input type="submit"
						style="background: #1FD1B7; border-style: none; width: 120px; height: 35px; background-repeat: no-repeat; font-family: '微软雅黑'; font-size: 16px;"
						value="添加" onclick="return checkAddProduct()" />
				</form>

			</div>
		</div>

	</body>
</html>
