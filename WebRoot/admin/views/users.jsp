<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆信息</title>
<link rel="stylesheet" type="text/css" href="../ui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../ui/themes/icon.css">
<script type="text/javascript" src="../ui/jquery.min.js"></script>
<script type="text/javascript" src="../ui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../ui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<script type="text/javascript">
	$(function(){
		//datagrid表格显示的数据
		var columns=[[
			{field:'uid', title:'编号',width:150},
			{field:'uname', title:'姓名',width:100},
			{field:'upassword', title:'密码',width:120},
			{field:'usex', title:'性别',width:120},
			{field:'uage', title:'年龄',width:120},
			{field:'uaddress', title:'地址',width:200},
			{field:'uphone', title:'电话',width:120},
		]]
		
		//加载datagrid
		$('#grid').datagrid({
			striped: true,//条纹显示效果
			url:'http://localhost:8080/tpms/users/findUsers.action',//数据来源
			columns:columns,//显示数据字段
			pagination:true,//显示分页
			pageSize:10,
			pageList:[10,20,30,40],
			rownumbers:true,//是否显示行号
			
		});
	});
	
</script>
</head>
<body>
<table id="grid"></table>
</body>
</html>