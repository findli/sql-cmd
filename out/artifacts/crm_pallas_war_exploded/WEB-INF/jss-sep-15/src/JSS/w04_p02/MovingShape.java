package JSS.w04_p02;


import java.awt.*;

public class MovingShape extends Thread {

    Shape shape = null;
    boolean bStop = false;
    Scene scene = null;
    boolean bUserControlled = true;
    long tPrev = 0;

    public MovingShape(Scene scene, Shape shape, boolean bUserControlled) {
        this.shape = shape;
        this.scene = scene;
        this.bUserControlled = bUserControlled;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void stopThread() {
        bStop = true;
    }


    @Override
    public void run() {
        super.run();
        bStop = false;
        tPrev = System.nanoTime();

        while(!bStop) {

            synchronized (scene) {  // not single shape!

                move();

                try {
                    scene.wait(30);
                } catch (InterruptedException e) {}
            }

        }
    }


    private void move() {

        Dimension dimension = scene.getDimension();
        if (!bUserControlled) {

            for (MovingShape ms : scene) {          // Check for collisions with other shapes

                Shape other = ms.getShape();
                if (shape == other) {               // but not with itself
                    continue;
                }
                if (Math.abs(shape.getX() - other.getX()) <= (double) (shape.getSize() + other.getSize()) / 2 &&
                        Math.abs(shape.getY() - other.getY()) <= (double) (shape.getSize() + other.getSize()) / 2) {

                    // Collision with other shape
                    if (Math.abs(shape.getX() - other.getX()) > Math.abs(shape.getY() - other.getY())) {

                        // Horizontal collision
                        double x[] = new double[]{shape.getX(), other.getX()};
                        double v[] = new double[]{shape.getVX(), other.getVX()};

                        // recalculates positions and velocities of colliding shapes
                        collision(x, v, new int[]{shape.size, other.size}, ms.bUserControlled);

                        shape.setX(x[0]);
                        shape.setVX(v[0]);
                        other.setVX(v[1]);

                    } else {

                        // Vertical collision
                        double y[] = new double[]{shape.getY(), other.getY()};
                        double v[] = new double[]{shape.getVY(), other.getVY()};

                        // recalculates positions and velocities of colliding shapes
                        collision(y, v, new int[]{shape.size, other.size}, ms.bUserControlled);

                        shape.setY(y[0]);
                        shape.setVY(v[0]);
                        other.setVY(v[1]);

                    }

                }
            }

            // Check for collisions with the walls
            if (shape.getX() - shape.getSize() / 2 <= 0 && shape.getVX() < 0  ||
                    shape.getX() + shape.getSize() / 2 >= dimension.width && shape.getVX() > 0 ) {
                shape.setVX( -shape.getVX() );
            }
            if (shape.getY() - shape.getSize() / 2 <= 0 && shape.getVY() < 0 ||
                    shape.getY() + shape.getSize() / 2 >= dimension.height && shape.getVY() > 0) {
                shape.setVY( -shape.getVY() );
            }
        }

        // Get current time
        long t = System.nanoTime();
        double dt = (t - tPrev) / 1.e9;
        tPrev = t;

        //  recalculate the position
        double x = shape.getX() + shape.getVX() * dt;
        double y = shape.getY() + shape.getVY() * dt;
        double sz = shape.size;
        shape.setX(x); shape.setY(y);

        shape.setX( Math.min(Math.max(sz/2, x), dimension.width - sz/2) );
        shape.setY( Math.min(Math.max(sz/2, y), dimension.height - sz/2));

    }

    // recalculates positions and velocities of colliding shapes
    private void collision( double[] x,       // Coordinates of two shapes
                            double[] v,       // velocities
                            int[] size,       // sizes
                            boolean bUserControlled) {


        if (x[0] < x[1]) {     // Shapes may be intersecting
            x[0] = x[1] - (double) (size[0] + size[1]) / 2;
        } else {
            x[0] = x[1] + (double) (size[0] + size[1]) / 2;
        }
        if ((x[0] - x[1]) * (v[0] - v[1]) < 0) {     // Shapes are approaching
            if (bUserControlled) {  // Collision with user controlled shape
                v[0] = -v[0];
            } else {  // Collision with ordinary shape
                double m0 = size[0] * size[0], m1 = size[1] * size[1];
                double vcx = (v[0]*m0 + v[1]*m1) / (m0+m1);     // Mass center's velocity
                v[0] = -v[0] + 2*vcx;
                v[1] = -v[1] + 2*vcx;
            }
        }
    }

}
