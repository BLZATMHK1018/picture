package com.tane.webuploader.controller;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tane.utils.FileUtils;
import com.tane.webuploader.entity.BizFile;
import com.tane.webuploader.service.BizFileService;

@Controller
public class BizFileController {
	
	@Autowired
	private BizFileService bizFileService;
	
    @Value("${img.path}")
    private String imgPath;
	
	//private JSONArray jsonArray;

	/**
	 * 图片上传
	 * @param id
	 * @param name
	 * @param flog
	 * @param autoId
	 * @param size
	 * @param type
	 * @param file
	 * @param request
	 */
	@RequestMapping(value = "fileUpload.do",method = RequestMethod.POST)
	@ResponseBody
	public String fileUpload(String id,String name,String size,String type, 
			@RequestParam("file")MultipartFile file,HttpServletRequest request){
		
		try {
			/*
			String path = request.getContextPath();   // 应用的web目录的名称
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
			String remoteAddress=request.getRemoteAddr();  
			String servletPath=request.getServletPath();  //当前页面所在目录下全名称
			String realPath=request.getRealPath("/");  
			String remoteUser=request.getRemoteUser();  
			String requestURI=request.getRequestURI();  //包含工程名的当前页面全路径
			String projectDir = request.getSession().getServletContext().getRealPath("/");//工程目录
			System.out.println("path...:"+path);  
			System.out.println("basePath...:"+basePath);  
			System.out.println("remoteAddr...:"+remoteAddress);  
			System.out.println("servletPath...:"+servletPath);  
			System.out.println("realPath...:"+realPath);  
			System.out.println("remoteUser...:"+remoteUser);  
			System.out.println("工程目录projectDir...:"+projectDir);  
			*/
					
			System.out.println(id + "   " + name + "  " + size  + "  "+ type);
			//设置根目录
			//String filePathGen = request.getSession().getServletContext().getRealPath("/") + "upload/photoPhoto/" + "images";
			String filePathGen = imgPath;
			//进行上传并返回图片的绝对路径
			String ensourPath =  FileUtils.getEnourPath(request,file,filePathGen);		
			//解析ensourPath
			String[] split = ensourPath.split("upload");
			String url = "/upload" + split[1].substring(0, split[1].length());
			//数据封装
			BizFile bizFile = new BizFile();
			bizFile.setSize(size);
			bizFile.setName(name);
			bizFile.setUrl(url);
			bizFile.setType(type);
			bizFile.setId(id);
			bizFile.setCreateTime(new Date());
			bizFileService.save(bizFile);
			return name;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 回显获取文件：
	 * 这里在mapper里默认取前4张（只是为了做回显效果，具体业务大家可以自己定义自己的逻辑）
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getFiles.do")
	public List<BizFile> getFiles(HttpServletResponse resp){
		try {
			List<BizFile> list =bizFileService.queryList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
}
