import java.awt.*;

/**
 * Created by DragonMyth on 8/16/16.
 */
public interface Drawable {
    Boolean hitDetection(int x, int y);
    void hit();
    void paintComponent(Graphics g);
}
