<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />


<!DOCTYPE HTML>
<html>
	<head>

		<title>My JSP 'modifyOrderStatus.jsp' starting page</title>

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
					修改订单状态
				</h1>
				<form action="servlet/OrderServlet?action=findMSOrder" method="post">
					输入订单号：
					<input type="text" name="orderId" value="" />
					<br>
					选择查询类别：
					<input type="checkbox" name="status" value="未支付" />
					新订单
					<input type="checkbox" name="status" value="已支付" />
					已支付订单
					<input type="submit" value="查询" />
				</form>
				<br>
				<h1 align="center">
					订单信息列表
				</h1>
				<center>
					<table width="70%">
						<c:if test="${empty lsvomodify }">
							<tr>
								<td>
									无该订单
								</td>
							</tr>
						</c:if>
						<c:if test="${ not empty lsvomodify }">
							<thead>
								<th id="firstline">
									序号
								</th>
								<th id="firstline">
									订单号
								</th>
								<th>
									订单状态
								</th>
								<th>
									支付账号
								</th>

								<th>
									生产时间
								</th>
								<th>
									修改订单状态
								</th>

							</thead>
							<c:forEach items="${ sessionScope.lsvomodify }" var="ovo"
								step="1" varStatus="o">
								<tr>
									<td>
										${o.index +1 }
									</td>
									<td>
										${ovo.orderID }
									</td>
									<td>
										${ovo.status }
									</td>
									<td>
										${ovo.payID }
									</td>

									<td>
										${ovo.start_time }
									</td>
									<td>
										<form action="servlet/OrderServlet?action=changeStatus"
											method="post">
											<c:if test="${ovo.status == '未支付'}">
												<select name="status">
														<option value="已作废">
															已作废
														</option>
												</select>
												<input value="${ovo.orderID }" name="orderId" type="hidden" />
												<input type="submit" style="font-family: '微软雅黑';"
													value="提交修改">
											</c:if>

											<c:if test="${ovo.status == '未支付，已发货'}">
												<select name="status">
													<option value="已支付">
														已支付
													</option>
												</select>
												<input value="${ovo.orderID }" name="orderId" type="hidden" />
												<input type="submit" style="font-family: '微软雅黑';"
													value="提交修改">
											</c:if>

											<c:if test="${ovo.status == '已支付'}">
												<select name="status">
													<option value="已发货">
														已发货
													</option>
												</select>
												<input value="${ovo.orderID }" name="orderId" type="hidden" />
												<input type="submit" style="font-family: '微软雅黑';"
													value="提交修改">
											</c:if>
										</form>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
				</center>
			</div>
		</div>
	</body>
</html>
