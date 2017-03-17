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

		<title>个人资料</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link style="text/css" href="css/loginstyle.css" rel="stylesheet" />
		<script type="text/javascript" src="js/user.js">
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
							个人信息
						</span>
					</div>
					<div class="form">
					<c:if test="${not empty genderid&&not empty realname}">
						<div class="item">
							<span class="label">性别：</span><span>${requestScope.genderid }</span>
						</div>
						<div class="item">
							<span class="label">真实姓名：</span><span>${requestScope.realname }</span>
						</div>
						<input type="button" class="handcursor re1" tabindex="3"
							style="background: url(imgs/login_bg.png); border-style: outset; width: 100px; height: 35px; background-repeat: no-repeat; font-family: '微软雅黑'; font-size: 15px;"
							value="返 回" onclick="location='myHome.jsp'" />
					</c:if>
					</div>
					<div class="form">
						<c:if test="${empty genderid&&empty realname}">
							<form method="post" action="user.servlet?action=setuserinfo">
								<div class="item">
									<span class="label">性别：</span>
									<select name="gender" id="gender" class="text"
										style="width: 250px; height: 40px;" onblur="checkQuestion()">
										<c:forEach items="${ requestScope.lcvs }" var="cvo" step="1"
											varStatus="c">
											<option value="${cvo.name }">
												${cvo.name }
											</option>
										</c:forEach>
									</select>
									<span class="tip" id="tip8"></span>
								</div>
								<div class="item">
									<span class="label">真实姓名：</span>
									<input type="text" id="realname" name="realname" class="text"
										tabindex="2" autoComplete="off" onpaste="return false;"
										onblur="checkRealname()" />
									<span class="tip" id="tip9"></span>
								</div>

								<input type="submit" class="handcursor re1" tabindex="3"
									style="background: url(imgs/login_bg.png); border-style: outset; width: 100px; height: 35px; background-repeat: no-repeat; font-family: '微软雅黑'; font-size: 15px;"
									value="确 认" onclick="return checkUserinfoForm()" />
							</form>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
