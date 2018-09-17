package com.tane.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * @author ZhangFen
 * @date 2018年9月13日  下午4:29:46
 */
public final class ThumbnailatorUtils {
	
	/**
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ThumbnailatorUtils.size("E:/test/图片.jpg",100,100);
        ThumbnailatorUtils.scale("E:/test/图片.jpg",0.25);
        ThumbnailatorUtils.rotate("E:/test/图片.jpg",(double) 90);
    }

    /**
     * 指定大小进行缩放
     * size(width,height) 若图片横比200小，高比300小，不变
     * 若图片横比200小，高比300大，高缩小到300，图片比例不变 若图片横比200大，高比300小，横缩小到200，图片比例不变
     * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
     * @throws IOException
     */
    static void size(String imgPath,int width, int height) throws IOException {
        Thumbnails.of(imgPath).size(width, height).toFile(FileUtils.getNewSizeFileName(imgPath,width, height));     
    }

    /**
     * 按照比例进行缩放
     * scale(比例)
     * @throws IOException
     */
     static void scale(String imgPath,Double scale) throws IOException {      
        Thumbnails.of(imgPath).scale(scale).toFile(FileUtils.getNewScaleFileName(imgPath,scale));       
    }

    /**
     * 不按照比例，指定大小进行缩放
     * keepAspectRatio(false) 默认是按照比例缩放的
     * @throws IOException
     
    private void keepAspectRatio() throws IOException {
       
        Thumbnails.of(imgPath).size(120, 120).keepAspectRatio(false).toFile("E:/test/Koala_120x120.jpg");
    }
    */
    
    /**
     * 旋转
     * rotate(角度),正数：顺时针 负数：逆时针
     * @throws IOException
     */
     static void rotate(String imgPath,Double rotate) throws IOException {
        Thumbnails.of(imgPath).rotate(rotate).toFile(FileUtils.getNewRotateFileName(imgPath,rotate));
    }
    
    /**
     * 转化图像格式
     * outputFormat(图像格式)
     * @throws IOException
     */
    private static void outputFormat(String imgPath,String outputFormat) throws IOException {
        Thumbnails.of(imgPath).outputFormat(outputFormat).toFile(FileUtils.getNewFormatFileName(imgPath,outputFormat));
    }

    /**
     * 水印
     *  watermark(位置，水印图，透明度)
     * @throws IOException
     */
    private static void watermark(String imgPath) throws IOException {       
        Thumbnails.of(imgPath).size(1280, 1024)
        .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(imgPath)), 0.5f)
                .outputQuality(0.8f).toFile("E:/test/Koala_watermark_bottom_right.jpg");
        Thumbnails.of(imgPath).size(1280, 1024).
        watermark(Positions.CENTER, ImageIO.read(new File(imgPath)), 0.5f)
                .outputQuality(0.8f).toFile("E:/test/Koala_watermark_center.jpg");
    }

    /**
     * 裁剪
     * 
     * @throws IOException
     */
    private static void cut(String imgPath) throws IOException {
        /**
         * 图片中心400*400的区域
         */
        Thumbnails.of(imgPath).sourceRegion(Positions.CENTER, 400, 400).size(200, 200).keepAspectRatio(false)
                .toFile("E:/test/Koala_region_center.jpg");
        /**
         * 图片右下400*400的区域
         */
        Thumbnails.of(imgPath).sourceRegion(Positions.BOTTOM_RIGHT, 400, 400).size(200, 200).keepAspectRatio(false)
                .toFile("E:/test/Koala_region_bootom_right.jpg");
        /**
         * 指定坐标
         */
        Thumbnails.of(imgPath).sourceRegion(600, 500, 400, 400).size(200, 200).keepAspectRatio(false).toFile("E:/test/Koala_region_coord.jpg");
    }

    /**
     * 输出到OutputStream
     * toOutputStream(流对象)
     * @throws IOException
     */
    private void toOutputStream(String imgPath) throws IOException {
        OutputStream os = new FileOutputStream("C:/image_1280x1024_OutputStream.png");
        Thumbnails.of("images/test.jpg").size(1280, 1024).toOutputStream(os);
    }

    /**
     * 输出到BufferedImage
     * asBufferedImage() 返回BufferedImage
     * @throws IOException
     */
    private void asBufferedImage(String imgPath) throws IOException {       
        BufferedImage thumbnail = Thumbnails.of(imgPath).asBufferedImage();
        ImageIO.write(thumbnail, "jpg", new File("E:/test/Koala_1280x1024_BufferedImage.jpg"));
    }
    
}

