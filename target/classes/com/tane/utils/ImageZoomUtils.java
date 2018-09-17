package com.tane.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageZoomUtils {
    private static final int WIDTH = 100; // 缩略图宽度
    private static final int HEIGHT = 100;// 缩略图高度

    public static BufferedImage zoom(String srcFileName) {
        // 使用源图像文件名创建ImageIcon对象。
        ImageIcon imgIcon = new ImageIcon(srcFileName);
        // 得到Image对象。
        Image img = imgIcon.getImage();
        return zoom(img);
    }

    public static BufferedImage zoom(Image srcImage) {
        // 构造一个预定义的图像类型的BufferedImage对象。
        BufferedImage buffImg = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        // buffImg.flush();
        // 创建Graphics2D对象，用于在BufferedImage对象上绘图。
        Graphics2D g = buffImg.createGraphics();
        // 设置图形上下文的当前颜色为白色。
        g.setColor(Color.WHITE);
        // 用图形上下文的当前颜色填充指定的矩形区域。
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // 按照缩放的大小在BufferedImage对象上绘制原始图像。
        g.drawImage(srcImage, 0, 0, WIDTH, HEIGHT, null);
        // 释放图形上下文使用的系统资源。
        g.dispose();
        // 刷新此 Image 对象正在使用的所有可重构的资源.
        srcImage.flush();
        return buffImg;
    }

    public static void main(String[] args) {
        BufferedImage img = ImageZoomUtils.zoom("D:\\data\\doc\\site\\album\\system_21\\article\\dir1\\article_1\\pic_180801153627_00591.png");
        try {
            ImageIO.write(img, "png", new File("D:\\data\\doc\\site\\album\\system_21\\article\\dir1\\article_1\\pic_180801153627_00591.png_100x100.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
