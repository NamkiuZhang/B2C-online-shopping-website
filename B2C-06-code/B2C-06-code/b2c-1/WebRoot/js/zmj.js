function confirmDelete(para1, para2) {
	if (confirm("ȷ��ɾ���ַ"))
		window.location = "address.servlet?action=" + para1 + "&aid=" + para2;
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
				alert("����������֧��AJAX��");
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
	if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {//成功返回值
		document.getElementById("secondType").options.length = 1;
		var s = xmlHttp.responseText;
		var ss = s.split(";");
		for ( var i = 0; i < ss.length; i++) {
			var sc = ss[i].split(",");
			var op = new Option(sc[0], sc[1]);// 1可见 2 value	
			document.getElementById("secondType").add(op);
		}
	}
}
function checkFirstType() {
	var name = document.getElementById("firstType").value;
	if (name != "-1") {
		sendRequest1("productType.servlet?action=getSubType&id=" + name);
	}
}

function checkProductName() {
	if (document.getElementById("productName").value == "") {
		document.getElementById("tip1").innerHTML = "商品名称不能为空";
	} else {
		document.getElementById("tip1").innerHTML = "";
	}
}

function checkSelectFirstType() {
	if (document.getElementById("firstType").value == "-1") {
		document.getElementById("tip2").innerHTML = "请选择一级分类";
	} else {
		document.getElementById("tip2").innerHTML = "";
	}
}
function checkSelectSecondType() {
	if (document.getElementById("secondType").value == "-2") {
		document.getElementById("tip3").innerHTML = "请选择二级分类";
	} else {
		document.getElementById("tip3").innerHTML = "";
	}
}

function checkSearchProduct() {
	checkProductName();
	checkSelectFirstType();
	checkSelectSecondType();
	for ( var i = 1; i < 4; i++) {
		if (document.getElementById("tip" + i).innerHTML != "") {
			alert("有错误");
			return false;
		}
	}
}

function checkProPicPath() {
	if (document.getElementById("img").value == "") {
		document.getElementById("tip6").innerHTML = "请上传图片";
	} else {
		document.getElementById("tip6").innerHTML = "";
		}
	}

function checkProPrice() {
	if (document.getElementById("price").value == "") {
		document.getElementById("tip5").innerHTML = "请填写单价";
	} else {
		document.getElementById("tip5").innerHTML = "";
	}
}

function checkStorage() {
	if (document.getElementById("amount").value == "") {
		document.getElementById("tip4").innerHTML = "请添加数量";
	} else {
		document.getElementById("tip4").innerHTML = "";
	}
}

function checkAddProduct() {
	checkProductName();
	checkSelectFirstType();
	checkSelectSecondType();
	checkStorage();
	checkProPrice();
	checkProPicPath();
	for ( var i = 1; i < 7; i++) {
		if (document.getElementById("tip" + i).innerHTML != "") {
			alert("有错误");
			return false;
			break;
		}
	}
}

function checkModProduct() {
	checkProductName();
	checkSelectFirstType();
	checkSelectSecondType();
	checkStorage();
	checkProPrice();
	for ( var i = 1; i < 6; i++) {
		if (document.getElementById("tip" + i).innerHTML != "") {
			alert("有错误");
			return false;
			break;
		}
	}
}
