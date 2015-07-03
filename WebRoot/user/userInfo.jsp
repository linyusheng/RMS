<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.userInfo{margin:10px;border-collapse: collapse;white-space: nowrap;}
.userInfo td,.userInfo th{border:1px solid #95B8E7;padding:5px;}
.userInfo th{text-align: right;background-color: #F8F8F8;width:100px;}
.userInfo td{text-align:left;width:200px;}
</style>
<table class="userInfo" cellpadding="5" cellspacing="0">
	<tr>
		<th>用户ID</th>
		<td>${user.userId}</td>
		<th>登录名</th>
		<td>${user.userName}</td>
	</tr>
	<tr>
		<th>姓名</th>
		<td>${user.name}</td>
		<th>性别</th>
		<td>${user.sex}</td>
	</tr>
	<tr>
		<th>手机号码</th>
		<td>${user.mobile}</td>
		<th>邮箱</th>
		<td>${user.email}</td>
	</tr>
	<tr>
		<th>创建时间</th>
		<td>${user.createTime}</td>
		<th>本次登录时间</th>
		<td>${user.loginTime}</td>
	</tr>
	<tr>
		<th>上次登录时间</th>
		<td>${user.lastLoginTime}</td>
		<th>登录次数</th>
		<td>${user.loginCount}</td>
	</tr>
</table>
