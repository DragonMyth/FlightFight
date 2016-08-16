import java.util.List;
import java.util.function.BooleanSupplier;

/**
 * Created by DragonMyth on 8/16/16.
 */
public class Clock implements Runnable {

    private static Clock clock = new Clock();
    private View vc;
    private Boolean stop = false;

    public static Clock getInstance() {
        return clock;
    }

    public void setViewController(View vc) {
        this.vc = vc;
    }

    public void pause() {
        stop = true;
    }


    @Override
    public void run() {
        while (!stop) {
            GameWorld.getInstance().step();
            try {
                Thread.sleep(20);
            } catch (Exception e) {
            }
        }

    }
}
