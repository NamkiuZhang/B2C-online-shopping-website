<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>My JSP 'listProduct.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript" src="js/zmj.js"></script>
	<style type="text/css">
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
				<form style="display: inline;"
					action="product.servlet?action=queryProduct" method="post">
					<b style="color:red;">*</b>商品名称：
					<input type="text" name="productName" id="productName" onblur="check()"/>
					<span id="tip1"></span>
					<br/>
					<b style="color:red;">*</b> 选择商品分类：
					<select id="firstType" name="firstType" onblur="checkSelectFirstType()" onchange="checkFirstType()"
						class="select">
						<option value="-1">
							请选择一级分类
						</option>
						<c:forEach items="${ applicationScope.lptv }" var="ptv" step="1" varStatus="pt">
							<option value="${ptv.id}">
								${ptv.t_name}
							</option>
						</c:forEach>
					</select>
					<span id="tip2"></span>
					<select id="secondType" name="secondType"  onblur="checkSelectSecondType()"class="select">
						<option value="-2">
							请选择二级分类
						</option>
					</select>
					<span id="tip3"></span>
					<br/>
					<input type="submit" value="查询" onclick="return checkSearchProduct()" />
				</form>


				<h1 align="center">
					商品信息列表
				</h1>
				<center>
					<c:if test="${empty lsvp }">
						<tr>
							<td>
								无该商品
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
									
									<td>
										<form action="product.servlet?action=listProductDetails" method="post">
											<input value="${pvo.id }" name="productId" type="hidden">
											<input type="submit" style="font-family: '微软雅黑';"
												value="查看详细信息" />
										</form>
										<form action="product.servlet?action=modifyProductInfo" method="post">
											<input value="${pvo.id }" name="productId" type="hidden">
											<input type="submit" style="font-family: '微软雅黑';"
												value="修改商品信息" />
										</form>
										<form action="product.servlet?action=deleteProduct" method="post">
											<input value="${pvo.id }" name="productId" type="hidden" />
											<input type="submit" style="font-family: '微软雅黑';" value="删除">
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
