<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基本信息</title>
</head>
<body>
<table id="user">
				<tr>
					<td>姓名：</td>
					<td>${ manager.mname }</td>
				</tr>
				<tr>
					<td>编号：</td>
					<td>${ manager.mid }</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>${ manager.msex }</td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td>${ manager.mage }</td>
				</tr>
				
			</table>
</body>
</html>