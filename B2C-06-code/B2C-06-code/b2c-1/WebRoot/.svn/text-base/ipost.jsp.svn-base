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
		<script type="text/javascript" src="js/ajax.js"></script>
		<script type="text/javascript" src="js/address.js"></script>
		<style>
table {
	padding-top: 50px;
	width:600px;
}

.t2 {
	padding-top: 40px;
}

.firstline {
	height: 100px;
	font-size: 150%;
}
.right{
  margin-top:80px;
}


.left{
  margin-top:80px;
}

</style>
		<script language="javascript" type="text/javascript">

function loadbypid() {
	var pid = document.getElementById("sp").value;
	var url = "ld.ajax?pid=" + pid;
	sendreuest(url, f2);
}
function f2() {
	if (xmlHttp.readyState == 4) {
		document.getElementById("sc").options.length = 0;
		var s = xmlHttp.responseText;
		var ss = s.split(";");
		for ( var i = 0; i < ss.length; i++) {
			var sc = ss[i].split(",");
			var op = new Option(sc[1], sc[0]);// 1可见；  2 value	
			document.getElementById("sc").add(op);
		}
		// alert(s);
		//document.getElementById("res").value= s;
	}
}
function checkPost() {
	var n = document.getElementById("po").value;
	if (n == "") {
		alert("请输入邮编");
	}
	if (isNaN(n)) {
		alert("请输入数字");
	}
}
function checkPhone() {
	var n = document.getElementById("ph").value;
	if (n == "") {
		alert("请输入联系电话");
	}
	if (isNaN(n)) {
		alert("请输入数字");
	}
}
function checkLocation(){
	if(document.getElementById("town").value=="0"||document.getElementById("city").value=="0"
		||document.getElementById("cap").value=="0"){
		document.getElementById('tip1').innerHTML = "未选择地区";
	}else{
		document.getElementById('tip1').innerHTML = "";
	}
}
function checkAddre(){
  var n = document.getElementById("stre").value;
  if (n == "") {
		alert("请输入街道地址");
	}
}
</script>
	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<div id="middle" style="min-height: 600px;">
			<form method="post" action="servlet/PostServlet" name="p">
				<div class="left">
					<table bgcolor="#EEEEEE" align="center">
					
					<tr>
						<td class="firstline">
										邮递历史:
									</td>
								</tr>
						<c:if test="${ not   empty addresslist }">
							<c:forEach items="${ addresslist}" var="al">
								
								<tr>
									<td>
										<input type="radio" name="iad"
											value="${al.f_address}|${al.s_address}|${al.receiver}|${al.phone}|${al.post_number}|${al.addressID}" />
										${al.f_address} &nbsp; ${al.s_address} ${al.receiver}
										${al.phone} ${al.post_number}
									</td>
							</c:forEach>

							<tr>
								
							  <td></td>
								<td>
									<input type="submit" value="提交" name="com" />
								</td>
							</tr>
						</c:if>
					</table>
				</div>
				<div class="right">
					<table align="center" cellspacing="20" class="t2" bgcolor="#EEEEEE">
				
						<tr>
							<td class="firstline" colspan="2">
								新增邮递信息：
							</td>
						</tr>
						<tr>
							<td>
								收货人姓名：
							</td>
							<td>
								<input type="text" name="receiver" />
							</td>
						</tr>
						<tr>
							<td>
								所在地区：
							</td>
							<td>
								<select id="cap" name="cap" onchange="checkCap()" class="select">
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

							</td>
						</tr>
						<tr>
							<td>
								街道地址：
							</td>
							<td>
								<input type="text" name="saddress" onchange="checkAddre()" id="stre"/>
							</td>
						</tr>
						<tr>
							<td>
								邮政编码：
							</td>
							<td>
								<input type="text" name="postnumber" id="po"
									onchange="checkPost()" />
							</td>
						</tr>
						<tr>
							<td>
								联系电话：
							</td>
							<td>
								<input type="text" name="phone" id="ph" onchange="checkPhone()" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td align="center">
								<input type="submit" value="更新" name="change" />
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>