<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../ui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../ui/themes/icon.css">
<script type="text/javascript" src="../ui/jquery.min.js"></script>
<script type="text/javascript" src="../ui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../ui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<script type="text/javascript">
$(function(){//datagrid表格显示的数据
	var columns=[[
		{field:'tid', title:'编号',width:150},
		{field:'ttime', title:'违法时间',width:150},
		{field:'tsite', title:'违法地点',width:200},
		{field:'tunlawfulAct', title:'违法行为',width:150},
		{field:'tscore', title:'记分',width:120},
		{field:'tfine', title:'罚款',width:120},
		{field:'tstate', title:'状态',width:120,formatter:function(value,row,index){
			if(row.tstate){
				return "未处理";
			}
			return "已处理"
		}},
		
		{field:'detialCat.dlicensePlateNumber', title:'汽车车牌号',width:120,formatter:function(value,row,index){
			if(row.detialCat){
				return row.detialCat.dlicensePlateNumber;
			}
		}},
	]]
	
	//加载datagrid
	$('#grid').datagrid({
		striped: true,//条纹显示效果
		url:'http://localhost:8080/tpms/ticket/userslist.action',//数据来源
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
	<c:if test="${not empty user }">
			<table id="grid"></table>
	</c:if>
	
	<c:if test="${ empty user }">
		<h3>亲，您还没有<a href="login.jsp" target="_parent">登录</a></h3>
	</c:if>
		


</body>

</html>