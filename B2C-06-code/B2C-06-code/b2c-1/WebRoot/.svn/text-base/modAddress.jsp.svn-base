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

		<title>收货地址管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link style="text/css" href="css/loginstyle.css" rel="stylesheet" />
		<script type="text/javascript" src="js/address.js">
</script>

	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="container">
			<div id="home">
				<jsp:include page="myhomesidebar.jsp"></jsp:include>
				<div class="content">
					<div class="header">
						<span class="label">
							修改收货地址
						</span>
					</div>
					<div class="form">
						<form action="address.servlet?action=mod" method="post">
							<div class="item">

								<span class="label">所在地区：</span><input type="hidden" name="id" value="${requestScope.id}"/>
								<input type="text" name="oldaddr" value="${requestScope.addr[0]}" style="border:none;" readonly="readonly"/><br/>
								<select id="cap" name="cap" onchange="checkCap()" class="select" style="margin-left: 200px;">
									<option value="0">
										请选择省市/其他
									</option>
									<c:forEach items="${ applicationScope.lcs }" var="aco" step="1"
										varStatus="c">
										<option value="${aco.id}">
											${aco.name}
										</option>
									</c:forEach>
								</select>
								<select id="city" name="city" onchange="checkCity()" class="select">
									<option>请选择城市</option>
								</select>
								<select name="town" id="town" class="select" onchange="javascript:checkLocation()">
									<option value="choose">请选择区/县</option>
								</select>
								<span class="tip" id="tip1"></span>
							</div>
							<div class="item">
								<span class="label">邮政编码：</span>
								<input type="text" name="post" id="post" class="text" value="${requestScope.addr[2]}" onclick="checkLocation()" onblur="checkPost()"/>
								<span class="tip" id="tip2"></span>
							</div>
							<div class="item">
								<span class="label">街道地址：</span>
								<input type="text" name="road" id="road" class="text" value="${requestScope.addr[1]}" onblur="checkRoad()"/>
								<span class="tip" id="tip3"></span>
							</div>
							<input type="submit" class="handcursor re1" tabindex="3"
								style="background: url(imgs/login_bg.png); border-style: outset; width: 100px; height: 35px; background-repeat: no-repeat; font-family: '微软雅黑'; font-size: 15px;"
								value="保 存" onclick="return checkForm()"/>							
						</form><br//>						
					</div>
					<a href="javascript:history.go(-1)" style="margin-left:20px;">返回>></a>
				</div>
			</div>
		</div>
	</body>
</html>
