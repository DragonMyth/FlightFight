import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by DragonMyth on 16/7/2.
 */
public class OverallVC extends JPanel implements View, KeyListener {
    private Player mPlayer;
    private Image mBackGroundImage;
    private Boolean movPressed;
    private Boolean attackPressed;

    public OverallVC() {
        try {
            setLayout(null);
            setPreferredSize(new Dimension(600, 800));
            mPlayer = new Player(this.getWidth() / 2, 100);
            GameWorld.getInstance().addDrawable(mPlayer);
            GameWorld.getInstance().addShootable(mPlayer);

            mBackGroundImage = ImageIO.read(new File("/Users/DragonMyth/Documents/CS/Java/thunder/src/background.jpg"));
            this.addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                }

                @Override
                public void mouseMoved(MouseEvent e) {
//                    System.out.println(e.getX() + e.getY());
                    mPlayer.setX(e.getX());
                    mPlayer.setY(e.getY());
                }
            });
            this.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    attackPressed = true;
                    Thread moving = new Thread(new Runnable() {
                        @Override
                        public void run() {
//                            while (attackPressed) {
//                                try {
//                                    GameWorld.getInstance().addView(mPlayer.shoot());
//
//                                    Thread.sleep(500);
//                                } catch (Exception excep) {
//
//                                }
//                            }

                        }
                    }

                    );
                    moving.start();


                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    attackPressed = false;
                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            //this.addKeyListener(new KeyAdapter() {

            // });
        } catch (IOException ex) {
            System.out.println("Image not found");
        }
    }

    public void keyTyped(KeyEvent e) {
        movPressed = true;
        Thread moving = new Thread(new Runnable() {
            @Override
            public void run() {
                while (movPressed) {
                    try {
                        switch (e.getKeyChar()) {
                            case 'w':
                                mPlayer.changeY(-5);
                                break;
                            case 's':
                                mPlayer.changeY(5);
                                break;
                            case 'a':
                                mPlayer.changeX(-5);
                                break;
                            case 'd':
                                mPlayer.changeX(5);
                                break;

                        }
                        Thread.sleep(50);
                    } catch (Exception excep) {

                    }
                }

            }
        }

        );
        moving.start();

    }
    @Override
    public void keyPressed(KeyEvent e) {
        movPressed = false;
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mBackGroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
        for (Drawable figure : GameWorld.getInstance().getDrawables()) {

            figure.paintComponent(g);
        }

    }

    @Override
    public void drawView() {
        repaint();
    }
}
