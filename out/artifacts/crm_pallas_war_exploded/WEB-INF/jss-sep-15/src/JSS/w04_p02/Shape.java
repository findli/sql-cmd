package JSS.w04_p02;

import java.awt.*;
import java.awt.geom.Point2D;

public class Shape {

    int size = 20;
    Point2D.Double pos;   // Center coordinates
    Point2D.Double v;     // Velocity

    Color color = Color.BLUE;

    public Shape(int size, int posX, int posY, double vX, double vY, Color color) {
        this.size = size;
        this.pos = new Point2D.Double(posX, posY);
        this.v = new Point2D.Double(vX, vY);
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Point2D.Double getPos() {
        return pos;
    }

    public Point2D.Double getV() {
        return v;
    }

    public void setPos(Point2D.Double pos) {
        this.pos = pos;
    }

    public void setV(Point2D.Double v) {
        this.v = v;
    }

    public double getX() {
        return pos.getX();
    }

    public double getY() {
        return pos.getY();
    }

    public void setX(double x) {
        pos.setLocation(x, pos.getY());
    }

    public void setY(double y) {
        pos.setLocation(pos.getX(), y);
    }

    public double getVX() {
        return v.getX();
    }

    public double getVY() {
        return v.getY();
    }

    public void setVX(double x) {
        v.setLocation(x, v.getY());
    }

    public void setVY(double y) {
        v.setLocation(v.getX(), y);
    }

    public void paint( Graphics2D g ) {

        g.setColor(color);
        g.fillRect( (int) pos.getX() - size/2, (int) pos.getY() - size/2, size, size);

    }

}
