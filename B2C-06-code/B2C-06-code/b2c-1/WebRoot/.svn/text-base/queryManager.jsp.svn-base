<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
	<head>

		<title>My JSP 'queryManager.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
			<jsp:include page="leftadm.jsp"></jsp:include>
			<div id="addManager" class="content1">

				<h1 align="center">
					管理员信息列表
				</h1>
				<center>
					<table width="70%">
						<c:if test="${empty lsvm }">
							<tr>
								<td>
									无管理员信息
								</td>
							</tr>
						</c:if>
						<c:if test="${ not empty lsvm }">
							<thead>
							    <th id="firstline">
								         序号
								</th>
								<th id="firstline">
								         管理员ID
								</th>
								<th>
									管理员名称
								</th>
								<th>
									密码
								</th>
								<th>
									操作
								</th>
							</thead>
							<c:forEach items="${ requestScope.lsvm }" var="mvo" step="1"
								varStatus="m">
								<tr>
									<td>
										${m.index +1 }
									</td>
									<td>
										${mvo.u_id }
									</td>
									<td>
										${mvo.u_name }
									</td>
									<td>
										${mvo.log_pwd }
									</td>
									<td>
										<form action="user.servlet?action=listManagerDetails" method="post">
											<input value="${mvo.u_name }" name="managerName" type="hidden">
											<input type="submit" style="font-family: '微软雅黑';"
												value="查看详细信息" />
										</form>
										<form action="user.servlet?action=deleteManager" method="post">
											<input value="${mvo.u_name }" name="managerName" type="hidden"/>
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
