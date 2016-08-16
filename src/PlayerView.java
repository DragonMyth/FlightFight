//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionListener;
//import java.io.File;
//import java.io.IOException;
//
///**
// * Created by DragonMyth on 16/7/2.
// */
//public class PlayerView extends JPanel implements View{
//    private Player mPlayer;
//    private Image mPlayerImage;
//
//    public PlayerView(int startPosX, int startPosY) {
//        try {
//            mPlayer = new Player(startPosX, startPosY);
//            mPlayerImage = ImageIO.read(new File("/Users/DragonMyth/Documents/CS/Java/thunder/src/plane.jpg"));
//
//        } catch (IOException e) {
//            System.out.println("File not found");
//        }
//    }
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(mPlayerImage,mPlayer.getX(),mPlayer.getY(),70,70,null);
//    }
//    @Override
//    public void drawView() {
//        repaint();
//    }
//}
