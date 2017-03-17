
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" > 
<html xmlns:ui="http://xmlns.jcp.org/jsf/facelets">
	<head>
		<title>cartl.html</title>
		
		<link rel="stylesheet" type="text/css" href="css/cartlist.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
<style type="text/css">

#tabletop {
	margin-left: 120px;
	margin-top: 20px;
}

</style>
  <script type="text/javascript" src="js/loadlist_detail.js">
  </script>
		<script type="text/javascript">
var input = document.getElementsByTagName("input");
function checkAll(b) {
	var sums = 0;
	for ( var i = 0; i < input.length; i++) {
		if (input[i].type == "checkbox") {
			input[i].checked = b;

		}
	}
	if (b == true) {
		var eachvs = document.getElementsByName("eachTotal");
		for ( var i = 0; i < eachvs.length; i++) {
			sums += parseFloat(eachvs[i].value);
		}
		document.getElementById("acount").value = sums;
	} else {
		document.getElementById("acount").value = 0;
	}
}
function mines(node) {
	var tr1 = node.parentNode.parentNode.rowIndex;
	document.getElementsByName("quantity")[tr1 - 1].value--;
	var v = 0;
	v = document.getElementsByName("quantity")[tr1 - 1].value;
	if (v < 0) {
		document.getElementsByName("quantity")[tr1 - 1].value = 0;
		document.getElementsByName("eachTotal")[tr1 - 1].value = 0;
		return;
	}
	calcuateEachm(node);
}
function add(node) {
	var tr1 = node.parentNode.parentNode.rowIndex;
	document.getElementsByName("quantity")[tr1 - 1].value++;
   var m= 0;
	m = document.getElementsByName("quantity")[tr1 - 1].value;
    calcuateEachAdd(node);

}
function calcuateEachAdd(node,m){
   var tr1 = node.parentNode.parentNode.rowIndex;
   var m= 0;
	m = document.getElementsByName("quantity")[tr1 - 1].value;
   var p = 0;
	p = document.getElementsByName("price")[tr1 - 1].value;
	document.getElementsByName("eachTotal")[tr1 - 1].value = p * m;
	if(document.getElementsByName("prod")[tr1 - 1].checked){
	    var sum=0;
	    sum= document.getElementById("acount").value;	  
	    sum=parseFloat(sum)+parseFloat(p);  
	    document.getElementById("acount").value=sum;
	}
}
function calcuateEachm(node,m){
   var tr1 = node.parentNode.parentNode.rowIndex;
   var m= 0;
	m = document.getElementsByName("quantity")[tr1 - 1].value;
   var p = 0;
	p = document.getElementsByName("price")[tr1 - 1].value;
	document.getElementsByName("eachTotal")[tr1 - 1].value = p * m;
	if(document.getElementsByName("prod")[tr1 - 1].checked){
	    var sum=0;
	    sum= document.getElementById("acount").value;	  
	    sum=parseFloat(sum)-parseFloat(p);  
	    document.getElementById("acount").value=sum;
	}
}

function count(node) {
	var sum = 0;
	var t = 0;
	var tr1 = node.parentNode.parentNode.rowIndex;
	document.getElementById("qin").value=tr1+"m";
	if (node.checked) {
		if (document.getElementById("acount").value != "") {
			sum = parseFloat(document.getElementById("acount").value);
		}
		t = document.getElementsByName("eachTotal")[tr1 - 1].value;
		sum += parseFloat(t);
		document.getElementById("acount").value = sum;
	} else {
		t = document.getElementsByName("eachTotal")[tr1 - 1].value;
		sum = document.getElementById("acount").value;
		if(sum!=0)
		document.getElementById("acount").value = sum - t;
	}

}
function getIndex(node){
   var tr1 = node.parentNode.parentNode.rowIndex;
   document.getElementById("in").value=tr1-1;
   document.getElementById("re").value="删除";
   myform.submit();
}
function handin(){
document.getElementById("va").value="结算";
 myform.submit();
}
function start(){
loadList_Detail();
checkAll(true);
}
</script>


	</head>
	<body onload="start()">
		<jsp:include page="header.jsp" />
		<div id="middle" style="min-height: 600px;">
          <div id="tabletop">
          </div>
			<form action="servlet/CartServlet" method="post" name="myform">
				<table >
					<tr id="tablehead">
						<td style="width:30px"></td>
						<td></td>
						<th class="firstline">
							商品
						</th>
						<th>
							单价
						</th>
						<th class="thirdline">
							数量
						</th>
						<th>
							价格
						</th>
						<th>
							操作
						</th>
					</tr>
					<c:if test="${empty productincart }">
						<tr>
							<td colspan="3">
								购物车为空！ 去首页！
								<a href="index.jsp">go</a>
							</td>
						</tr>
					</c:if>
					<c:if test="${ not   empty  productincart }">
						<c:forEach items="${productincart }" var="pro">
							<tr>
								<td>
									<input type="checkbox" onclick="javascript:count(this);"
										name="prod" value="${pro.product_id}" style="width:30px"/>
									<input type="hidden" name="oid" value="${pro.product_id}" />
								</td>
								<td>
									<img src="${pro.image }" style="height:180px;width:150px"/>
									<input type="hidden" name="im" value="${pro.image }" />
								</td>
								<td class="firstline">
									<a href="product.servlet?pro_id=${pro.product_id }">${pro.product_name}</a>
									<input type="hidden" name="na" value="${pro.product_name}" />
								</td>
								<td>
									<input type="hidden" name="price" value="${pro.product_price}" />
									${pro.product_price}
								</td>
								<td class="thirdline">

									<button onclick="javascript:mines(this);return false;">
										-
									</button>
									&nbsp;
									<input type="text" size="5" name="quantity"
										value="${pro.quantity }" onchange="calcuateEach(this);return false;">
									&nbsp;
									<button onclick="javascript:add(this); return false;">
										+
									</button>
								</td>
								<td>
									<input type="text" name="eachTotal" value="${pro.total }"
										readonly="readonly" />


								</td>
								<td>
								<input type="hidden" id="in" name="index" />
						           <input type="hidden" name="remo"  id="re"/>
						           <button onclick="javascript:getIndex(this);return false;" >删除</button>
									
								</td>

							</tr>
						</c:forEach>
						<tr>
							<td></td>

							<td align="right">
								<input type="button" name="all"
									onclick="javascript:checkAll(true);return false;" value="全选" />

							</td>
							<td align="left">
								<button onclick="javascript:checkAll(false);return false;">
									清除
								</button>
							</td>
						</tr>

						<tr>
							<td></td>
							<td></td>
							<td><br><br></td>
							<td>
								总价 :
							</td>
							<td>
								<input type="text" id="acount"  name="v"
									readonly="readonly" />

							</td>
							<td>
								<input type="hidden" id="qin" name="qindex" />
                                <input type="hidden" name="vau"  id="va"/>
								<button onclick="javascript:handin();"  >结算</button>

							</td>
						</tr>
					</c:if>
				</table>

			</form>
		</div>
		<jsp:include page="footer.jsp" />
	</body>
</html>