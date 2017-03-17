<%@page import="com.group6.b2c.viewbean.CommentVo"%>
<%@page import="com.group6.b2c.viewbean.ViewProductVo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE HTML>
<html>
  <head>

   <link href="css/product_detail.css" type="text/css" rel="stylesheet">
   <link href="css/shou.css" rel="stylesheet" type="text/css" />
      
      <link href="css/style.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="js/ajax.js">
  </script>
   <script type="text/javascript" src="js/index.js">
  </script>
  <script type="text/javascript" src="js/loadlist_detail.js">
  </script>
  <script type="text/javascript" src="js/product_detail.js">
  </script>

  </head>
  <body onload="loadList_Detail()">
     <div id="top">
	    <div id="top_left">
	    <c:if test="${empty  user }">
	    <a class="topElem"  onmouseover="over_topElem()" onmouseout="out_topElem()" href="login.jsp" id="username">登录</a> 
	     <a class="topElem"  onmouseover="over_topElem()" onmouseout="out_topElem()" href="register.jsp">注册</a>
	     </c:if>
	     <c:if test="${not empty  user }"><span id="username">${sessionScope.user }</span>,欢迎来到Aditu&nbsp
	     <a class="topElem" href="user.servlet?action=logout">安全退出</a>
	     </c:if>
	     </div>
	    
	    <div id="top_right">
	          
	             <span  class="topElem" > 购物车共有    ${inumber }  件商品</span>
	            
	    <img onmouseover="over_cart()" onmouseout="out_cart()" onmouseup="up_cart()" src="imgs/shoppingBasket.png"/>

	    <c:if test="${not empty  user }"><a class="topElem"  onmouseover="over_topElem()" onmouseout="out_topElem()" href="myHome.jsp">个人中心</a></c:if>
	
	    <a class="topElem"  onmouseover="over_topElem()" onmouseout="out_topElem()" href="javascript:up_myorder()">我的订单</a></div>

    
    </div>
    <div id="head">
	    <div id="logo">
	   
	 
	   
	    <a href="index.jsp"><img src="imgs/logo.png"/></a>
	    </div>
	    <div id="search">
		    <form method="post" >
		    	<input id="search_input" type="text" />		    
		    	<input onmouseout="out_search()" onmouseover="over_search()" onmouseup="up_search()" id="search_btn" type="button" value="搜索"/>
		    </form>		 
	    </div>
	    <div id="product_class">
		    <ul id="first_class">
			    <li><a href="index.jsp" onmouseover="over_menu()" onmouseout="out_menu()">首页</a></li>
			    <li id="fc1"><a  onmouseover="over_menu(1)" onmouseout="out_menu()" 
			    onmouseup="up_menu(1)"></a></li>
			    <li id="fc2"><a  onmouseover="over_menu(2)" onmouseout="out_menu()" 
			    onmouseup="up_menu(2)"></a></li>
			    <li id="fc3"><a  onmouseover="over_menu(3)" onmouseout="out_menu()" 
			    onmouseup="up_menu(3)"></a></li>
			    <li id="fc4"><a  onmouseover="over_menu(4)" onmouseout="out_menu()" 
			    onmouseup="up_menu(4)"></a></li>
			    <li id="fc5"><a  onmouseover="over_menu(5)" onmouseout="out_menu()" 
			    onmouseup="up_menu(5)"></a></li>
			    <li id="fc6"><a  onmouseover="over_menu(6)" onmouseout="out_menu()" 
			    onmouseup="up_menu(6)"></a></li>
			</ul>
			<div id="sub_menu"  onmouseout="out_submenu()" > 
					<a id="sm1" onmouseover = "over_item()"  onmouseup="up_submenu(1)"></a>
					<a id="sm2" onmouseover = "over_item()"  onmouseup="up_submenu(2)"></a>
					<a id="sm3" onmouseover = "over_item()"  onmouseup="up_submenu(3)"></a>
					<a id="sm4" onmouseover = "over_item()"  onmouseup="up_submenu(4)"></a>
					<a id="sm5" onmouseover = "over_item()"  onmouseup="up_submenu(5)"></a>
					<a id="sm6" onmouseover = "over_item()"  onmouseup="up_submenu(6)"></a>
					<a id="sm7" onmouseover = "over_item()"  onmouseup="up_submenu(7)"></a>
	   		</div>
   		 </div>
    </div>
   
    
  </body>
</html>
