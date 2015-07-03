<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.lock{margin:0 auto;margin-top:11px;}
.lock th{text-align: right;padding-right:5px;}
.lock tr{height:40px;}
.lock input{height:20px;border:1px solid #95B8E7;}
</style>
<script type="text/javascript">
	$(function() {
		$('#lockForm').form({
			url : '${pageContext.request.contextPath}/admin/login',
			onSubmit : function() {
				var isValid = $(this).form('validate');
				return isValid;
			},
			success : function(result) {
				result = $.parseJSON(result);
				if (result.success) {
					$('#lockDialog').dialog('close');
				} else {
					parent.$.messager.alert('错误', result.msg, 'error');
				}
			}
		});
	});
</script>
<form id="lockForm" method="post">
	<input type="hidden" name="userName" value="${userName}">
	<table class="lock">
		<tr>
			<th>登录名</th>
			<td><input type="text" value="${userName}" disabled="true"></td>
		</tr>
		<tr>
			<th>密码</th>
			<td><input name="password" type="password" placeholder="请输入密码" class="easyui-validatebox" data-options="required:true"></td>
		</tr>
	</table>
</form>