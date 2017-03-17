function checkPassword1() {
	var pwd = document.getElementById("pwd").value;
	var pattern=/^(?!\D+$)(?![^a-zA-Z]+$)\S{6,20}$/ ;
	if (pwd == "" || pwd.length == 0) {
		document.getElementById('tip2').innerHTML = "密码不能为空";
	} else if(pwd.length < 6){
		document.getElementById('tip2').innerHTML = "密码至少为六位";
	} else if(! pattern.test(pwd)){
		document.getElementById('tip2').innerHTML = "密码必须包含数字和字母";
	}else{
		document.getElementById('tip2').innerHTML = "";
	}
}

function checkPassword2() {
	var pwd = document.getElementById("pwd").value;
	var pwdRepeat = document.getElementById("pwdRepeat").value;
	if (pwdRepeat == "" || pwdRepeat.length == 0) {
		document.getElementById('tip3').innerHTML = "确认密码不能为空";
	} else if (document.getElementById("pwd").value != document
			.getElementById("pwdRepeat").value) {
		document.getElementById('tip3').innerHTML = "两次密码不一致";
	} else {
		document.getElementById('tip3').innerHTML = "";
	}
}
var xmlHttp;
function getXmlHttpRequest() {
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("您的浏览器不支持AJAX！");
			}
		}
	}
	return xmlHttp;
}
function sendRequest(url) {
	var xmlReq = getXmlHttpRequest();
	xmlReq.onreadystatechange = processResponse;
	xmlHttp.open("POST", url, true);
	xmlHttp.send(null);
}

function processResponse() {
	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {//信息已成功返回
		var s = xmlHttp.responseText;
		if (s == "true") {
			document.getElementById('tip1').innerHTML = "用户名已存在";
		}
		if (s == "false") {
			document.getElementById('tip1').innerHTML = "用户名可用";
		}
	}
}
function checkUser() {
	var name = document.getElementById("regName").value;
	if (name.length == 0 || name == "" || name == "用户名") {
		document.getElementById('tip1').innerHTML = "用户名不能为空";
	} else {
		sendRequest("user.servlet?action=checkUserName&userName=" + name);
	}
}

function checkUser3() {
	var name = document.getElementById("regName").value;
	if (name.length == 0 || name == "" || name == "用户名") {
		document.getElementById('tip1').innerHTML = "用户名不能为空";
	} else {
		sendRequest3("user.servlet?action=checkUserName&userName=" + name);
	}
}

function sendRequest3(url) {
	var xmlReq = getXmlHttpRequest();
	xmlReq.onreadystatechange = processResponse3;
	xmlHttp.open("POST", url, true);
	xmlHttp.send(null);
}

function processResponse3() {
	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {//信息已成功返回
		var s = xmlHttp.responseText;
		if (s == "true") {
			document.getElementById('tip1').innerHTML = "";
		}
		if (s == "false") {
			document.getElementById('tip1').innerHTML = "用户名不存在";
		}
	}
}

function getQuestion() {
	var url = "user.servlet?action=question";
	window.self.location = url;
}

function checkQuestion() {
	if (document.getElementById("question").value == "init") {
		document.getElementById('tip4').innerHTML = "未选择问题";
	} else {
		document.getElementById('tip4').innerHTML = "";
	}
}

function checkAnswer() {
	if (document.getElementById("answer").value == ""
			|| document.getElementById("answer").length == 0) {
		document.getElementById('tip5').innerHTML = "答案不能为空";
	} else {
		document.getElementById('tip5').innerHTML = "";
	}
}

function rli() {
	var img = document.getElementById("rsi");
	img.src = "";
	img.src = "user.servlet?code=code&abc=" + Math.random();//IE浏览器
}

function sendRequest2(url) {
	var xmlReq = getXmlHttpRequest();
	xmlReq.onreadystatechange = processResponse2;
	xmlHttp.open("POST", url, true);
	xmlHttp.send(null);
}
function processResponse2() {
	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {//信息已成功返回
		var code = xmlHttp.responseText;
		if (code == "true") {
			document.getElementById('tip6').innerHTML = "";
		}
		if (code == "false") {
			document.getElementById('tip6').innerHTML = "验证码错误";
		}
	}
}
function checkCode() {
	var code = document.getElementById("authcode").value;
	if (code.length != 4) {
		document.getElementById('tip6').innerHTML = "验证码错误";
	} else {
		sendRequest2("user.servlet?action=checkcode&autocode=" + code);
	}
}

function checkForm() {
	if (document.getElementById('tip1').innerHTML != "用户名可用") {
		alert("表单有错误,填写表单");
		return false;
	}else{
		checkPassword1();
		checkPassword2();
		checkQuestion();
		checkAnswer();
		checkCode();
	}
	for ( var i = 2; i < 7; i++) {
		if (document.getElementById('tip' + i).innerHTML != "") {
			alert("表单有错误");
			return false;
			break;
		}
	}
}
function checkFpwdForm() {
	checkUser();
	checkCode();
	if (document.getElementById('tip1').innerHTML != ""
			|| document.getElementById('tip6').innerHTML != "") {
		alert("表单有错误");
		return false;
	}
}

function checkModpwdForm() {
	checkPassword1();
	checkPassword2();
	if (document.getElementById('tip2').innerHTML != ""
			|| document.getElementById('tip3').innerHTML != "") {
		alert("表单有错误");
		return false;
	}
}

function checkAnswerWithQuestion() {
	if (document.getElementById("pAnswer").value != (document
			.getElementById("sAnswer").value)) {
		document.getElementById('tip7').innerHTML = "答案不正确";
	} else {
		document.getElementById('tip7').innerHTML = "";
	}
}

function checkQAForm() {
	checkAnswerWithQuestion();
	if (document.getElementById('tip7').innerHTML != "") {
		alert("表单有错误");
	} else {
		window.location.href = "fpwd3.jsp";
	}
}

function checkRealname(){
	var rn = document.getElementById("realname").value;
	if (rn == "" || rn.length == 0) {
		document.getElementById('tip9').innerHTML = "请填写真实姓名";
	} else {
		document.getElementById('tip9').innerHTML = "";
	}
}

function checkUserinfoForm() {
	if (document.getElementById('tip9').innerHTML != "") {
		alert("表单有错误");
		return false;
	}
}