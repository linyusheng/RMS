<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
  <title></title>
  <jsp:include page="include.jsp"></jsp:include>
  <script type="text/javascript">
	$(function(){
		var treegrid;
	  	treegrid = $('#treegrid').treegrid({
		    url:'data.json',
		    idField:'id',
		    treeField:'name',
		    columns:[[
		        {field:'name',title:'Task Name',width:180},
		        {field:'persons',title:'Persons',width:60,align:'right'},
		        {field:'begin',title:'Begin Date',width:80},
		        {field:'end',title:'End Date',width:80}
		    ]],
		    onLoadSuccess:function(row,data){
		    	console.info(data);
		    }
		});
  
	});
  </script>
</head>

<body>
<table id="treegrid" style="width:600px;"></table>
</body>
</html>
