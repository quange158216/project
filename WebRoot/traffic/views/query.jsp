<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询</title>
</head>
<body>
	<c:if test="${ not empty traffic }">
		<form action="${ pageContext.request.contextPath }/detialCat/detialCat.action" method="post">
			<table cellpadding="5">
				<tr>
					<td>车牌号码：</td>
					<td><input type="text" name="dlicensePlateNumber"></td>
					<td><input type="submit" value="查询"></td>
				</tr>
			</table>
		</form>
		<c:if test="${ load eq 'second' }">
			<c:if test="${ empty detialCat }">没有该车牌号车辆</c:if>
		</c:if>
		<c:if test="${ not empty detialCat }">
			<table>
				<tr>
					<td>用户身份证：</td>
					<td>${ detialCat.users.uid }</td>
				</tr>
				<tr>
					<td>用户姓名：</td>
					<td>${ detialCat.users.uname }</td>
				</tr>
				<tr>
					<td>车牌号：</td>
					<td>${ detialCat.dlicensePlateNumber }</td>
				</tr>
				<tr>
					<td>车颜色：</td>
					<td>${ detialCat.dcolor }</td>
				</tr>
				<tr>
					<td>发动机型号：</td>
					<td>${ detialCat.dengineType }</td>
				</tr>
				<tr>
					<td>汽车类型：</td>
					<td>${ detialCat.dtype }</td>
				</tr>
				<tr>
					<td>汽车品牌：</td>
					<td>${ detialCat.dbrand }</td>
				</tr>
				<tr>
					<td>汽车出厂时间：</td>
					<td>${ detialCat.dcreatetime }</td>
				</tr>
			</table>
		</c:if>
	</c:if>
	<c:if test="${ empty traffic }">亲，您还没有登录，请路<a href="login.jsp" target="_parent">登陆</a>后在查询</c:if>
</body>
</html>