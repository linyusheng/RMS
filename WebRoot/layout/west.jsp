<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" charset="utf-8">
	var tree;
	$(function(){
		tree = $('#tree').tree({
			url : '${pageContext.request.contextPath}/menu/loadMenus',
			onLoadSuccess:function(node, data){
				var t = $(this);
				if(data){
					$(data).each(function(index,dom){
						if(this.state == 'closed' ){
							t.tree('expandAll');
						}
					});
				}
			},
			onClick: function(node){
				if(node.attributes.pid == null){
					return;
				}
				addTab({
						url : node.attributes.url,
						title : node.text,
						iconCls : node.iconCls
				});
			},
			onDblClick : function(node){
				if(node.state == 'open'){
					tree.tree('collapse',node.target);
				}else{
					tree.tree('expand',node.target);
				}
			}
		});
	});
	function addTab(params) {
		var url;
		//如果url第一位字符是"/"，那么代表打开的是本地的资源
		if(params.url.indexOf('/') == 0){
			url = '${pageContext.request.contextPath}' + params.url;
		}else{//打开跨域资源
			url = params.url;
			window.open(url);
			return;
		}
		var content = '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:100%;"></iframe>';
		var t = $('#index_tab');
		var opts = {
			title : params.title,
			closable : true,
			iconCls : params.iconCls,
			content : content,
			border : false,
			fit : true
		};
		if (t.tabs('exists', opts.title)) {
			t.tabs('select', opts.title);
		} else {
			t.tabs('add', opts);
		}
		
	}
</script>
<ul id="tree"></ul>

