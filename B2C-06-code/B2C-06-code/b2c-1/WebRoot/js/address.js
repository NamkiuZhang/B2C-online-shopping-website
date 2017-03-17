function confirmDelete(para1,para2){
	if (confirm("确认删除地址"))
		window.location = "address.servlet?action=" +para1+"&aid="+para2;
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
function sendRequest1(url) {
	var xmlReq = getXmlHttpRequest();
	xmlReq.onreadystatechange = processResponse1;
	xmlHttp.open("POST", url, true);
	xmlHttp.send(null);
}

function processResponse1() {
	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {//信息已成功返回
		document.getElementById("city").options.length=1;
		var s = xmlHttp.responseText;
		var ss = s.split(";");
	    for(var i = 0 ;i < ss.length;i++)
	    {
	    	var sc = ss[i].split(",");
	    	var op = new Option(  sc[0] , sc[1]   );// 1可见；  2 value	
	    	document.getElementById("city").add(op);
	    }
	}
}
function checkCap() {
	var name = document.getElementById("cap").value;
	if (name != "0") {
		sendRequest1("address.servlet?action=getnextposition&id=" + name);
	}
}

function checkCity() {
	var name = document.getElementById("city").value;
	if (name != "0") {
		sendRequest2("address.servlet?action=getnextposition&id=" + name);
	}
}

function sendRequest2(url) {
	var xmlReq = getXmlHttpRequest();
	xmlReq.onreadystatechange = processResponse2;
	xmlHttp.open("POST", url, true);
	xmlHttp.send(null);
}

function processResponse2() {
	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {//信息已成功返回
		document.getElementById("town").options.length=1;
		var s = xmlHttp.responseText;
		var ss = s.split(";");
	    for(var i = 0 ;i < ss.length;i++)
	    {
	    	var sc = ss[i].split(",");
	    	var op = new Option(  sc[0] , sc[1]   );// 1可见；  2 value	
	    	document.getElementById("town").add(op);
	    }
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

function checkPost(){
	var post=document.getElementById("post").value;
	var c=/^\d{6}$/;
	if(post.length!=6||!c.test(post)){
		document.getElementById('tip2').innerHTML = "邮编格式不正确";
	}else{
		document.getElementById('tip2').innerHTML = "";
	}
}

function checkRoad(){
	if(document.getElementById("road").value==""){
		document.getElementById('tip3').innerHTML = "请填写地址";
	}else{
		document.getElementById('tip3').innerHTML = "";
	}
}

function checkForm(){
	checkLocation();
	checkPost();
	checkRoad();
	for(var i=1;i<4;i++){
		if(document.getElementById('tip'+i).innerHTML != ""){
			alert("表单有错误");
			return false;
			break;
		}
	}
}