<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-easyui-1.5.5.2/jquery.min.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-easyui-1.5.5.2/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-easyui-1.5.5.2/locale/easyui-lang-zh_CN.js"></script>  
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui-1.5.5.2/themes/default/easyui.css"/>  
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui-1.5.5.2/themes/icon.css"/>   
</head>
<body>
<table id="dg"></table>  

<script type="text/javascript">
$(function(){
	$('#dg').datagrid({    
	    url:'${pageContext.request.contextPath }/dataGridData',
	    columns:[[  
	        {field:'ck',checkbox:true},
	        {field:'id',title:'ID',width:100},    
	        {field:'username',title:'用户名',width:100},    
	        {field:'password',title:'密码',width:100,align:'right'}    
	    ]],
	    idField:'id',
	    pagination:true,
	    rownumbers:true,
	    checkOnSelect: true,
		selectOnCheck: true,
	    checkbox:true,
	    loadFilter:function(data){
	    	debugger
	    	if($.isArray(data)){
	    		data = {total:500,rows:data}
	    	}
	    	return data;
	    }
	}); 
}) 
</script>
</body>
</html>