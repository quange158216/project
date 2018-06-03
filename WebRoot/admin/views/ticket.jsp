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
			{field:'del', title:'操作',width:120,formatter:function(value,row,index){
				return "<a href='#' onclick='edit("+row.tid+")'>修改</a> <a href='#' onclick='del("+row.tid+")'>删除</a>";
			}}
		]]
		
		//加载datagrid
		$('#grid').datagrid({
			striped: true,//条纹显示效果
			url:'http://localhost:8080/tpms/ticket/list.action',//数据来源
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
	//删除
	function del(id){
			$.messager.confirm('提示', '确定删除此罚单', function(r){
				if (r){
					$.ajax({
						url:'http://localhost:8080/tpms/ticket/deleteTicket.action?tid='+id,
						dataType:'json',//预期服务端返回json
						success:function(result){
							//提示操作结果
							$.messager.alert('提示',result.message);
							//刷新页面
							if(result.success){
								//刷新datagrid
								//1 调用query
								//2调用datagrid的reload方法
								$('#grid').datagrid('reload');
							}
						}
					});
				}
			});
		}
	//标签 确定是删除用户还是修改用户
	var method
	
	//保存方法
	function save(){
		if(method == 'add'){
			addSubmit();
		}else{
			editSubmit();
		}
	}
	//开新窗口，添加用户信息
	function add(){
		$('#ticketWindow').form('clear');
		$('#ticketWindow').window({modal: true});
		$('#ticketWindow').window('open');
		method = 'add';
	}
	
	//提交用户数据
	function addSubmit(){
		$('#ticketForm').form('submit', {    
		    url:'http://localhost:8080/tpms/ticket/insertTicket.action',       
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
					$('#ticketWindow').window('close'); 
				}
		    }    
		});  
	}
	//修改用户
	function edit(id){
		$('#ticketForm').form({   
		     
			onLoadSuccess:function(){    
				loading();    
		    }    
		});
		
		$('#ticketForm').form('clear');
		$('#ticketForm').form('load','http://localhost:8080/tpms/ticket/findTicketByTid.action?tid='+id);
		$('#ticketWindow').window({modal: true});
		$('#ticketWindow').window('open');
		method = 'edit';
	
	}
	
	
	function editSubmit(){
		$('#ticketForm').form('submit', {    
		    url:'http://localhost:8080/tpms/ticket/updateTicket.action',       
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
					$('#ticketWindow').window('close'); 
				}
		    }    
		});  
	}
</script>
</head>
<body>
<table id="grid"></table>
<div id="ticketWindow" class="easyui-window" title="罚单信息" style="width:600px;height:400px"   
        data-options="iconCls:'icon-save',closed:true">   
    <form id="ticketForm" method="post">
    
		  
		  <table cellpadding="5">
		  	<tr>
		  
		  		<td>车牌号:</td>
		  		<td><input  type="text" name="detialCat.dlicensePlateNumber" ></input></td>
		  		<td>违法时间:</td>
		  		<td><input id="time" type="text" name="ttime" class="easyui-datetimebox"/></td>
		  		
		  	</tr>
		  	<tr>
		  		<td>违法地点:</td>
		  		<td><input  name="tsite" ></input></td>
		  		<td>违法行为</td>
		  		<td><input type="text" name="tunlawfulAct" /></td>
		  		
		  	</tr>
		  	<tr>
		  		<td>记分:</td>
		  		<td><input  type="text" name="tscore" ></input></td>
		  		<td>罚款金额:</td>
		  		<td><input type="text" name="tfine" /></td>
		  		
		  	</tr>
		  
		  	<tr>
		  		<td colspan="4">
		  			
		  			<button id="customerBtn" type="button" onclick="save()">保存</button>
		  		</td>
		  	</tr>
		  </table>
	</form>    
</div> 
</body>
</html>