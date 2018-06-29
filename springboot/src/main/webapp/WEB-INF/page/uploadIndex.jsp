<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/webuploader/webuploader.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-theme.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/webuploader/webuploader.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script>
</head>
<body>
	直接使用commons-fileupload工具包接收：<br>
	<form action="${pageContext.request.contextPath }/upload/file" method="post" enctype="multipart/form-data">
		<input type="file" name="file"> 
		<input type="submit" value="上传" />
	</form>
	<hr>
	上传单个文件<br>
	<form action="${pageContext.request.contextPath }/upload/singleFile" method="post" enctype="multipart/form-data">
		<input type="file" name="file"> 
		<input type="submit" value="上传" />
	</form>
	<hr>
	上传多个文件<br>
	<form action="${pageContext.request.contextPath }/upload/multiFile" method="post" enctype="multipart/form-data">
		<input type="file" name="file"> 
		<input type="file" name="file"> 
		<input type="file" name="file"> 
		<input type="submit" value="上传" />
	</form>
	<hr>
	分片、断点上传文件<br>
	<div id="uploader" class="wu-example">
	    <!--用来存放文件信息-->
	    <div id="thelist" class="uploader-list"></div>
	    <div class="btns">
	        <div id="picker">选择文件</div>
	        <button id="ctlBtn" class="btn btn-default">开始上传</button>
	    </div>
	</div>
	<hr/>
	上传图片<br>
	<div id="uploader-demo">
	    <!--用来存放item-->
	    <div id="fileList" class="uploader-list"></div>
	    <div id="filePicker">选择图片</div>
	</div>
<script type="text/javascript">
	var basePath = "${pageContext.request.contextPath }";
</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/uploadIndex.js"></script>
</body>
</html>