<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<jsp:include page="include.jsp"></jsp:include>
		<link href="${pageContext.request.contextPath}/js/jquery-easyui-portal/portal.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui-portal/jquery.portal.js"></script>
		<script type="text/javascript">
		$(function(){
			//创建一个门户
			$('#pp').portal({
				border:true,
				fit:true
			});
			//add();
		});
		function add(){
			$('#pp').portal('resize');
		}
		</script>
		<style type="text/css">
		.container{padding:10px;min-height: 150px;margin-bottom:5px;}
		</style>
	</head>
	<body>
		<div id="pp" style="position:relative;">
			<div style="width:50%;padding:5px;padding-right:0;">
				<div title="功能简介" class="container">
					<p>1.系统管理：用户管理、角色管理、权限管理、资源管理</p><br />
					<p>2.系统监控：项目监控、用户登录历史监控、Action映射监控、数据源监控</p><br />
					<p>3.系统报表：注册时间分布、用户角色分布</p><br />
					<p>4.示例网站：EasyUI官方Demo、EasyUI官方API、EasyUI官方下载、EasyUI官方论坛</p>
				</div>
				<div title="功能浏览" class="container">
				
				</div>
			</div>
			<div style="width:50%;padding:5px;">
				<div title="相关技术" class="container">
					<p>1.技术构架：jQuery EasyUI 1.3.4 + Spring MVC 3.0 + Hibernate 3.0</p><br />
					<p>2.开发工具：MyEclipse 2014</p><br />
					<p>3.Web服务器：tomcat 7.x</p><br />
					<p>4.数据库环境：mysql 5.x</p>
				</div>
				<div title="版本介绍" class="container">
					<p>V1.0</p>
					<p></p>
				</div>
			</div>
		</div>
	</body>
</html>
