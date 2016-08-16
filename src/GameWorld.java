import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DragonMyth on 16/7/2.
 */
public class GameWorld extends JFrame {
    private static GameWorld instance = new GameWorld();

    private OverallVC backGroundView;
    private List<Drawable> views;
    private List<Shootable> shootables;
    //private JFrame mFrame;
    private Clock gameClock = Clock.getInstance();

    private GameWorld() {
        this.setName("Good Good Study");
    }

    public static GameWorld getInstance() {
        return instance;
    }

    public void startGame() {
        views = new ArrayList<>();
        shootables = new ArrayList<>();
        this.setSize(600, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        backGroundView = new OverallVC();
        this.getContentPane().add(backGroundView);
        this.addKeyListener(backGroundView);
        this.pack();
        this.setVisible(true);
        gameClock.setViewController(backGroundView);
        gameClock.run();
    }
    public void step() {
        //TODO Changes after every tick
        for (Shootable shootable : shootables) {
            System.out.println("Player: " + shootable);
            shootable.shoot();
        }
        System.out.println("tick");
        backGroundView.drawView();
    }

    public List<Drawable> getDrawables() {
        return views;
    }

    public void addDrawable(Drawable view) {
        views.add(view);
    }

    public void addShootable(Shootable shootable) {
        shootables.add(shootable);
    }

    public void removeDrawable(Drawable view) {
        views.remove(view);
    }
}
