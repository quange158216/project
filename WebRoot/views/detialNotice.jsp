<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告内容</title>
<style type="text/css">
	h3{
		display:block;
		text-align: center;
		font-size: 30px;
		height: 60px;
		line-height: 60px;
		margin: 50px 0;
	}
</style>
</head>
<body>
<h3>${ noticeone.ntitle }</h3>
<div class="text">
${ noticeone.ntext }
</div>
</body>
</html>