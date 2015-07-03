<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.editPassword{margin:0 auto;margin-top:11px;}
.editPassword tr{height:40px;}
.editPassword input{height:20px;border:1px solid #95B8E7;}
</style>
<script type="text/javascript">
	$(function() {
		$('#editPwdForm').form({
			url : '${pageContext.request.contextPath}/user/editPassword',
			onSubmit : function() {
				parent.$.messager.progress({
					title : '提示',
					text : '数据处理中，请稍后....'
				});
				var isValid = $(this).form('validate');
				if (!isValid) {
					parent.$.messager.progress('close');
				}
				return isValid;
			},
			success : function(result) {
				parent.$.messager.progress('close');
				result = $.parseJSON(result);
				if (result.success) {
					parent.$.messager.alert('提示', result.msg, 'info');
					$('#editPwdDialog').dialog('close');
				} else {
					parent.$.messager.alert('错误', result.msg, 'error');
				}
			}
		});
	});
</script>
<form id="editPwdForm" method="post">
	<table class="editPassword">
		<tr>
			<th>原密码</th>
			<td><input name="oldPwd" type="password" placeholder="请输入原密码" class="easyui-validatebox" data-options="required:true"></td>
		</tr>
		<tr>
			<th>新密码</th>
			<td><input name="pwd" type="password" placeholder="请输入新密码" class="easyui-validatebox" data-options="required:true"></td>
		</tr>
		<tr>
			<th>重复</th>
			<td><input name="rePwd" type="password" placeholder="请再次输入新密码" class="easyui-validatebox" data-options="required:true,validType:'eqPwd[\'#editPwdForm input[name=pwd]\']'"></td>
		</tr>
	</table>
</form>
