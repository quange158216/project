<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			body,html{
				height: 100%;
				background: url(images/bg3.jpg) no-repeat;
				background-size:100% 103%;
				overflow: hidden;
				font-family: "微软雅黑";
			}
			*{
				margin: 0;
				padding: 0;
			}
			.container{
				border: 20px solid rgba(255,255,255,0.3);
				position: absolute;
				left: 38%;
				top: 20%;
			}
			.content{
				width: 420px;
				height: 250px;
				background-color: white;
			}
			.content .logo{
				font-size: 40px;
				display: block;
				height: 100px;
				line-height: 100px;
				text-align: center;
				color: rgb(3,93,205);
			}
			a.button{
				text-decoration: none;
				color: #fff;
				background: rgb(1,61,171);
				display: inline-block;
				height: 50px;
				line-height: 50px;
				font-size: 18px;
				padding: 0 15px;
				margin-left: 60px;
				margin-top: 30px;
			}
		</style>
	</head>
	<body>
		<div class="container">
				<div class="content">
					<p class="logo">车辆违章信息管理系统</p>
					<a href="${ pageContext.request.contextPath }/notice/list.action?ut=1" class="button">普通用户</a>
					<a href="${ pageContext.request.contextPath }/notice/list.action?ut=2" class="button">交警用户</a>
				</div>
		</div>
	</body>
</html>
