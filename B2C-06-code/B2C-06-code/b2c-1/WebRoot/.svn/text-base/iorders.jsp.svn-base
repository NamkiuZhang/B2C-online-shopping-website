<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:ui="http://xmlns.jcp.org/jsf/facelets">
	<head>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<style type="text/css">
th {
	width: 130px;
	align: center;
	background-color: #d3d7d4;
}

#firstline {
	width: 180;
	height: 50;
}

td {
	text-align: center;
	height: 50px;
}

#tabletop {
	margin-left: 120px;
	margin-top: 20px;
}

table {
	margin-left: 70px;
	margin-top: 20px;
}

</style>
		<script language="JavaScript">
function checkAll(b) {
	var input = document.getElementsByTagName("input");
	for ( var i = 0; i < input.length; i++) {
		if (input[i].type == "checkbox")
			input[i].checked = b;
	}

}
</script>
	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div id="middle" style="min-height: 600px;">

			<div id="tabletop">
			<form name="input" action="servlet/OrderServlet" method="post">
				<input type="text" name="searchid" style="height:20px"/>
				&nbsp;
				<input type="submit" value="订单搜索" name="search" />
				</form>
			</div>

			<table>

				<tr>
					<th id="firstline">
						订单号
					</th>
					<th>
						时间
					</th>
					<th>
						支付时间
					</th>

					<th>
						订单状态
					</th>
					<th colspan="4">
						操作
					</th>
				</tr>
				<c:if test="${empty orders}">
					<tr>
						<td colspan="3">
							订单为空！
							去首页！<a href="index.jsp">go</a>
						</td>
					</tr>
				</c:if>
				<c:if test="${ not   empty   orders}">
					<c:forEach items="${ orders}" var="od">
						<form name="input" action="servlet/OrderServlet" method="post">
						<tr>
							<td>
								
								<input type="hidden" name="orderid" value="${od.orderID}" />
								<a href="servlet/OrderServlet?action=${od.orderID}">${od.orderID}</a>
							</td>
							<td>
								${od.start_time}
							</td>
							<td>
								${od.payTime}
							</td>

							<td>
								${od.status}
							</td>
							<td>
								<input type="submit" value="删除" name="move" />
							</td>
							<td>
								<input type="submit" value="确认" name="comfirm" />
							</td>
							<td>
								<input type="submit" value="付款" name="payit" />
							</td>
							<td>
								<input type="submit" value="打印" name="printit" />
							</td>

						</tr>
						</form>
					</c:forEach>
				</c:if>

			</table>

		</div>
		<jsp:include page="footer.jsp" />
	</body>
</html>