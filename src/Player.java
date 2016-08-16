import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by DragonMyth on 16/7/2.
 */
public class Player implements Shootable, Drawable {
    // position indicates the up-left corner
    private int x;
    private int y;
    private int attackDelay;
    private Image mPlayerImage;

    public Player(int x, int y) {
        try {
            this.x = x;
            this.y = y;
            this.attackDelay=0;
            mPlayerImage = ImageIO.read(new File("/Users/DragonMyth/Documents/CS/Java/thunder/src/plane.jpg"));
            mPlayerImage = Util.setAlpha(mPlayerImage, 0);
        } catch (Exception e) {
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getmPlayerImage() {
        return mPlayerImage;
    }

    public void changeX(int amount) {
        x += amount;
    }

    public void changeY(int amount) {
        y += amount;
    }

    public void shoot() {
        System.out.println("Fire~");
        if(attackDelay<10){
            attackDelay++;
        }else {
            GameWorld.getInstance().addDrawable(new PlainBullet(x, y, 0, 10));
            attackDelay=0;
        }
    }

    public String toString() {
        String str = "X: " + x + " Y: " + y;
        return str;
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
        int playerWidth = getmPlayerImage().getWidth(null) / 12;
        int playerHeight = getmPlayerImage().getHeight(null) / 12;
        g.drawImage(getmPlayerImage(),
                getX() - playerWidth / 2, getY() - playerHeight / 2, playerWidth, playerHeight, null);
    }
}
