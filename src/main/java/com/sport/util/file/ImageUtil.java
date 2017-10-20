package com.sport.util.file;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author huangxl
 * @date 2017-10-18 22:25
 */
public class ImageUtil {

    public static void main(String[] args) {

       // String[] imgs = ImageIO.getReaderFileSuffixes();
        for (String name : ImageIO.getReaderFileSuffixes()) {
            System.out.println(name);
        }
        System.out.println("----------");
        for (String name : ImageIO.getReaderFormatNames()) {
            System.out.println(name);
        }
        System.out.println("----------");
        for (String name : ImageIO.getWriterFileSuffixes()) {
            System.out.println(name);
        }

        try {
            BufferedImage bi = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\test.png"));
            BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_BGR);
            img.getGraphics().drawImage(bi, 0, 0, 16, 16, Color.white, null);

            ImageIO.write(img, "png", new File("s.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
