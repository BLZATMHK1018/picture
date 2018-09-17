package com.tane.webuploader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZhangFen
 * @date 2018年9月14日  下午7:04:06
 */
@Controller
public class MainController {
    
	/**
	 * 单例上传
	 * 选完文件后，是否自动上传
	 * @return
	 */
	@RequestMapping("singleUpload.do")
	public String singleUpload(){
		return "single_upload";
	}
	
	/**
	 * 单例回显
	 * 选完文件后，是否自动上传
	 * @return
	 */
	@RequestMapping("single_echo_upload.do")
	public String singleEchoUpload(){
		return "single_echo_upload";
	}
	
	/**
	 * 多例上传
	 * 选完文件后，是否自动上传
	 * @return
	 */
	@RequestMapping("moreUpload.do")
	public String moreUpload(){
		return "more_upload";
	}
	
	/**
	 * 多例回显
	 * 选完文件后，是否自动上传
	 * @return
	 */
	@RequestMapping("moreEchoUpload.do")
	public String moreEchoUpload(){
		return "more_echo_upload";
	}

	/**
	 * 选完文件后，点击时间触发上传
	 * @return
	 */
	@RequestMapping("morePicUpload.do")
	public String morePicUpload(){
		return "more_pics_upload";
	}
}
