<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>管理系统</title>
    <link href="css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css" />
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.1.2.6.min.js"></script>
	<script type="text/javascript" src='js/index.js'> </script>
	<style type="text/css">
		*{
			font-size: 14px;
		}
		.head a{
			display: inline-block;
			text-decoration: none;
			font-size: 14px;
			padding-top: 3px;
		}
		#maintitle {
			background: url("images/bg3.jpg") no-repeat;
			background-size: 100% 100%;
			width: 100%;
			height: 100%;
		}
		#title{
			text-align: center;
			font-size: 50px;
			height: 100px;
			line-height: 100px;
			font-family: "微软雅黑";
			margin: 15% auto 0 auto;
		}
	</style>
</head>
<body class="easyui-layout" style="overflow-y: hidden"  fit="true"   scroll="no">
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
</div></noscript>

    <div region="north" split="false" border="false" style="overflow: hidden; height: 30px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="padding-left:10px; font-size: 16px; "><img src="images/blocks.gif" width="20" height="20" align="absmiddle" />车辆违章信息管理系统</span>
        <span style="float:right; padding-right:20px;" class="head">
        <c:if test="${ empty user }">
        	<a href="views/login.jsp" >登录</a>
        </c:if>
        <c:if test="${ not empty user }">
        	欢迎${user.uname }   
        	<a href="#" id="editpass">修改密码</a> <a href="${ pageContext.request.contextPath }/users/outUser.action" id="loginOut" style="">安全退出</a>
        </c:if>
        	</span>
        
    </div>
    <div region="south" split="false" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">车辆违章信息管理系统 V1.0</div>
    </div>
    <div region="west" split="true"  title="导航菜单" style="width:180px;" id="west">
			<div id="nav">
			<!--导航内容 -->
			</div>

    </div>
   <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
       <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="欢迎使用"  id=maintitle>
				<p id="title">欢迎使用车辆违章信息管理系统</p>
			</div> 
			
		</div>
    </div>
    
    
    <!--修改密码窗口-->
    <div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                    <tr>
                        <td>新密码：</td>
                        <td><input id="txtNewPass" type="password" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input id="txtRePass" type="password" class="txt01" /></td>
                    </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    确定</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>


</body>
</html>