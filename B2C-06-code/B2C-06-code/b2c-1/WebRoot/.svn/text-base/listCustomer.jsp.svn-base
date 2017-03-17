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


		<title>My JSP 'listCustomer.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
<!-- 
<script>
function upa(){
	var un = document.getElementById("username").value;
	if(un==""){
		alert("请输入用户名！");
		return false;
	}else{
		var url = "user.servlet?action=queryCustomer";
		window.open(url);
	}
}
</script>
 -->

	</head>

	<body>

		<jsp:include page="top.jsp"></jsp:include>
		<div class="w">
			<jsp:include page="left.jsp"></jsp:include>
			<div id="addManager" class="content1">
			
				<form action="user.servlet?action=queryCustomer" method="post">
				<h1
						Style="font-family: '微软雅黑'; font-size: 20px; margin-left: 60px; margin-top: 30px;">	
						<span><b style="color:red;">*</b>用户名：</span>
						<input type="text" name="managerName" />
						<input type="submit"  value="查询" />
						</h1>
						<br>
				</form>
				
				<h1 align="center">
					用戶信息列表
				</h1>
				<center>
					<c:if test="${empty lsvc }">
						<tr>
							<td>
								无用戶信息
							</td>
						</tr>
					</c:if>
					<table width="70%">
						<c:if test="${ not empty lsvc }">
							<thead>
								<th id="firstline">
									序号
								</th>
								<th>
									ID
								</th>
								<th>
									用戶名
								</th>
								<th>
									密码
								</th>
								<th>
									提示问题
								</th>
								<th>
									回答
								</th>
								

							</thead>
							<c:forEach items="${ requestScope.lsvc }" var="uvo" step="1"
								varStatus="u">
								<tr>
									<td>
										${u.index +1 }
									</td>
									<td>
										${uvo.u_id }
									</td>
									<td>
										${uvo.u_name }
									</td>
									<td>
										${uvo.log_pwd }
									</td>
									<td>
										${uvo.question }
									</td>
									<td>
										${uvo.answer }
									</td>
									<!-- 
									<td>
										
										<form action="user.servlet?action=deleteUser" method="post">
											<input value="${uvo.u_name }" name="managerName" type="hidden" />
											<input type="submit" style="font-family: '微软雅黑';" value="删除">
										</form>
										 -->
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
