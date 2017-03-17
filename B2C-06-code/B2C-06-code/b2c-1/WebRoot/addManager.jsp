<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
	<head>

		<title>管理员的添加</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="./CSS/styles.css">
		<script type="text/javascript" src="js/user.js">
</script>
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
			<jsp:include page="leftadm.jsp"></jsp:include>
				<div id="addManager" class="content1">
					<h1
						style="color: #1FD1B7; font-family: '微软雅黑'; font-size: 30px; margin-left: 50px">
						新增管理员
					</h1>
					<br>

					<form action="user.servlet?action=addManager" method="post">
						<div class="item">
							<span class="label"><b>*</b> 管理员名称 ：</span>
							<input type="text" name="managerName" id="regName"
								onblur="checkUser()" />
							<span class="tip" id="tip1"></span>
							<br>
						</div>
						<div class="item">
							<span class="label"> <b>*</b>密码：</span>
							<input type="password" name="managerPwd" id="pwd"
								onblur="checkPassword1()" onfocus="checkUser()" />
							<span class="tip" id="tip2"></span>
							<br>
						</div>
						<div class="item">
							<span class="label"><b>*</b>确认密码：</span>
							<input type="password" name="confrimManagerPwd" id="pwdRepeat"
								onblur="checkPassword2()" />
							<span class="tip" id="tip3"></span>
							<br>
						</div>

						<div class="item">
							<span class="label"><b>*</b>找回密码提示问题：</span>
							<input type="text" name="question" id="question"
								onblur="checkQuestion()" />
							<span class="tip" id="tip4"></span>
							<br>
						</div>
						<div class="item">
							<span class="label"><b>*</b>回答：</span>
							<input type="text" name="answer" id="answer"
								onblur="checkAnswer()" />
							<span class="tip" id="tip5"></span>
							<br>
						</div>

						<div class="item">
							<span class="label"><b>*</b>验证码：</span>
							<input type="text" id="authcode" style="ime-mode: disabled"
								name="authcode" class="text text-1" tabindex="6"
								autocomplete="off" MaxLength="4" onblur="checkCode()" />
							<label class="img">
								<img id="rsi" src="user.servlet?code=code" />
							</label>
							<label>
								看不清？
								<a href="javascript:rli()">换一张</a>
							</label>
						</div>
						<div class="item">
							<span class="tip" id="tip6"></span>
						</div>

						<input type="submit"
							style="background: #1FD1B7; border-style: none; width: 120px; height: 35px; background-repeat: no-repeat; margin-left: 70px; font-family: '微软雅黑'; font-size: 16px;"
							value="新增" />
						<input type="button"
							style="background: #1FD1B7; border-style: none; width: 120px; height: 35px; background-repeat: no-repeat; margin-left: 80px; font-family: '微软雅黑'; font-size: 16px;"
							value="取消  " />
						<br />
					</form>
				</div>
			</div>
	</body>
</html>
