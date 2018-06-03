<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
<link rel="stylesheet" type="text/css" href="../css/logo-layout.css"/>
</head>
<body>
	<div class="logo-container">
	<p style="color: red; font-weight: 900" class="reg-p">${msg }</p>
	<form action="${ pageContext.request.contextPath }/manager/managerlogin.action" method="post">
		用户名<input type="text" name="mname"/ required="required"><br/>
		密　码<input type="password" name="mpassword" required="required"/><br/>
		<input type="submit" value="登录" class="sub"/>
	</form>	
		
	</div>
</body>
</body>
</html>