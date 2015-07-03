<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>权限管理系统</title>
<jsp:include page="../include.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	var loginDialog;
	var loginTabs;
	var userLoginCombobox;
	var userLoginCombogrid;
	$(function() {
		loginDialog = $('#loginDialog').show().dialog({
			modal : true,
			closable : false,
			buttons : [ {
				text : '注册',
				handler : function() {
					$('#registerDialog').dialog('open');
				}
			}, {
				text : '登录',
				handler : function() {
					loginFun();
				}
			} ]
		});
		userLoginCombobox = $('#userLoginCombobox').combobox({
			url : '${pageContext.request.contextPath}/admin/loginCombobox',
			mode : 'remote',
			valueField : 'userName',
			textField : 'userName',
			required : true,
			panelHeight : 'auto',
			delay : 500
		});
		userLoginCombogrid = $('#userLoginCombogrid').combogrid({
			url : '${pageContext.request.contextPath}/admin/loginCombogrid',
			panelWidth : 450,
			panelHeight : 200,
			idField : 'userName',
			textField : 'userName',
			pagination : true,
			fitColumns : true,
			required : true,
			rownumbers : true,
			mode : 'remote',
			delay : 500,
			sortName : 'userName',
			sortOrder : 'asc',
			pageSize : 5,
			pageList : [ 5, 10 ],
			columns : [ [ {
				title : '登录名',
				field : 'userName',
				width : 150,
				sortable : true
			}, {
				title : '创建时间',
				field : 'createTime',
				width : 150,
				sortable : true
			} ] ]
		});
		$('#loginDialog input').keyup(function(event) {
			if (event.keyCode == '13') {
				loginFun();
			}
		});
		userLoginCombobox.combobox('textbox').keyup(function(event) {
			if (event.keyCode == '13') {
				loginFun();
			}
		});
		userLoginCombogrid.combogrid('textbox').keyup(function(event) {
			if (event.keyCode == '13') {
				loginFun();
			}
		});
	});
	function loginFun() {
		loginTabs = $('#loginTabs').tabs('getSelected');//当前选中的tab
		var form = loginTabs.find('form');//选中的tab里面的form
		if (form.form('validate')) {
			parent.$.messager.progress({
				title : '提示',
				text : '数据处理中，请稍后....'
			});
			$.post('${pageContext.request.contextPath}/admin/login', form.serialize(), function(result) {
				if (result.success) {
					window.location.href='${pageContext.request.contextPath}/admin/index';
				} else {
					$.messager.alert('错误', result.msg, 'error');
				}
				parent.$.messager.progress('close');
			}, "JSON");
		}
	}
	
</script>
<style type="text/css">
table{margin:0 auto;}
tr{height:40px;}
input{height:20px;border:1px solid #95B8E7;}
</style>
</head>
<body>
<jsp:include page="register.jsp"></jsp:include>
<div id="loginDialog" title="用户登录" style="width: 330px; height: 220px; overflow: hidden; display: none;">
	<div id="loginTabs" class="easyui-tabs" data-options="fit:true,border:false">
		<div title="用户输入模式" style="overflow: hidden; padding: 10px;">
			<form method="post" id="loginForm">
				<table>
					<tr>
						<th>登录名</th>
						<td><input name="userName" type="text" placeholder="请输入登录名" class="easyui-validatebox" data-options="required:true" value="lys"></td>
					</tr>
					<tr>
						<th>密码</th>
						<td><input name="password" type="password" placeholder="请输入密码" class="easyui-validatebox" data-options="required:true" value="lys"></td>
					</tr>
				</table>
			</form>
		</div>
		<div title="自动补全模式" style="overflow: hidden; padding: 10px;">
			<form method="post">
				<table>
					<tr>
						<th>登录名</th>
						<td><input id="userLoginCombobox" name="userName" type="text" placeholder="请输入登录名" class="easyui-validatebox" data-options="required:true" value="lys"></td>
					</tr>
					<tr>
						<th>密码</th>
						<td><input name="password" type="password" placeholder="请输入密码" class="easyui-validatebox" data-options="required:true" value="lys"></td>
					</tr>
				</table>
			</form>
		</div>
		<div title="数据表格模式" style="overflow: hidden; padding: 10px;">
			<form method="post">
				<table>
					<tr>
						<th>登录名</th>
						<td><input id="userLoginCombogrid" name="userName" type="text" placeholder="请输入登录名" class="easyui-validatebox" data-options="required:true" value="lys"></td>
					</tr>
					<tr>
						<th>密码</th>
						<td><input name="password" type="password" placeholder="请输入密码" class="easyui-validatebox" data-options="required:true" value="lys"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>

</body>
</html>