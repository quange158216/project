<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
<link rel="stylesheet" type="text/css" href="../css/reg-layout.css"/>
</head>
<body>
	<div class="reg-container">
		<p style="color: red; font-weight: 900">${msg }</p>
		<p class="reg-header">新用户注册</p>
		<form action="${ pageContext.request.contextPath }/users/reguser.action" method="post">
			<table border="1">
				<tr>
					<td>用户名：</td>
					<td class="text-input"><input type="text" name="uname"required="required" placeholder="请输入您的用户名" class="verify-input"/></td>
					<td id="username-info">请输入真实姓名</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td class="text-input"><input type="password" name="upassword"required="required" class="verify-input"/></td>
					<td id="psw-info">字母、数字、下划线，6-16位</td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td class="text-input"><input type="password" name="repassword" required="required" class="verify-input"/></td>
					<td id="repsw-info">再次输入密码</td>
				</tr>
				<tr>
					<td>身份证号：</td>
					<td class="text-input"><input type="text" name="uid" required="required" placeholder="请输入您的身份证号码" class="verify-input"/></td>
					<td id="card-info">身份证号码请保证真实性</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td class="reg-sex"><label><input type="radio" name="usex" value="男"/ class=".sex">帅哥</label>
					<label><input type="radio" name="usex" value="女" class=".sex"/>美女</label></td>
					<td>请选择性别</td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td class="text-input"><input type="number" name="uage" required="required" min="0" max="120" class="verify-input"/></td>
					<td id="age-info">请填写您的年龄</td>
				</tr>
				<tr>
					<td>地址：</td>
					<td class="text-input"><input type="text" name="uaddress" placeholder="输入地址"/></td>
					<td>请输入您的具体地址</td>
				</tr>
				<tr>
					<td>电话：</td>
					<td class="text-input"><input type="tel" name="uphone"/></td>
					<td>请填写您的电话</td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="注册" class="sub-btn" onclick="verify()"/><input type="reset" value="重置" class="sub-btn"></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
			<!--用户名验证-->
			var username = document.getElementsByClassName('verify-input')[0];
			username.onblur = function(){
				var usernameInfo = document.getElementById('username-info');
				if(username.value==""){
					usernameInfo.innerText = "用户名格式不正确";
					usernameInfo.style.color = "red";
				}else{
					usernameInfo.innerText = "验证通过";
					usernameInfo.style.color = "green";	
				}
			}
			<!--密码格式验证-->
			var psw = document.getElementsByClassName('verify-input')[1];
			psw.onblur = function(){
				var pswinfo = document.getElementById('psw-info');
				var pswValue = psw.value;
				var reg2 = /^[\w]{6,16}$/;
				if(pswValue == "" | reg2.test(pswValue) === false ) 
				{ 
					pswinfo.innerText = "密码格式不正确！"
					pswinfo.style.color="red";
				}else{
					pswinfo.innerText = "验证通过"
					pswinfo.style.color="green";
				}
			}
			//密码一致性验证-->
			var repsw = document.getElementsByClassName('verify-input')[2];
			repsw.onblur = function(){
				var pswValue = psw.value;
				var repswValue = repsw.value;
				var repswinfo = document.getElementById('repsw-info');
				if(pswValue!==repswValue){
				repswinfo.innerText = "两次密码不一致！"
				repswinfo.style.color="red";
				}else{
				repswinfo.innerText = "验证通过"
				repswinfo.style.color="green";					
				}
			}
			//身份证验证
			var card = document.getElementsByClassName('verify-input')[3];
			card.onblur = function(){
				var cardValue = card.value;
				var reg1 = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
				var cardinfo = document.getElementById('card-info');
				if(reg1.test(cardValue) === false) 
				{ 
					cardinfo.innerText = "格式不正确！"
					cardinfo.style.color="red";
				}else{
					cardinfo.innerText = "验证通过！"
					cardinfo.style.color="green";
				}
			}
			//年龄验证
			var age = document.getElementsByClassName('verify-input')[4];
			age.onblur = function(){
				var ageInfo = document.getElementById('age-info');
			if(age.value==""){
				ageInfo.innerText = "年龄不能为空!";
				ageInfo.style.color = "red";
			}else{
				ageInfo.innerText = "验证通过";
				ageInfo.style.color = "green";
			}
			}

	</script>
</body>
</html>