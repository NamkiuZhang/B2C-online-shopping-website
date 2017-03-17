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


		<title>My JSP 'addProdClass.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="./CSS/styles.css">

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
				<div id="greybg">
					<form action="productType.servlet?action=addFirstType" method="post">
						<h1>
							添加一级分类
							<br>
						</h1>

						输入一级分类名称：
						<input type="text" name="type" />
						<br>
						<input type="hidden" name="parentId" value="0" />
						<input type="submit" value="添加" />
						<br>
					</form>
					<form action="productType.servlet?action=addSecondType" method="post">
						
						<h1>
							添加二级分类
						</h1>
						<br>
						选择所属一级分类：
						<select id="firstType" name="firstType" class="select">
						<option value="-1">
							请选择一级分类
						</option>
						<c:forEach items="${ applicationScope.lptv }" var="ptv" step="1" varStatus="pt">
							<option value="${ptv.id}">
								${ptv.t_name}
							</option>
						</c:forEach>
					</select>
						<br>
						输入二级分类名称：
						<input type="text" name="type" />
						<br>
						<input type="submit" value="添加" />
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
