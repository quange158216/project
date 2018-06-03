<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			{field:'dlicensePlateNumber', title:'车牌号',width:100},
			{field:'dcolor', title:'颜色',width:120},
			{field:'dengineType', title:'发动机型号',width:120},
			{field:'dtype', title:'车辆类型',width:120},
			{field:'dbrand', title:'车辆品牌',width:120},
			{field:'dcreatetime', title:'出厂时间',width:150},
		]]
		
		//加载datagrid
		$('#grid').datagrid({
			striped: true,//条纹显示效果
			url:'../detialCat/list.action',//数据来源
			columns:columns,//显示数据字段
			pagination:true,//显示分页
			pageSize:10,
			pageList:[10,20,30,40],
			rownumbers:true,//是否显示行号
			toolbar:[{//工具栏
				id:'btnadd',
				text:'添加',
				iconCls:'icon-add',
				handler:add
			}]
		});
	});
	//开新窗口，添加用户信息
	function add(){
		$('#detialCatWindow').form('clear');
		$('#detialCatWindow').window({modal: true});
		$('#detialCatWindow').window('open');
	}
	//提交用户数据
	function addSubmit(){
		$('#detialCatForm').form('submit', {    
		    url:'http://localhost:8080/tpms/detialCat/insertCat.action',       
		    success:function(data){ 
		    	//json串转对象
		    	var result = eval('('+ data + ')');
		    	$.messager.alert('提示',result.message);
				//刷新页面
				if(result.success){
					//刷新datagrid
					//1 调用query
					//2调用datagrid的reload方法
					$('#grid').datagrid('reload');
					$('#detialCatWindow').window('close'); 
				}
		    }    
		});  
	}
</script>
</head>
<body>
	<c:if test="${not empty user }">
			<table id="grid"></table>
			<div id="detialCatWindow" class="easyui-window" title="汽车信息" style="width:600px;height:400px"   
	        data-options="iconCls:'icon-save',closed:true">   
	    <form id="detialCatForm" method="post">
	    	<table cellpadding="5">
			  	<tr>
			  		<td>车牌号:</td>
			  		<td><input  type="text" name="dlicensePlateNumber" ></input></td>
			  	</tr>
			  	<tr>
			  		<td>发动机型号:</td>
			  		<td><input  name="dengineType" ></input></td>
			  	</tr>
			  	<tr>
			  		<td>汽车品牌:</td>
			  		<td><input  type="text" name="dbrand" ></input></td>
			  	</tr>
			  	<tr>
			  		<td>汽车出厂时间:</td>
			  		<td><input  type="text" name="dcreatetime" class="easyui-datetimebox" data-options="editable:false"/></td>
			  	</tr>
			  	<tr>
			  		<td>汽车类型</td>
			  		<td><input type="text" name="dtype" /></td>
			  	</tr>
			  	<tr>
			  		<td>颜色:</td>
			  		<td><input type="text" name="dcolor" /></td>
			  	</tr>
			  	<tr>
			  		<td colspan="2">
			  			<button id="customerBtn" type="button" onclick="addSubmit()">保存</button>
			  		</td>
			  	</tr>
			  </table>
		</form>    
			</div> 
	</c:if>
	
	<c:if test="${ empty user }">
		<h3>亲，您还没有<a href="login.jsp" target="_parent">登录</a></h3>
	</c:if>
</body>
</html>