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

<title>My JSP 'listType.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script language="javascript" src="js/zmj.js"></script>

</head>

<body>

	<ul  id="firstType" >
	<li value="-1">请选择一级分类</li>
	<c:forEach items="${ applicationScope.lptv }" var="ptv" step="1" varStatus="pt">
			<li value="${ptv.id}"><a href="javascrip:checkFirstType()">${ptv.t_name}</a></li>
		</c:forEach>
	</ul>
	<ul id="secondType">
	<li>请选择二级分类</li>
	</ul>

	<select id="firstType" name="firstType" onchange="checkFirstType()" class="select">
		<option value="-1">请选择一级分类</option>
		<c:forEach items="${ applicationScope.lptv }" var="ptv" step="1" varStatus="pt">
			<option value="${ptv.id}">${ptv.t_name}</option>
		</c:forEach>
	</select>
	<select id="secondType" name="secondType" class="select">
		<option>请选择二级分类</option>
	</select>
</body>
</html>
