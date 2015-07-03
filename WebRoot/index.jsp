<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>权限管理系统</title>
<jsp:include page="include.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	var index_layout;
	var index_tab;
	$(function(){
		index_layout = $('#index_layout').layout({
			fit : true
		});
		$.messager.show( {
			title : '欢迎',
			msg : '<center style="line-height:40px;">欢迎使用jQuery EasyUI演示系统！</center>',
			timeout : 4000,
			showType : 'slide',
		});
		index_tab = $("#index_tab").tabs({
			fit : true,
			border : false
		});
	});
</script>
</head>
<body>
	<div id="index_layout">
		<div data-options="region:'north',href:'${pageContext.request.contextPath}/layout/north.jsp'" style="height:50px;overflow:hidden;"></div>
	    <div data-options="region:'west' ,href:'${pageContext.request.contextPath}/layout/west.jsp',split:true,title:'导航栏'" style="width:200px;padding:7px;"></div>
	    <div data-options="region:'south',href:'${pageContext.request.contextPath}/layout/south.jsp',border:false" style="height: 30px; overflow: hidden;"></div>
	    <div data-options="region:'center'" style="overflow:hidden;background:#eee;">
	    	<div id="index_tab">
				<div title="首页" data-options="border:false" style="overflow:hidden;">
					<iframe src="${pageContext.request.contextPath}/welcome.jsp" frameborder="0" style="border:0;width:100%;height:100%;"></iframe>
				</div>
			</div>
	    </div>
    </div>
</body>
</html>