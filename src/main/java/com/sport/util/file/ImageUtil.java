package com.sport.util.file;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

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
        /*System.out.println("----------");
        for (String name : ImageIO.getReaderFormatNames()) {
            System.out.println(name);
        }*/
        System.out.println("----------");
        for (String name : ImageIO.getWriterFileSuffixes()) {
            System.out.println(name);
        }

        try {
//            BufferedImage bi = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\test.png"));
//            System.out.println(bi.getWidth()+"---"+bi.getHeight());

            File file = new File("C:\\Users\\Administrator\\Desktop\\image_2.jpg");
            BufferedImage bufferedImage = null;
            bufferedImage = ImageIO.read(file);
//            if (auto) {
//                ArrayList<Integer> paramsArrayList = getAutoWidthAndHeight(bufferedImage,width,height);
//                width = paramsArrayList.get(0);
//                height = paramsArrayList.get(1);
//                System.out.println("自动调整比例，width="+width+" height="+height);
//            }

            Image image = bufferedImage.getScaledInstance(1104, 420,
                    Image.SCALE_DEFAULT);
            BufferedImage outputImage = new BufferedImage(1104, 420,
                    BufferedImage.TYPE_INT_RGB);
            Graphics graphics = outputImage.getGraphics();
            graphics.drawImage(image, 0, 0, Color.white, null);
            graphics.dispose();
            ImageIO.write(outputImage, "jpg", new File("s.jpg"));

//            BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_BGR);
//            img.getGraphics().drawImage(bi, 0, 0, 16, 16, Color.white, null);
//            ImageIO.write(img, "png", new File("s.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
