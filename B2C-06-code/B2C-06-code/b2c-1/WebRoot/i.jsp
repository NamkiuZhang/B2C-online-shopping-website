<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'i.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


	</head>

	<body>
		<form action="servlet/CartServlet" method="post">
		p_id:
		<input type="text" name="selectid" value="43" />
		quantity:
		<input type="text" name="quant" value="4" />
	    
		<input type="submit" name="addtocartbyuser" value="注册用户" />
	
		</form>
		<form action="servlet/CartServlet" method="post">
		p_id:
		<input type="text" name="selectid" value="21" />
		quantity:
		<input type="text" name="quant" value="4" />
	
		<input type="submit" name="addtocartbytour" value="游客" />
		
		</form>
		<a href="servlet/CartServlet?action=ls">查看购物车</a>
		<a href="servlet/OrderServlet?a=ls">orders</a>
       
	</body>
</html>
