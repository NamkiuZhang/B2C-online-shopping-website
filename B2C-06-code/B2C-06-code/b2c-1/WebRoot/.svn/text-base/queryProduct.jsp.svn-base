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


		<title>My JSP 'queryProduct.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<script language="javascript" src="js/zmj.js">
</script>
		<style>
a {
	color: black;
	text-decoration: none;
}

a:hover,a:active,a:focus {
	text-decoration: underline;
	color: #1FD1B7;
}

th {
	width: 200px;;
	align: center;
	background-color: #d3d7d4;
	font-family: "微软雅黑" ；
}

.container {
	height: 700px;
}

#firstline {
	width: 180px;
	height: 50px;
}

td {
	text-align: center;
	line-height: 32px;
}

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
				<span style="color: #1FD1B7; font-size: 24px;">查询商品</span>
				<br/>
				<form style="display: inline;"
					action="product.servlet?action=queryProduct" method="post">
					<span><b style="color: red;">*</b>商品名称：</span>
					<input type="text" name="productName" id="productName"
						onblur="checkProductName()" />
					<span id="tip1"></span>
					<br/>
					<span><b style="color: red;">*</b>选择商品分类：</span>
					<select id="firstType" name="firstType"
							onchange="checkFirstType()" class="select">
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
						<select id="secondType" name="secondType" class="select">
							<option>
								请选择二级分类
							</option>
						</select>
					<span id="tip3"></span>

					<br />
					<div class="item">
						<input type="submit" value="查  询"
							onclick="return checkSearchProduct()"/>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
