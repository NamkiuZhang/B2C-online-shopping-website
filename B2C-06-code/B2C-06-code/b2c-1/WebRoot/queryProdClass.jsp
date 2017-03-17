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


		<title>My JSP 'queryProdClass.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
         <script language="javascript" src="js/zmj.js"></script>
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
					<form action="product.servlet?action=findAllPros" method="post">
						查询分类：
						<select id="firstType" name="firstType"
							onchange="checkFirstType()" class="select">
							<option value="-1">
								请选择一级分类
							</option>
							<c:forEach items="${ applicationScope.lptv }" var="ptv" step="1"
								varStatus="pt">
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
						<input type="submit" name="查询"  />
					</form>
					
					<h1 align="center">
					商品信息列表
				</h1>
				<center>
					<c:if test="${empty lsvp }">
						<tr>
							<td>
								该分类下无商品
							</td>
						</tr>
					</c:if>
					<table width="70%">
						<c:if test="${ not empty lsvp }">
							<thead>
								<th id="firstline">
									序号
								</th>
								<th>
									商品ID
								</th>
								<th>
									商品名称
								</th>
								<th>
									单价
								</th>
								<th>
									库存数量
								</th>
								
							</thead>
							<c:forEach items="${ requestScope.lsvp }" var="pvo" step="1"
								varStatus="p">
								<tr>
								<td>
										${p.index +1 }
									</td>
									<td>
										${pvo.id }
									</td>
									<td>
										${pvo.pname }
									</td>
									<td>
										${pvo.pprice}
									</td>
									<td>
										${pvo.storage }
									</td>
					</tr>
					</c:forEach>
					</c:if>
					</table>
					</center>
				</div>
			</div>
		</div>
	</body>
</html>
