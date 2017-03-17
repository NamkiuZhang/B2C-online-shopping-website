<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML>
<html>
<head>
<title>My JSP 'queryCustomer.jsp' starting page</title>

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

<!-- 
<script>
function upa(){
	var un = document.getElementById("username").value;
	if(un=="" ||un.replace(/[ ]/g,"")==""){
		alert("请输入用户名！");
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
				<h1	Style="font-family:'微软雅黑'; font-size:20px; margin-left:60px;margin-top:30px;">
					<b style="color:red;">*</b>用户名：
					<input  type="text" name="managerName" /> 
					<input type="submit"  value="查询" /> <br>
				</h1>
		       </form>
			
		</div>
	</div>
</body>
</html>
