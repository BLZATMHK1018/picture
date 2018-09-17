java web 

(1)图片上传 

采用webuploader插件实现单例、多例上传图片，图片回显等。 

(2)图片压缩 

采用thumbnailator插件压缩图片。

(3)效果图如下

![Image ](https://raw.githubusercontent.com/ZhangFen1018/picture/master/github_images/%E5%8D%95%E4%BE%8B%E4%B8%8A%E4%BC%A0.png) 

![Image ](https://raw.githubusercontent.com/ZhangFen1018/picture/master/github_images/%E5%8D%95%E4%BE%8B%E5%9B%9E%E6%98%BE.png) 

![Image](https://raw.githubusercontent.com/ZhangFen1018/picture/master/github_images/%E5%A4%9A%E4%BE%8B%E4%B8%8A%E4%BC%A0.png)

![Image ](https://raw.githubusercontent.com/ZhangFen1018/picture/master/github_images/%E5%A4%9A%E4%BE%8B%E5%9B%9E%E6%98%BE.png) 

![Image](https://raw.githubusercontent.com/ZhangFen1018/picture/master/github_images/%E7%82%B9%E5%87%BB%E4%BA%8B%E4%BB%B6%E8%A7%A6%E5%8F%91%E4%B8%8A%E4%BC%A0.png) 

(4)运行配置

a.修改数据库文件

b.在数据库中，执行sql文件中的biz_file.sql的脚本

c.才用Nginx映射，使图片正常显示，Nginx配置如下：

#add by zf 2018-09-14 webuploader(图片上传webuploader插件)

location /picture{

proxy_pass http://localhost:8089/picture;

proxy_set_header Host $host;

proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for; 

}

#add by zf 2018-09-14(webuploader-磁盘路径代理映射) 

location /upload/{

root D:/;

} 

d.访问url：http://localhost/picture/

