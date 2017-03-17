<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:ui="http://xmlns.jcp.org/jsf/facelets">
	<head>
		<title>cartl.html</title>
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="this is my page">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/cartlist.css">
		<style type="text/css">

td{
   width: 200px;
}
</style>

	</head>
	<body >
		<jsp:include page="header.jsp"></jsp:include>
		<div id="middle" style="min-height: 600px;">
		  <form action="servlet/OrderServlet" method="post">
			<table>
				<tr id="tablehead">
					<td></td>
					<th class="firstline">
						商品
					</th>
					<th>
						单价
					</th>
					<th class="thirdline">
						数量
					</th>
					<th>
						价格
					</th>
					
				</tr>
			
				<c:if test="${ not   empty  orderdetail}">
				<c:forEach items="${orderdetail}" var="svo" step="1" varStatus="s">
				<tr>
					
					<td>
						<img src="${svo.image }" style="height:180px;width:150px"/>
					</td>
					<td class="firstline">
						<a href="product.servlet?pro_id=${svo.product_id }">${svo. product_name}</a>
						
					</td>
					<td>
						${svo.product_price }
					</td>
					<td class="thirdline">
						
						${svo.quantity}
					
					</td>
					<td>
					
						${svo.total}
					</td>
					</tr>
					   </c:forEach>
				
				<tr>
					<td></td><td></td><td></td><td></td>
					<td>
						<input type="submit" value="返回" name="checkor"/>
					</td>
				</tr>
				
				</c:if>
			</table>
			</form>
		</div>
		<jsp:include page="footer.jsp" />
	</body>
</html>