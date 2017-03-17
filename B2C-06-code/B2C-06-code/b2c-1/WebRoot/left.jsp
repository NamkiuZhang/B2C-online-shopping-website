<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>

<title>My JSP 'left.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/styles.css">

<style>
#catagory {
	background: #1FD1B7;
	padding: 3px 3px 2px 10px;
	width:200px;
	float:left;
}

.sidebar1 {
	padding: 10px 5px 0px 20px;
	margin-top: 8px;
	border:none;
}

a {
	color: black;
	text-decoration: none;
}

ul {
	list-style-type: none;
	margin: 0px;
}

ul li {
	list-style-type: none;
	background: #1FD1B7;
}

ul li a {
	display: block;
	width: 100%;
	background: #1FD1B7;
}

ul li a:hover {
	background: #1FD1B7;
	color: #ffffff;
}

h1 {
	color: #1FD1B7;
}
</style>


</head>

<body>
	
	<div id="catagory">
			<span style="color:black;font:20px;">欢迎,${sessionScope.user }</span>
		<br> <a href="manModpwd.jsp">修改密码</a>&nbsp;&nbsp;&nbsp;<a href="user.servlet?action=logout">退出登录</a> <br />
		<div class="sidebar1">
			<h2 class="label">用户管理</h2>
			<ul class="nav">
				<li><a href="queryCustomer.jsp" target="right">查询用户</a>
				</li>
			</ul><br />
			<h2 class="label">商品管理</h2>
			<ul class="nav">
				<li class="queryProd"><a href="queryProduct.jsp" target="right">查询商品</a>
				</li>
				<li class="addProd"><a href="addProduct.jsp" target="right">添加商品</a>
				</li>
				<li class="querySoldOut"><a href="product.servlet?action=listSellout" 
					target="right">查询脱销商品</a>
				</li>
			</ul><br />
			<h2 class="label">商品分类管理</h2>
			<ul class="nav">
				<li><a href="queryProdClass.jsp" target="right">查询分类</a>
				</li>
				<li><a href="addProdClass.jsp" target="right">添加分类</a>
				</li>
				<li><a href="modiDelClass.jsp" target="right">修改分类</a>
				</li>
				<li><a href="deleteProductType.jsp" target="right">删除分类</a>
				</li>
			</ul><br />
			<h2 class="label">订单管理</h2>
			<ul class="nav">
				<li><a href="queryOrder.jsp" target="right">查询订单</a></li>
				<li><a href="modifyOrderStatus.jsp" target="right">修改订单状态</a></li>
				<li><a href="deleteOrder.jsp" target="right">删除订单</a></li>
			</ul><br />
			
		</div>
	</div>
</body>
</html>
