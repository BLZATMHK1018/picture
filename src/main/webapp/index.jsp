<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>webuploaderDemo</title>
	<link href="<%=basePath %>assets/css/common.css" rel="stylesheet" />
<style>
.juzhong {
	text-align: center;
}
</style>

</head>

  <body>
      <div class="middle">
   		<div class="head">初始化</div>
  		<div class="juzhong" >
          <ul>
              <p><a href="<%=basePath %>singleUpload.do">单例上传</a></p>
	          <p><a href="<%=basePath %>single_echo_upload.do">单例回显</a></p>
	          <p><a href="<%=basePath %>moreUpload.do">多例上传</a></p>
	          <p><a href="<%=basePath %>moreEchoUpload.do">多例回显</a></p>
	          <p><a href="<%=basePath %>morePicUpload.do">点击上传触发</a></p>
          </ul>
          
   		</div>
  </div>	
  </body>
</html>

