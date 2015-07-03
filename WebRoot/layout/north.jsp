<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	//注销退出
	function logout() {
		window.location.href='${pageContext.request.contextPath}/admin/logout';
	}
	//修改密码
	function editPassword() {
		$('#editPwdDialog').dialog({
			title:'修改密码',
			width:330,
			height:220,
			href:'${pageContext.request.contextPath}/user/userEditPwd.jsp',
			modal:true,
			buttons:[{
				text:'修改',
				handler:function(){
					$('#editPwdForm').submit();
				}
			},{
				text:'取消',
				handler:function(){
					$('#editPwdDialog').dialog('close');
				}
			}]
		});
	}
	//个人信息
	function showMyInfo(){
		$('#myInfoDialog').dialog({
			title:'我的信息',
			width:500,
			height:400,
			href:'${pageContext.request.contextPath}/user/userInfo?id=${sessionInfo.userId}',
			modal:true
		});
	}
	//锁定窗口
	function lockWindow(){
		$.post('${pageContext.request.contextPath}/admin/lock', null, function(result) {
			if(result){
				$('#lockDialog').dialog({
					title:'解锁登录',
					width:300,
					height:180,
					href:'${pageContext.request.contextPath}/admin/lock.jsp',
					modal:true,
					closable:false,
					buttons:[{
						text:'解锁',
						handler:function(){
							$('#lockForm').submit();
						}
					}]
				});
			}else{
				window.location.href='${pageContext.request.contextPath}/admin/login.jsp';
			}
		}, "JSON");
	}
</script>
<img src="${pageContext.request.contextPath}/images/logo.png" width="350" height="50" alt="权限管理系统"/>
<div style="position: absolute; right: 0px; top: 0px;">
	<c:if test="${sessionInfo.userId != null}">
		<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_kzmbMenu'" id="sessionInfoDiv">
			<strong>${sessionInfo.userName}</strong>，欢迎你！
		</a>
	</c:if>
	<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'ext-icon-rainbow'">更换皮肤</a> 
	<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_zxMenu',iconCls:'ext-icon-disconnect'">注销</a>
</div>
<div id="layout_north_pfMenu" style="width: 120px; display: none;">
	<div onclick="changeTheme('default');" title="default">default</div>
	<div onclick="changeTheme('gray');" title="gray">gray</div>
	<div onclick="changeTheme('metro');" title="metro">metro</div>
	<div onclick="changeTheme('bootstrap');" title="bootstrap">bootstrap</div>
	<div onclick="changeTheme('black');" title="black">black</div>
	<div class="menu-sep"></div>
	<div onclick="changeTheme('metro-blue');" title="metro-blue">metro-blue</div>
	<div onclick="changeTheme('metro-gray');" title="metro-gray">metro-gray</div>
	<div onclick="changeTheme('metro-green');" title="metro-green">metro-green</div>
	<div onclick="changeTheme('metro-orange');" title="metro-orange">metro-orange</div>
	<div onclick="changeTheme('metro-red');" title="metro-red">metro-red</div>
</div>
<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
	<div data-options="iconCls:'ext-icon-user_edit'" onclick="editPassword();">修改密码</div>
	<div class="menu-sep"></div>
	<div data-options="iconCls:'ext-icon-user'" onclick="showMyInfo();">我的信息</div>
</div>
<div id="layout_north_zxMenu" style="width: 100px; display: none;">
	<div data-options="iconCls:'ext-icon-lock'" onclick="lockWindow();">锁定窗口</div>
	<div class="menu-sep"></div>
	<div data-options="iconCls:'ext-icon-door_out'" onclick="logout();">退出系统</div>
</div>

<div id="editPwdDialog"></div>
<div id="myInfoDialog"></div>
<div id="lockDialog"></div>