<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'print.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/cartlist.css">
<style>

table{
  margin-top:50px
}
tr{
 background:white;
}
#tablehead{
 background-color:white;
 margin-top:30px;
 width:90%
}
</style>
	</head>

	<body>
		<form action="servlet/OrderServlet" method="post">
			打印订单：
			<table border="1">
			
				<tr id="tablehead">
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

				</tr>

				<c:if test="${ not   empty  printorder}">
					<c:forEach items="${printorder}" var="svo" step="1" varStatus="s">
						<tr>
                         
							<td>
								<img src="${svo.image }" />
							</td>
							<td class="firstline">
								${svo. product_name}

							</td>
							<td>
								${svo.product_price }
							</td>
							<td class="thirdline">

								${svo.quantity}

							</td>
							<td>

								${svo.total}
							</td>
						</tr>
					</c:forEach>

					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td>用户：${user }</td>
						<td>
							<input type="submit" value="返回" name="return" />
						</td>
					</tr>

				</c:if>
			</table>
		</form>
	</body>
</html>
