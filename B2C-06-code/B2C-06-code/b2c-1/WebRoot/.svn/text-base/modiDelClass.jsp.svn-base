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
		<title>My JSP 'modiDelClass.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="./CSS/styles.css">
		<script language="javascript" src="js/zmj.js"></script>
		<script language="javascript" src="js/ajax.js">
</script>
		<!--

	function changee(){
		getXMLHTTPRequest();
		String url = "productType.servlet?action=displaySubmenu";
		
	}
	
	function displaySubmenu(){
		if(xmlHttp.readyState==4){
			var s = xmlHttp.responseText;
			var temp = s.split(";");
			var submenu = document.getElementById("submenu")
			for(var i=0;i<temp.length;i++){
				var option = new Option();
				
			}
		}
	}

-->
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
				<h1>
					修改分类
				</h1>
				<br>
				<div id="greybg">
					<ul>
						<form action="productType.servlet?action=modifyFirstTypeName"
							method="post">
							<li>
								修改一级分类
								<br />
								选择修改的一级分类：
								<select id="firstType1" name="firstType1" class="select">
									<option value="-1">
										请选择一级分类
									</option>
									<c:forEach items="${ applicationScope.lptv }" var="ptv"
										step="1" varStatus="pt">
										<option value="${ptv.id}">
											${ptv.t_name}
										</option>
									</c:forEach>
								</select>
								名称修改为：
								<input type="text" name="type" />
								<br>
								<input type="submit" value="提交" />
								<br>
							</li>
						</form>
						<form action="productType.servlet?action=modifySecondTypeName"
							method="post">
							<li>
								修改二级分类
								<br>
								选择要修改的二级分类：
								<select id="firstType" name="firstType"
									onchange="checkFirstType()" class="select">
									<option value="-1">
										请选择一级分类
									</option>
									<c:forEach items="${ applicationScope.lptv }" var="ptv"
										step="1" varStatus="pt">
										<option value="${ptv.id}">
											${ptv.t_name}
										</option>
									</c:forEach>
								</select>
								<select id="secondType" name="secondType" class="select">
									<option>
										请选择二级分类
									</option>
								</select>
								<br>
								名称修改为：
								<input type="text" name="type" />
								<br>
								<input type="submit" value="提交" />
								<br>
							</li>
						</form>
					</ul>

				</div>


			</div>
		</div>
	</body>
</html>
