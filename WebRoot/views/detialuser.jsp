<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基本信息</title>

</head>
<body>
	<c:if test="${not empty user }">
			<table id="user">
				<tr>
					<td>姓名：</td>
					<td>${ user.uname }</td>
				</tr>
				<tr>
					<td>身份证：</td>
					<td>${ user.uid }</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>${ user.usex }</td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td>${ user.uage }</td>
				</tr>
				<tr>
					<td>地址：</td>
					<td>${ user.uaddress }</td>
				</tr>
				<tr>
					<td>电话：</td>
					<td>${ user.uphone }</td>
				</tr>
			</table>
	</c:if>
	
	<c:if test="${ empty user }">
		<h3>亲，您还没有<a href="login.jsp" target="_parent">登录</a></h3>
	</c:if>
</body>
</html>