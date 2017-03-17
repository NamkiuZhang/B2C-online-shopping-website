<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>My JSP 'myhomesidebar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link style="text/css" href="css/loginstyle.css" rel="stylesheet" />

  </head>
  
  <body>
    <div class="w2">
    	<div class="tit"><a href="myHome.jsp">个人主页</a></div>
    </div>
  <div class="sidebar1">
    <label class="label1">账号管理</label>
    <ul class="nav">
		<li><a href="mpwd.jsp">密码修改</a></li>
    	<li><a href="user.servlet?action=userinfo">个人信息</a></li>
      	<li><a href="address.servlet?action=listaddress">收货地址</a></li>
        <li><a href="#">更多</a></li>
    </ul>
    <!-- end .sidebar1 --></div>
  </body>
</html>
