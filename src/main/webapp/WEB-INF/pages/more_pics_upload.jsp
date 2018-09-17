<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>点击事件触发上传</title>
    <script type="text/javascript" src="<%=basePath %>assets/plugins/jquery/jquery-1.8.3.min.js"></script>    
    <link rel="stylesheet" type="text/css" href="<%=basePath %>assets/plugins/webuploader/webuploader.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>assets/plugins/webuploader/css/upload.css" />
</head>
<body>
    <div id="wrapper">
        <div id="container">
            <!--头部，相册选择和格式选择-->

            <div id="uploader">
                <div class="queueList">
                    <div id="dndArea" class="placeholder">
                        <div id="filePicker"></div>
                        <p>或将照片拖到这里，单次最多可选300张</p>
                    </div>
                </div>
                <div class="statusBar" style="display:none;">
                    <div class="progress">
                        <span class="text">0%</span>
                        <span class="percentage"></span>
                    </div><div class="info"></div>
                    <div class="btns">
                        <div id="filePicker2"></div><div class="uploadBtn">开始上传</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="<%=basePath %>assets/plugins/webuploader/webuploader.js"></script>
    <script type="text/javascript" src="<%=basePath %>assets/plugins/webuploader/js/upload.js"></script>
</body>
</html>
