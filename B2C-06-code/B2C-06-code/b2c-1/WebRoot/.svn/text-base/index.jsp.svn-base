<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.group6.b2c.viewbean.IndexVo"%>
<%@page import="com.group6.b2c.viewbean.ProductTypeVo"%>
<%@page import="com.group6.b2c.viewbean.RecommendVo"%>
<%@page import="com.group6.b2c.viewbean.ProductVo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->	
	<link rel="stylesheet" type="text/css" href="css/index.css">
   <script type="text/javascript" src="js/ajax.js">
  </script>
   <script type="text/javascript" src="js/hot.js">
  </script>
	<script type="text/javascript" src="js/index.js">
	</script>
	 <script>
  	function over_product(){
  		var targ = getActive();
  		targ.style.cursor = "pointer";
  	}

    function up_product(id){
    	var url = "detail.servlet?pid="+id;
    	window.open(url);
    }
  </script>
  </head>
  <body onload="loadIndex()">
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
	    <img src="imgs/logo.png"/>
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

	<div id="recommend">	
	    	<img id="rd1" onmouseover="over_product()" onclick="clickrd(1)" src="">
	    	<img id="rd2" onmouseover="over_product()" onclick="clickrd(2)" src="">
	    	<img id="rd3" onmouseover="over_product()" onclick="clickrd(3)" src="">
	    	<img id="rd4" onmouseover="over_product()" onclick="clickrd(4)" src="">
	    	<img id="rd5" onmouseover="over_product()" onclick="clickrd(5)" src="">
	    	
	    	
	    	<div id="left_one"  onselectstart="return false;" onmouseover="over_left_one()" onmouseout="out_left_one()" onclick="click_left()">
	    	<a ><</a>
	    	</div>
	    	<div id="right_one"  onselectstart="return false;" onmouseover="over_right_one()" onmouseout="out_right_one()" onclick="click_right()">
	    	<a >></a>
	    	</div>
	    	<div id="current">
	    	<p>
		    	<img id="rd_img1" src="imgs/current.png" onmouseover="over_rd1()"/>
		    	<img id="rd_img2" src="imgs/notcurrent.png" onmouseover="over_rd2()"/>
		    	<img id="rd_img3" src="imgs/notcurrent.png" onmouseover="over_rd3()"/>
		    	<img id="rd_img4" src="imgs/notcurrent.png" onmouseover="over_rd4()"/>
		    	<img id="rd_img5" src="imgs/notcurrent.png" onmouseover="over_rd5()"/>
	    	</p>
	    	</div>
	 </div>
	 
	 
	
    <div id="bottom">
    	<table id="productslist">
    	<tr><td>特卖推荐</td></tr>
	    	<tr>
	    		<td>
		    		<div onmouseover="over_product()" onmouseup="click_buy(1)">
			    		<img id="product1_img" src=""/>
			    		<p id="product1_desc"></p>
			    		<a><strong id="product1_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(1)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(2)">
			    		<img id="product2_img" src=""/>
			    		<p id="product2_desc"></p>
			    		<a><strong id="product2_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(2)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(3)">
			    		<img id="product3_img" src=""/>
			    		<p id="product3_desc"></p>
			    		<a><strong id="product3_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(3)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>
		    		<div onmouseover="over_product()" onmouseup="click_buy(4)">
			    		<img id="product4_img" src=""/>
			    		<p id="product4_desc"></p>
			    		<a><strong id="product4_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(4)"  onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(5)">
			    		<img id="product5_img" src=""/>
			    		<p id="product5_desc"></p>
			    		<a><strong id="product5_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(5)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(6)">
			    		<img id="product6_img" src=""/>
			    		<p id="product6_desc"></p>
			    		<a><strong id="product6_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(6)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    	</tr>
	    	
	    	
	    	
	    	<tr>
	    		<td>
		    		<div onmouseover="over_product()" onmouseup="click_buy(7)">
			    		<img id="product7_img" src=""/>
			    		<p id="product7_desc"></p>
			    		<a><strong id="product7_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(7)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(8)">
			    		<img id="product8_img" src=""/>
			    		<p id="product8_desc"></p>
			    		<a><strong id="product8_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(8)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(9)">
			    		<img id="product9_img" src=""/>
			    		<p id="product9_desc"></p>
			    		<a><strong id="product9_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(9)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>
		    		<div onmouseover="over_product()" onmouseup="click_buy(10)">
			    		<img id="product10_img" src=""/>
			    		<p id="product10_desc"></p>
			    		<a><strong id="product10_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(10)"  onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(11)">
			    		<img id="product11_img" src=""/>
			    		<p id="product11_desc"></p>
			    		<a><strong id="product11_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(11)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(12)">
			    		<img id="product12_img" src=""/>
			    		<p id="product12_desc"></p>
			    		<a><strong id="product12_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(12)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    	</tr>
	    	
	    	<tr>
	    		<td>
		    		<div onmouseover="over_product()" onmouseup="click_buy(13)">
			    		<img id="product13_img" src=""/>
			    		<p id="product13_desc"></p>
			    		<a><strong id="product13_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(13)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(14)">
			    		<img id="product14_img" src=""/>
			    		<p id="product14_desc"></p>
			    		<a><strong id="product14_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(14)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(15)">
			    		<img id="product15_img" src=""/>
			    		<p id="product15_desc"></p>
			    		<a><strong id="product15_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(15)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>
		    		<div onmouseover="over_product()" onmouseup="click_buy(16)">
			    		<img id="product16_img" src=""/>
			    		<p id="product16_desc"></p>
			    		<a><strong id="product16_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(16)"  onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(17)">
			    		<img id="product17_img" src=""/>
			    		<p id="product17_desc"></p>
			    		<a><strong id="product17_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(17)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(18)">
			    		<img id="product18_img" src=""/>
			    		<p id="product18_desc"></p>
			    		<a><strong id="product18_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(18)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    	</tr>
	    	
	    	<tr>
	    		<td>
		    		<div onmouseover="over_product()" onmouseup="click_buy(19)">
			    		<img id="product19_img" src=""/>
			    		<p id="product19_desc"></p>
			    		<a><strong id="product19_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(19)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(20)">
			    		<img id="product20_img" src=""/>
			    		<p id="product20_desc"></p>
			    		<a><strong id="product20_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(20)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(21)">
			    		<img id="product21_img" src=""/>
			    		<p id="product21_desc"></p>
			    		<a><strong id="product21_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(21)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>
		    		<div onmouseover="over_product()" onmouseup="click_buy(22)">
			    		<img id="product22_img" src=""/>
			    		<p id="product22_desc"></p>
			    		<a><strong id="product22_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(22)"  onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(23)">
			    		<img id="product23_img" src=""/>
			    		<p id="product23_desc"></p>
			    		<a><strong id="product23_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(23)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(24)">
			    		<img id="product24_img" src=""/>
			    		<p id="product24_desc"></p>
			    		<a><strong id="product24_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(24)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    	</tr>
	    	
	    	
	    	<tr>
	    		<td>
		    		<div onmouseover="over_product()" onmouseup="click_buy(25)">
			    		<img id="product25_img" src=""/>
			    		<p id="product25_desc"></p>
			    		<a><strong id="product25_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(25)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(26)">
			    		<img id="product26_img" src=""/>
			    		<p id="product26_desc"></p>
			    		<a><strong id="product26_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(26)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(27)">
			    		<img id="product27_img" src=""/>
			    		<p id="product27_desc"></p>
			    		<a><strong id="product27_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(27)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    	</tr>
	    	<tr>
	    		<td>
		    		<div onmouseover="over_product()" onmouseup="click_buy(28)">
			    		<img id="product28_img" src=""/>
			    		<p id="product28_desc"></p>
			    		<a><strong id="product28_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(28)"  onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(29)">
			    		<img id="product29_img" src=""/>
			    		<p id="product29_desc"></p>
			    		<a><strong id="product29_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(29)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    		<td>
	    			<div onmouseover="over_product()" onmouseup="click_buy(30)">
			    		<img id="product30_img" src=""/>
			    		<p id="product30_desc"></p>
			    		<a><strong id="product30_price"></strong></a>
			    		<a href="#"><span onmouseout="out_buy()" onmouseup="click_buy(30)" onmouseover="over_buy()">购买</span></a>
		    		</div>
	    		</td>
	    	</tr>
	    	
	    	
    	</table>
    </div>
    <div id="tail">
    <a class="topElem"  onmouseover="over_topElem()" onmouseout="out_topElem()" href="javascript:up_aboutus()">关于我们</a>
    </div>
  </body>
</html>
