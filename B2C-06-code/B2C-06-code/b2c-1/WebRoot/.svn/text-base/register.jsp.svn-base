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

		<title>注册</title>

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
		<div class="w">
			<div id="logo">
				<a href="index.jsp"><img src="imgs/logo.png" /> </a><span class="logo-bg">欢迎注册</span>
			</div>
		</div>
		<div class="w" id="regist">
			<div class="mc">
				<div class="form">
					<form action="user.servlet?action=register" method="post">
						<div class="item">
							<span class="label"><b>*</b>用户名：</span>
							<input type="text" id="regName" name="username" class="text"
								tabindex="1" autoComplete="off" onpaste="return false;"
								value="用户名"
								onClick="if (this.value=='用户名'){this.value=''}" />
						</div>
						<div class="item">
							<span class="tip" id="tip1"></span>
						</div>


						<div class="item">
							<span class="label"><b>*</b>设置密码：</span>
							<input type="password" id="pwd" name="password" class="text"
								tabindex="2" style="ime-mode: disabled;" onpaste="return  false"
								autocomplete="off" onblur="checkPassword1()"
								onfocus="checkUser()"/>
						</div>
						<div class="item">
							<span class="tip" id="tip2"></span>
						</div>


						<div class="item">
							<span class="label"><b>*</b>确认密码：</span>
							<input type="password" id="pwdRepeat" name="pwdRepeat"
								class="text" tabindex="3" onpaste="return  false"
								autocomplete="off" onblur="checkPassword2()" />
						</div>
						<div class="item">
							<span class="tip" id="tip3"></span>
						</div>


						<div class="item">
							<span class="label"><b>*</b>密保问题：</span>
							<select name="question" id="question" class="text"
								style="width: 250px; height: 40px;" onblur="checkQuestion()">
								<option value="init" selected="selected">
									请选择一个问题...
								</option>
								<c:forEach items="${ applicationScope.lcvsq }" var="cvo" step="1"
									varStatus="c">
									<option value="${cvo.name }">
										${cvo.name }
									</option>
								</c:forEach>
							</select>
						</div>
						<div class="item">
							<span class="tip" id="tip4"></span>
						</div>


						<div class="item">
							<span class="label"><b>*</b>问题答案：</span>
							<input type="text" id="answer" name="answer" class="text"
								tabindex="5" autoComplete="off" onpaste="return false;"
								onblur="checkAnswer()" />
						</div>
						<div class="item">
							<span class="tip" id="tip5"></span>
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


						<input type="submit" class="handcursor re1" tabindex="5"
							style="background: url(imgs/login_bg.png); border-style: none; width: 200px; height: 35px; background-repeat: no-repeat; font-family: '微软雅黑'; font-size: 16px;"
							value="立即注册" onclick="return checkForm()" />
					</form>
				</div>
				<div class="login">
					<label>
						已有账号？
					</label>
					<br />
					<input type="button" class="handcursor"
						onclick="location='login.jsp'" tabindex="5"
						style="background: url(imgs/login_bg.png); border-style: none; width: 120px; height: 35px; background-repeat: no-repeat; font-family: '微软雅黑'; font-size: 16px;"
						value="立即登录" />
				</div>
			</div>
		</div>
	</body>
</html>
