<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>单例回显</title>
	<script type="text/javascript" src="<%=basePath %>assets/plugins/jquery/jquery-1.8.3.min.js"></script>
	<link href="<%=basePath %>assets/plugins/webuploader/webuploader.css" rel="stylesheet" />
	<link href="<%=basePath %>assets/plugins/webuploader/css/cxuploader.css" rel="stylesheet" />
	<link href="<%=basePath %>assets/css/common.css" rel="stylesheet" />

    <style type="text/css">
 
    </style>
  </head>

  <body>
      <div class="head">单例回显</div>		
	  <div class="content">			
			<ul>
				<li>
					<div class="uploder-container">										      		
                        <p>单例回显</p>
                        <div  class="cxuploder">
                        
                            <div class="queueList">
                                <div class="placeholder">
                                    <div class="filePicker"></div>
                                    <p>将照片拖到这里</p>
                                </div>
                            </div>
                            
                            <div class="statusBar" style="display:none;">                                                               
                                <div class="btns">
                                    <div  class="jxfilePicker"></div>	
                                </div>
                                <div class="info"></div>
                            </div>
                            
                        </div>
                    </div>

				</li>
			</ul>
	</div>
  </body>
  
    <script type="text/javascript" src="<%=basePath %>assets/plugins/webuploader/webuploader.js"></script>
    <script type="text/javascript" src="<%=basePath %>assets/plugins/webuploader/js/cxuploader2.js"></script>

</html>
