import java.awt.*;

/**
 * Created by DragonMyth on 8/16/16.
 */
public class PlainBullet implements Drawable {
    private int posX;
    private int posY;
    private int speedX;
    private int speedY;


    public PlainBullet(int x, int y, int speedX, int speedY) {
        posX = x;
        posY = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    public Boolean hitDetection(int x, int y) {
        return null;
    }

    @Override
    public void hit() {

    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.red);
        posX += speedX;
        posY -= speedY;
        g.fillOval(posX, posY, 5 , 5);
    }
    public String toString() {
        String str = "X: " + posX + " Y: " + posY;
        return str;
    }
}
