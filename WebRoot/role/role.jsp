<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title></title>
    <jsp:include page="../include.jsp"></jsp:include>
    <script type="text/javascript" charset="utf-8">
	var datagrid;
	var editRow = undefined;
	var menu;
	$(function() {
		//创建数据表格
		datagrid = $("#datagrid").datagrid({
			url : '${pageContext.request.contextPath}/role/datagrid',
			title : '',
			iconCls : 'icon-save',
			pagination : true,
			pageSize : 10,
			pageList : [ 10, 20, 30, 40 ],
			fit : true,
			fitColumns : true,
			nowarp : false,
			border : false,
			scrollbarSize : 0,
			idField : 'roleId',
			sortName : 'createTime',//定义哪些列可以进行排序
			sortOrder : 'desc',		//定义列的排序顺序，只能是'asc'或'desc'
			columns : [ [ {
				title : '编号',
				field : 'roleId',
				width : 100,
				sortable : true,
				checkbox : true
			}, {
				title : '角色名称',
				field : 'name',
				sortable : true,
				width : 100,
				editor : {
					type : 'validatebox',
					options : {
						required : true
					}
				},
				formatter: function(value,rowData,rowIndex){
					return '<span title="'+value+'">'+value+'</span>';
				}
			}, {
				title : '描述',
				field : 'description',
				sortable : true,
				width : 100,
				editor : {
					type : 'validatebox',
					options : {
						required : true
					}
				}
			}, {
				title : '创建时间',
				field : 'createTime',
				sortable : true,
				width : 100,
				editor : {
					type : 'datetimebox',
					options : {
						required : true
					}
				}
			} ] ],
			toolbar : [
					{
						text : '增加',
						iconCls : 'icon-add',
						handler : function() {
							if (editRow != undefined) {
								datagrid.datagrid('endEdit', editRow);
							}
							if (editRow == undefined) {
								//可以行编辑
								datagrid.datagrid('addEditor',{
									field:'name',
									editor:{
										type : 'validatebox',
										options : {
											required : true
										}
									}
								});
								//插入一行数据
								datagrid.datagrid('insertRow', {
									index : 0,
									row : {
										//userId : Math.uuid()
									}
								});
								//让创建时间无法编辑								
								datagrid.datagrid('removeEditor','createTime');
								datagrid.datagrid('beginEdit', 0);
								editRow = 0;
							}
						}
					},
					'-',
					{
						text : '删除',
						iconCls : 'icon-remove',
						handler : function() {
							var rows = datagrid.datagrid('getSelections');
							if(rows.length > 0){
								$.messager.confirm('请确认','您确定要删除当前所有选择的项目么？',function(b){
									if(b){
										var ids = [];
										for(var i = 0;i<rows.length;i++){
											ids.push(rows[i].roleId);
										}
										$.post('${pageContext.request.contextPath}/role/delete',{"ids":ids.toString()} , function(result) {
											//若后台删除角色成功，则清除选中的行
											datagrid.datagrid('clearSelections');
											datagrid.datagrid('load');
										}, "JSON");
									}
								});
							}else{
								$.messager.alert('提示','请选择要删除的记录！','error');
							}
						}
					},
					'-',
					{
						text : '修改',
						iconCls : 'icon-edit',
						handler : function() {
							var rows = datagrid.datagrid('getSelections');
							if (rows.length == 1) {
								//让创建时间无法编辑								
								datagrid.datagrid('removeEditor','createTime');
								if (editRow != undefined) {
									datagrid.datagrid('endEdit',editRow);
								}
								if (editRow == undefined) {
									var index = datagrid.datagrid('getRowIndex', rows[0]);
									datagrid.datagrid('beginEdit',index);
									editRow = index;
									datagrid.datagrid('unselectAll');
								}
							}
						}
					}, '-', {
						text : '保存',
						iconCls : 'icon-save',
						handler : function() {
							datagrid.datagrid('endEdit', editRow);
						}
					}, '-', {
						text : '取消编辑',
						iconCls : 'icon-redo',
						handler : function() {
							editRow = undefined;
							datagrid.datagrid('rejectChanges');
							datagrid.datagrid('unselectAll');
						}
					} ],
			onAfterEdit : function(rowIndex, rowData, changes) {
				editRow = undefined;
				parent.$.messager.progress({
					text : '数据加载中....'
				});
				//添加或修改角色的请求
				$.post('${pageContext.request.contextPath}/role/addOrUpdate',rowData , function(result) {
					parent.$.messager.progress('close');
					datagrid.datagrid('load');
					editRow = undefined;
					$.messager.alert('提示',result.msg,'info');
				}, "JSON");
			},
			onDblClickRow : function(rowIndex, rowData) {
				if (editRow != undefined) {
					datagrid.datagrid('endEdit', editRow);
				}
				if (editRow == undefined) {
					datagrid.datagrid('beginEdit', rowIndex);
					editRow = rowIndex;
				}
			},
			onRowContextMenu:function(e, rowIndex, rowData){
				e.preventDefault();
				$(this).datagrid('unselectAll');
				$(this).datagrid('selectRow',rowIndex);
				$('#menu').menu('show', {    
					left: e.pageX,
					top: e.pageY
				});
			},
			onBeforeLoad : function(param) {
				parent.$.messager.progress({
					text : '数据加载中....'
				});
			},
			onLoadSuccess : function(data) {
				parent.$.messager.progress('close');
			}
		});
		//右键菜单
		menu = $('#menu').menu({
			onClick:function(item){    
		    	switch(item.name){
		    		case 'add':add();break;
		    		case 'edit':edit();break;
		    		case 'remove':remove();break;
		    		case 'redo':redo();break;
		    	};
		    	console.info(item);
		    }  
		});
	});
	</script>
  </head>
  <body>
  	<table id="datagrid"></table>
  	
  	<div id="menu" class="easyui-menu" style="width:120px;">   
	    <div data-options="iconCls:'icon-add',name:'add'">添加角色</div>   
	    <div data-options="iconCls:'icon-edit',name:'edit'">修改角色</div>
	    <div data-options="iconCls:'icon-remove',name:'remove'">删除角色</div>   
	    <div data-options="iconCls:'icon-redo',name:'redo'">取消编辑</div>   
	</div>
  </body>
</html>
