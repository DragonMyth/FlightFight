import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by DragonMyth on 16/7/2.
 */
public class ThunderGame {
    public static void main(String[] args) throws IOException {

//        JFrame appFrame = new JFrame("GOOD GOOD STUDY");
//        GameWorld world = new GameWorld(appFrame);
//        appFrame.setSize(600, 800);
//        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GameWorld.getInstance().startGame();
//      Util.setAlpha(ImageIO.read(new File("/Users/DragonMyth/Documents/CS/Java/thunder/src/plane.jpg")), 4);
    }
}
