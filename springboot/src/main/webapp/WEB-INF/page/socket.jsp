<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jquery-easyui-1.5.5.2/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jquery-easyui-1.5.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jquery-easyui-1.5.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/jquery-easyui-1.5.5.2/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/jquery-easyui-1.5.5.2/themes/icon.css" />
<style type="text/css">
.btn {
	width: 154px;
	height: 30px;
	background-color: #eee;
}
</style>
</head>
<body>
	<div style="width: 500px; height: 500px;">
			<div style="width: 100%; text-align: center;">
				服务器地址：<input id="socketAddr" style="width: 222px;">
			</div>
			<div
				style="width: 225px; height: 300px; margin-top: 20px; float: left; margin-left: 20px; display: inline-block;">
				<span>客户端：</span>
				<textarea id="client" style="width: 94%; height: 100%;"></textarea>
				<input id="connect" type="button" style="width: 68px; height: 30px;" value="连接">
				<input id="send" type="button" style="width: 68px; height: 30px;" value="发送">
			</div>
			<div
				style="width: 200px; height: 300px; float: right; margin-top: 20px; display: inline-block; margin-right: 20px;">
				<span>服务器端：</span>
				<textarea id="server" readonly="readonly"
					style="width: 100%; height: 100%;"></textarea>
			</div>
	</div>

	<script type="text/javascript">
	var ws;
	function connect() {
		var target = $("#socketAddr").val();
		if(!target){
			alert('需要填写服务器链接')
		}
		target = target.replace(/^(https:|http:)/,'');
		if (window.location.protocol == 'http:') {
			target = 'ws:' + target;
	    } else {
	        target = 'wss:' + target;
	    }
	    if ('WebSocket' in window) {
	        ws = new WebSocket(target);
	    } else if ('MozWebSocket' in window) {
	        ws = new MozWebSocket(target);
	    } else {
	        alert('当前浏览器不支持websocket');
	        return;
	    }
	    //
	    ws.onopen = function () {
	    	console.log("连接打开");
	    	$("#connect").val('连接成功');
	    	$("#connect").attr('disabled','disabled');
	    };
	    ws.onclose = function () {
	        console.log('连接关闭');
	        $("#connect").val('连接');
	    	$("#connect").removeAttr('disabled');
	    };
	    //接收到消息后更新显示内容
	    ws.onmessage = function (event) {
	    	if(event && event.data){
	    		var da = new Date();
	    		var dateStr = da.getFullYear()+"-"+(da.getMonth()+1)+"-"+da.getDate()+" "+da.getHours()+":"+da.getMinutes()+":"+da.getSeconds();
	    		$("#server").val($("#server").val()+'\r\n'+dateStr+' : '+event.data);
	    	}
	    };
	}
	$(function(){
		$("#connect").click(function(){
			connect();
		})
		$("#send").click(function(){
			if(ws){
				ws.send($("#client").val())
				$("#client").val('')
			}else{
				alert('链接尚未建立！！！')	
			}
		})
	})
</script>

</body>
</html>