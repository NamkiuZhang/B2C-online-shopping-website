<%@page import="com.group6.b2c.viewbean.CommentVo"%>
<%@page import="com.group6.b2c.viewbean.ViewProductVo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE HTML>
<html>
  <head>
  <link href="css/index.css" type="text/css" rel="stylesheet">
   <link href="css/product_detail.css" type="text/css" rel="stylesheet">
   <link href="css/shou.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="js/ajax.js">
  </script>
   <script type="text/javascript" src="js/index.js">
  </script>
  <script type="text/javascript" src="js/loadlist_detail.js">
  </script>
  <script type="text/javascript" src="js/product_detail.js">
  </script>
  <script type="text/javascript" src="js/star.js"> 
  </script>

  
  </head>
  <body onload="loadList_Detail()">
     <div id="top">
	     <div id="top_left">
	    <c:if test="${empty  user }">
	    <a class="topElem"  onmouseover="over_topElem()" onmouseout="out_topElem()" href="login.jsp" id="username">登录</a> 
	     <a class="topElem"  onmouseover="over_topElem()" onmouseout="out_topElem()" href="user.servlet?action=question">注册</a>
	     </c:if>
	     <c:if test="${not empty  user }"><span id="username">${sessionScope.user }</span>,欢迎来到Aditu&nbsp
	     <a href="user.servlet?action=logout">安全退出</a>
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
    
    <div id="detail">
    <div id="detail_top">
    	<div id="product_img">
    	
    	<img  src="${sessionScope.vpv.imgPath}">
    	</div>
    	<div id="product_desc">
    		<h3 id="name">${sessionScope.vpv.name}</h3>
    		<p style="font-size:15px;">价格: <span id="price">￥${sessionScope.vpv.price}</span></p>
    		<p style="font-size:15px;">销量: ${sessionScope.vpv.salesNum}</p>
    		
    		<p style="font-size:15px;border-bottom: gray dashed thin;padding-bottom:10px;">    		
    		评分: <span id="comment">${sessionScope.vpv.avgScore}</span>   		
    		<a onmouseover="over_score()" onmouseout="out_score()" style="text-decoration:none;color:#44DDee;font-size:8px;" href="javascript:click_comment()">(共${sessionScope.vpv.commentNum}个评价)</a></p>	
	    		<div >
	    			<div style="float:left;height:25px;line-height:25px;font-size:15px;">
	    			购买数量:
	    			</div>
	    			<div onmouseup="up_minus()" onmouseout="out_element()" onmouseover="over_element()" style="float:left">
	    				<span style="
	    				background:#1FD1B7;line-height:25px;font-weight:bold;padding:3px 2px;position:relative;left:14px;color:white">-</span>
	    			</div>
	    			<div style="float:left">
	    				<input style="outline:none;text-align:center;border:solid #1FD1B7 thin;height:20px;width:40px;padding-left:15px;padding-right:15px;" id="num_input" type="text" value="1"/>
	    			</div>
	    			<div onmouseup="up_add()" onmouseout="out_element()" onmouseover="over_element()" style="float:left">
	    				<span style="
	    				background:#1FD1B7;line-height:25px;font-weight:bold;padding:3px 2px;position:relative;right:14px;color:white">+</span>
	    			</div>
	    			<div style="float:left;margin-left:10px;padding-top:3px;font-size:15px;">
	    				库存: <span id="storage">${sessionScope.vpv.storage}</span>
	    			</div>
	    		</div>
	    		<br/>
	    		<br/>
	    		<br/>
	    		<div >
	    			<input onmouseup="up_buy(${sessionScope.vpv.id})" onmouseout="out_element()" onmouseover="over_element()" style="outline:none;clear:both;height:30px;background:#1FD1B7;border:solid #1FD1B7;font-weight:bold;color:white" id="addbtn" type="button" value="立即购买"/>
	    			<input  onmouseup="up_addToCart(${sessionScope.vpv.id})" onmouseout="out_element()" onmouseover="over_element()" style="outline:none;clear:both;height:30px;background:#1FD1B7;border:solid #1FD1B7;font-weight:bold;color:white" id="addbtn" type="button" value="加入购物车"/>
    			</div>
    	</div>
    </div>
    <div id="detail_bottom">
    	<div class="bottom_div1">
    		<ul>
    		<li id="product_detail" onmouseover="over_detail()" onclick="click_detail()" >详情</li>
    		<li id="product_comment" onmouseover="over_comment()" onclick="click_comment()" >评论</li>  		
    		</ul>
    	</div>
    	<div class="bottom_div2">
    	<div id="ddetail">
    	
    	<div class="dddetail">
    	<p>上市时间：${vpv.marketTime}</p>
    	<p>类型名：${vpv.typename}</p>
    	<p>颜色：${vpv.color}</p>
    	
    	</div>
    	<div class="dddetail">
    	<p>型号：${vpv.model} </p>
    	<p>品牌：${vpv.brand}</p>
    	<p>保质期：${vpv.guarantee} </p>
    	</div>
    	<div class="dddetail">
    	<p>重量：${vpv.weight} </p>
    	<p>原料：${vpv.material} </p>
    	<p>生产地：${vpv.origin} </p>
    	</div>
    	<div style="width:100%;height:20px;clear:both;font-size:15px;">
    		描述：${vpv.desc}
    	</div>
    	</div>
    	<div id="comments">
    		<div id="allComments">
    			<c:if test="${empty  sessionScope.vpv.comments}">
    				<h2>暂无评论！</h2>
    			</c:if>
    			<c:if test="${not empty  sessionScope.vpv.comments}">
    				<c:forEach items="${sessionScope.vpv.comments}" var="d" step="1" varStatus ="s">
    					<div class="comment_item">
    					<p class="c_content">${d.content}</p>
    					<p><span class="time">${d.time }</span><span class="name">${d.name}</span></p>
    						<div id="c_score">
    							${d.score}分
    						</div>
    						</div>    				
    				</c:forEach>
    			</c:if>
    		</div>
    		<div id="editComment">
    			<div style="border-bottom:gray dashed;height:40px;line-height:40px;text-align:center;letter-spacing:20px;
    			font-weight:bold;">
    			我要评论
    			</div>
    			<div class="weiduduan clearfix">
					<div id="star">
   						 <span style="position:relative;top:2px;font-weight:bold;">评分</span>
   							 <ul>
        						<li><a href="javascript:;">1</a></li>
        						<li><a href="javascript:;">2</a></li>
       							 <li><a href="javascript:;">3</a></li>
        						<li><a href="javascript:;">4</a></li>
        						<li><a href="javascript:;">5</a></li>
    						</ul>
    					<span></span>
    					<p></p>
					</div><!--star end-->
				</div> <!-- weiduduan End -->
    			<div id="comment_content">
    				<textarea style="outline:none;" id="textarea" rows="5" cols="50"></textarea>
    				<input style="outline:none;" onmouseover="over_element()" id="text_sbt" type="button" value="提交" onmouseup="clicksubmit(${sessionScope.vpv.id})"/>
    			</div>
    		</div>	
    	</div>
    </div>
    </div>
    </div>
    <div id="tail">
    <a class="topElem"  onmouseover="over_topElem()" onmouseout="out_topElem()" href="javascript:up_aboutus()">关于我们</a>
    </div>
  </body>
</html>
