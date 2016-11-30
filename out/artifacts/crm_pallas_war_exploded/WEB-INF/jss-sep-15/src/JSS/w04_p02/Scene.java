package JSS.w04_p02;


import java.awt.*;
import java.util.ArrayList;

public class Scene extends ArrayList<MovingShape> {

    protected int width, height;

    public Scene(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    public Dimension getDimension() {
        return new Dimension(width,height);
    }

    public void start() {
        for (MovingShape s : this) {
            s.start();
        }
    }

    public void stop() {
        for (MovingShape s : this) {
            s.stopThread();
        }

    }

    public synchronized void paint( Graphics2D g ) {
        for (MovingShape s : this) {
            s.getShape().paint(g);
        }
    }

}
