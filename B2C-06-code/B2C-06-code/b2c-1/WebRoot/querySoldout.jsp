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


		<title>My JSP 'querySoldout.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="./CSS/styles.css">

		<style>
th {
	width: 130;
	align: center;
	background-color: #d3d7d4;
	font-family: "微软雅黑" ；
}

#firstline {
	width: 180;
	height: 50
}

td {
	text-align: center;
	height: 50px;
}

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
				<h1 align="center">
					售尽商品列表
				</h1>
				<center>

					<c:if test="${empty lsvp }">
						<tr>
							<td>
								无售尽商品
							</td>
						</tr>
					</c:if>
					
					<table width="70%">
						<c:if test="${ not empty lsvp }">
							<thead>
								<th id="firstline">
									序号
								</th>
								<th id="firstline">
									商品名称
								</th>
								<th>
									商品ID
								</th>
								<th>
									单价
								</th>
						
								<th>
									所属二级分类ID
								</th>
								<th>
									操作
								</th>
							</thead>
							<c:forEach items="${ requestScope.lsvp }" var="pvo" step="1"
								varStatus="p">
								<tr>
									<td>
										${p.index +1 }
									</td>
									<td>
										${pvo.pname }
									</td>
									<td>
										${pvo.id }
									</td>
									<td>
										${pvo.price }
									</td>
									<td>
										${pvo.typeId }
									</td>
									
									<td>
							
										<form action="product.servlet?action=listProductDetails" method="post">
											<input value="${pvo.id }" name="productId" type="hidden">
											<input type="submit" style="font-family: '微软雅黑';"
												value="查看详细信息" />
										</form>

									</td>
								</tr>

							</c:forEach>

						</c:if>
						<tbody>

						</tbody>
					</table>
				</center>
			</div>
		</div>
	</body>
</html>
