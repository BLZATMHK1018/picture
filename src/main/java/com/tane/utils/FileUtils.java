package com.tane.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.NumberFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author ZhangFen
 * @date 2018年9月11日  上午11:45:19
 */
public final class FileUtils {

	// 允许上传图片的格式
    private static final String[] IMAGE_TYPE = { ".jpg", ".jpge", ".bmp", ".png", "gif" };
    
    
    /**
     * 图片写入磁盘，返回图片的绝对路径
     * @param request
     * @param file
     * @param filePathGen
     * @return
     */
	public static String getEnourPath(HttpServletRequest request, MultipartFile file,String filePathGen) {
		 	Boolean flag = false;
		 	System.out.println("原文件名： "+file.getOriginalFilename());
	        //校验图片格式
	        for (String type : IMAGE_TYPE) {
	            if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), type)) {
	                flag = true;
	                break;
	            }
	        }
	        //如果图片校验错误，直接返回。
	        if (!flag) {
	            return "";
	        }
	      //生成图片的绝对路径
	        String filePath = getFilePath(request,file.getOriginalFilename(),filePathGen);

	        //创建File对象
	        File newfile = new File(filePath);

	        //把图片写入到磁盘中
	        try {	        	
	        	file.transferTo(newfile);
		        ThumbnailatorUtils.size( filePath,100,100);  //压缩文件 100 X 100
			} catch (Exception e1) {
				e1.printStackTrace();
			}	     	        
	        
		return filePath;
	}
	
	/**
	 * 生成图片的绝对路径
	 * @param request
	 * @param originalFilename
	 * @param filePath
	 * @return
	 */
	public static String getFilePath(HttpServletRequest request,String originalFilename,String filePath) {
		new  DateUtils();
		String fileFolder = filePath + File.separator + DateUtils.getYear(new Date())
                + File.separator +  DateUtils.getMonth(new Date()) + File.separator
                + DateUtils.getDay(new Date());
		File file = new File(fileFolder);
        //如果文件目录不存在，则进行创建
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        //生成图片的文件名
        String fileName = DateUtils._toDateString(new Date())
                + RandomUtils.nextInt(9999) + "."
                + StringUtils.substringAfterLast(originalFilename, ".");
        //拼接图片的路径
        return fileFolder + File.separator + fileName;
	}
	
	public static void name(File file,String fileAbsolutePath) {
		FileInputStream fis;
		BufferedImage bufferedImg = null;
		try {
			fis = new FileInputStream(file);
	        bufferedImg = ImageIO.read(fis);
	        int imgWidth = bufferedImg.getWidth();
	        int imgHeight = bufferedImg.getHeight();
	        BufferedImage img = ImageZoomUtils.zoom(bufferedImg);
	        String fileExtension = FileUtils.getFileExtension(fileAbsolutePath);	        
	        ImageIO.write(img, fileExtension, new File(fileAbsolutePath+"_imgWidthx100."+fileExtension));
		} catch (Exception e) {
			e.printStackTrace();
		}
       
	}
	

	/**
	 * 获取文件扩展名(返回小写)
	 * @param fileName 文件名
	 * @return 例如：test.jpg  返回：  jpg
	 */
	public static String getFileExtension(String fileName) {
		if ((fileName == null) || (fileName.lastIndexOf(".") == -1) || (fileName.lastIndexOf(".") == fileName.length() - 1)) {
			return null;
		}
		return StringUtils.lowerCase(fileName.substring(fileName.lastIndexOf(".") + 1));
	}
	
	/**
	 * 获取不包含后缀的文件名
	 * @param fileName 文件名
	 * @return 例如：test.jpg  返回：  test
	 */
	public static String getFileNameExcludeSuffix(String fileName) {
		if ((fileName == null) || (fileName.lastIndexOf(".") == -1) || (fileName.lastIndexOf(".") == fileName.length() - 1)) {
			return null;
		}
        String suffix = fileName.substring(fileName.lastIndexOf(".")); //如果想获得不带点的后缀，变为fileName.lastIndexOf(".")+1       
        int num = suffix.length();//得到后缀名长度      
		return  fileName.substring(0, fileName.length()-num);
	}
	
	/**
	 * 根据大小重命名文件
	 * eg:原文件： Koala.jpg
	 * 新文件:Koala_thumbnail_120x120.jpg
	 * @param imgPath
	 * @param width
	 * @param height
	 * @return
	 */
	public static String getNewSizeFileName(String imgPath,int width,int height){
		 String imgPathExcludeSuffix = FileUtils.getFileNameExcludeSuffix(imgPath);
		 String suffix = FileUtils.getFileExtension(imgPath);
		 StringBuffer buffer=new StringBuffer();
	     buffer.append(imgPathExcludeSuffix);
	     buffer.append("_thumbnail_");
	     buffer.append(width);
	     buffer.append("X");
	     buffer.append(height);
	     buffer.append(".");
	     buffer.append(suffix);
	     return buffer.toString();
	}

	/**
	 * 根据比例重命名文件
	 * eg:原文件： Koala.jpg
	 * 新文件:Koala_thumbnail_25%.jpg
	 * @param imgPath
	 * @param scale
	 * @return
	 */
	public static String getNewScaleFileName(String imgPath, Double scale) {
		 String imgPathExcludeSuffix = FileUtils.getFileNameExcludeSuffix(imgPath);
		 String suffix = FileUtils.getFileExtension(imgPath);
		 NumberFormat num = NumberFormat.getPercentInstance(); 
		 String rates = num.format(scale);
		 StringBuffer buffer=new StringBuffer();
	     buffer.append(imgPathExcludeSuffix);
	     buffer.append("_thumbnail_");
	     buffer.append(rates);
	     buffer.append("%");
	     buffer.append(".");
	     buffer.append(suffix);
	     return buffer.toString();
		
	}

	/**
	 * 根据旋转角度重命名文件
	 * eg:原文件： Koala.jpg
	 * 新文件:Koala_thumbnail_+90.jpg
	 * @param imgPath
	 * @param rotate
	 * @return
	 */
	public static String getNewRotateFileName(String imgPath, Double rotate) {
		 String imgPathExcludeSuffix = FileUtils.getFileNameExcludeSuffix(imgPath);
		 String suffix = FileUtils.getFileExtension(imgPath);
		 StringBuffer buffer=new StringBuffer();
	     buffer.append(imgPathExcludeSuffix);
	     buffer.append("_thumbnail_");
	     buffer.append(rotate);
	     buffer.append(".");
	     buffer.append(suffix);
	     return buffer.toString();
		
		
	}

	/**
	 * 转化图像格式重命名
	 * eg:原文件： Koala.jpg
	 * 新文件:Koala_thumbnail_25%.jpg
	 * @param imgPath
	 * @param outputFormat
	 * @return
	 */
	public static String getNewFormatFileName(String imgPath, String outputFormat) {
		 String imgPathExcludeSuffix = FileUtils.getFileNameExcludeSuffix(imgPath);
		 //String suffix = FileUtils.getFileExtension(imgPath);
		 StringBuffer buffer=new StringBuffer();
	     buffer.append(imgPathExcludeSuffix);
	     buffer.append("_outputFormat_");
	     buffer.append(".");
	     buffer.append(outputFormat);
	     return buffer.toString();				
	}
	
}

