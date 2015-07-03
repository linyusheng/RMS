<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#registerDialog').show().dialog({
			modal : true,
			closed : true,
			buttons : [ {
				text : '注册',
				handler : function() {
					register();
				}
			},{
				text : '取消',
				handler : function() {
					$('#registerDialog').dialog('close');
				}
			}]
		});
	});
	function register() {
		if ($('#regForm').form('validate')) {
			//对用户名唯一性验证
			var userName = $('#regForm input[name="userName"]').val();
			$.post('${pageContext.request.contextPath}/user/isUserNameExist',{userName:userName},function(result){
				//若用户名已存在
				if(result.success){
					alert(result.msg);
					return;
				}else{
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					$.post('${pageContext.request.contextPath}/admin/register', $('#regForm').serialize(), function(result) {
						if (result.success) {
							$('#successDialog').dialog({
								closable:false,
								title:'提示',    
							    width:280,    
							    height:100,    
							    modal:true,
							    content:'<center><h2 style="line-height:60px;">注册成功!正在登录中...</h2></center>'   
							});
							setTimeout("window.location.href='${pageContext.request.contextPath}/admin/index'",1000);
							
						} else {
							$.messager.alert('错误', result.msg, 'error');
						}
						parent.$.messager.progress('close');
					}, "JSON");
				}
			},"JSON");
			
		}
	}
</script>
<style>
<!--
table{margin:0 auto;}
tr{height:40px;}
input{height:20px;border:1px solid #95B8E7;}
-->
</style>
<div id="registerDialog" title="用户注册" style="width: 330px; height: 220px; overflow: hidden; display: none;">
	<form id="regForm" method="post">
		<table style="margin-top:11px;">
			<tr>
				<th>登录名</th>
				<td><input name="userName" type="text" placeholder="请输入登录名" class="easyui-validatebox" data-options="required:true"></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input name="password" type="password" placeholder="请输入密码" class="easyui-validatebox" data-options="required:true"></td>
			</tr>
			<tr>
				<th>重复</th>
				<td><input name="rePassword" type="password" placeholder="请再次输入密码" class="easyui-validatebox" data-options="required:true,validType:'eqPwd[\'#regForm input[name=password]\']'"></td>
			</tr>
		</table>
	</form>
</div>
<div id="successDialog"></div>