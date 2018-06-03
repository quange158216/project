<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../ui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../ui/themes/icon.css">
<script type="text/javascript" src="../ui/jquery.min.js"></script>
<script type="text/javascript" src="../ui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../ui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<title>添加公告信息</title>
</head>
<body>
	<form action="${ pageContext.request.contextPath }/notice/addNotice.action" method="post">
	
		<table>
			<tr>
				<td>标题</td>
				<td><input type="text" name="ntitle"/></td>
			</tr>
			<tr>
				<td>内容</td>
				<td><textarea name="ntext" cols="100" rows="25"></textarea></td>
			</tr>
			<tr>
				<td>时间</td>
				<td><input type="text" name="ttime" class="easyui-datetimebox"/></td>
			</tr>
			<tr>
				<td>作者</td>
				<td><input type="text" name="nauthor"/></td>
			</tr>
			<tr>
		  		<td colspan="2">
		  			<input type="submit" value="保存"/>
		  		</td>
		  	</tr>
		</table>
	</form>
</body>
</html>