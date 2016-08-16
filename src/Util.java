import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * Created by DragonMyth on 16/7/2.
 */
public class Util {
    public static Image setAlpha(Image image, int alpha){
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2d = (Graphics2D) bufferedImage.getGraphics();
        g2d.drawImage(image,0,0,null);
        for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage.getHeight(); j1++) {
            for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage.getWidth(); j2++) {
                int rgb = bufferedImage.getRGB(j2, j1);
                if(rgb == Color.white.getRGB()) {
                    rgb = ((alpha * 255 / 10) << 24) | (rgb & 0x00ffffff);
                    bufferedImage.setRGB(j2, j1, rgb);
                }
            }
        }
        g2d.drawImage(bufferedImage,0,0,null);
        return bufferedImage;
    }
}
