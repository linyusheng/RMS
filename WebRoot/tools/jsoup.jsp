<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>Jsoup</title>
  	<jsp:include page="../include.jsp"></jsp:include>
  	<style>
	table{width:98%;margin:10px;border-collapse: collapse;white-space: nowrap;}
	table td,table th{padding:5px;}
	table th{width:80px;text-align: right;}
	table td{text-align:left;}
	input[type="text"]{border:1px solid #95B8E7;outline: none;width:60%;}
	textarea{border:1px solid #95B8E7;width:100%;}
	</style>
	<script type="text/javascript">
	$(function(){
		$('#url').click(function(){
			var url = $('input[name="url"]').val();
			
		});
	});
	</script>
  <body>
  	<form method="post">
  	<table cellpadding="5" cellspacing="0">
  		<tr>
  			<th>网址:</th>
  			<td><input class="easyui-validatebox" type="text" name="url" /></td>
  		</tr>
  		<tr>
  			<th>
  				<a href="#" id="url" class="easyui-linkbutton" data-options="iconCls:'icon-add'">获取</a>
  			</th>
  			<td><textarea rows="5" cols=""></textarea></td>
  		</tr>
  		<tr>
  			<th>Id:</th>
  			<td><input class="easyui-validatebox" type="text" name="id" /></td>
  		</tr>
  		<tr>
  			<th>
  				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">获取</a>
  			</th>
  			<td><textarea rows="5" cols=""></textarea></td>
  		</tr>
  		<tr>
  			<th>Class:</th>
  			<td><input class="easyui-validatebox" type="text" name="class" /></td>
  		</tr>
  		<tr>
  			<th>
  				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">获取</a>
  			</th>
  			<td><textarea rows="5" cols=""></textarea></td>
  		</tr>
  		<tr>
  			<th>标签:</th>
  			<td><input class="easyui-validatebox" type="text" name="label" /></td>
  		</tr>
  		<tr>
  			<th>
  				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">获取</a>
  			</th>
  			<td><textarea rows="5" cols=""></textarea></td>
  		</tr>
  	</table>     
	</form>  
  	
	
  </body>
</html>
