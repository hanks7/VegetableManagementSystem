<%@ page import="com.imocc.vegetable.uitls.Ulog" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<%
		String basePath = request.getScheme() + ":" + "//" + request.getServerName() + ":" + request.getServerPort() + "/"
				+ request.getServletContext().getContextPath();
		Ulog.i("basepath", basePath);
	%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜品信息展示</title>
<style type="text/css">

</style>
</head>
<body>
	<center>
		<h1>菜品查询</h1>
		<table border="1px" cellspacing="0px" cellpadding="0px" width="800px">
			<thead>
				<tr>
					<th>菜品ID</th>
					<th>菜名</th>
					<th>口味</th>
					<th>菜品图片</th>
					<th>价格</th>
					<th>菜品描述</th>
				</tr>
			</thead>
			<tbody>
				
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>

			</tbody>
		</table>
	</center>
</body>
</html>