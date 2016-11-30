package JSS.w04_p02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapesFrame extends JFrame {
    private JPanel drawingPane;
    private Scene scene;                            // Collection of MovingShape
    static private MovingShape userMS;           // User controlled shape

    private Repainter repainter  = null;            // Repainting process

    static private boolean bTrackMouse = false;     // Dragging is in progress?
    static private int mouse_dx = 0, mouse_dy = 0;  // Drag point coordinates relative to figure's center



    public ShapesFrame(String title) throws HeadlessException {
        super(title);
    }

    class Repainter extends Thread {

        private boolean bStop = false;
        private int timeout = 30;

        public void stopThread() {
            bStop = true;
        }

        @Override
        public void run() {
            super.run();

            while(!bStop) {
                repaint();
                try {
                    sleep(timeout);
                } catch (InterruptedException e) {

                }
            }
        }
    }


    private void init() {
        scene = new Scene(drawingPane.getWidth(), drawingPane.getHeight());

        scene.add(new MovingShape( scene, new Shape( 50, 100, 100, 100, 100, Color.GREEN ), false ) );
        scene.add(new MovingShape( scene, new Shape( 30, 100, 250, 90, -90, Color.GREEN ), false ) );
        scene.add(userMS = new MovingShape( scene, new Shape( 40, 300, 200, 0, 0, Color.GRAY ), true ) );

        scene.start();

        repainter = new Repainter();
        repainter.start();

        // Stop threads on window close event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if (scene != null) {
                    scene.stop();
                }
                if (repainter != null) {
                    repainter.stopThread();
                    repainter.interrupt();
                }
            }
        });

        // Process the mouse and keyboard events
        this.enableEvents( AWTEvent.KEY_EVENT_MASK );   // use processKeyEvent() to process keyboard input
        MouseAdapter mouseAdapter = new DragMouseAdapter();
        drawingPane.addMouseListener(mouseAdapter);
        drawingPane.addMouseMotionListener(mouseAdapter);
    }

    class DragMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            // Test if the user-controlled shape is hit
            Shape shape = userMS.getShape();
            mouse_dx = e.getX() - (int) shape.getX();
            mouse_dy = e.getY() - (int) shape.getY();
            if( Math.abs(mouse_dx) <= shape.getSize()/2+1 && Math.abs(mouse_dy) <= shape.getSize()/2+1 ) {
                // Start dragging
                bTrackMouse = true;
                setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
            }
        }
        public void mouseReleased(MouseEvent e) {
            bTrackMouse = false;
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
        public void mouseDragged(MouseEvent e) {
            // Drag the user-controlled shape
            Shape shape = userMS.getShape();
            if( bTrackMouse ) {
                Dimension dim = new Dimension( getComponent(0).getWidth(), getComponent(0).getHeight() );
                int sz = shape.getSize();
                shape.setX(Math.min(Math.max(sz / 2, (double) e.getX() - mouse_dx), dim.width - sz / 2));
                shape.setY(Math.min(Math.max(sz / 2, (double) e.getY() - mouse_dy), dim.height - sz / 2));
                repaint();
            }
        }
        public void mouseMoved(MouseEvent e) {
            // Test if the user-controlled shape is hit
            Shape shape = userMS.getShape();
            int dx = e.getX()-(int)shape.getX();
            int dy = e.getY()-(int)shape.getY();
            // Change mouse cursor
            if( Math.abs(dx) <= shape.getSize()/2+1 && Math.abs(dy) <= shape.getSize()/2+1 ) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            } else {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        }

    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        Shape shape = userMS.getShape();

        switch ( e.getID() ) {
            case KeyEvent.KEY_PRESSED :
                switch( e.getKeyCode() ) {
                    case KeyEvent.VK_LEFT:
                        shape.setVX(-100); break;
                    case KeyEvent.VK_RIGHT:
                        shape.setVX(100); break;
                    case KeyEvent.VK_UP:
                        shape.setVY(-100); break;
                    case KeyEvent.VK_DOWN:
                        shape.setVY(100); break;
                }
                break;
            case KeyEvent.KEY_RELEASED:
                switch( e.getKeyCode() ) {
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                        shape.setVX(0); break;
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_DOWN:
                        shape.setVY(0); break;
                }
                break;
        }
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D gg =  (Graphics2D) drawingPane.getGraphics();

        gg.setColor(Color.WHITE);
        gg.fillRect(0, 0, drawingPane.getWidth(), drawingPane.getHeight());

        scene.paint(gg);
    }

    public static void main(String[] args) {
        ShapesFrame frame = new ShapesFrame("ShapesForm");
        frame.setContentPane(frame.drawingPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.drawingPane.setPreferredSize(new Dimension(500, 300));
        frame.pack();
        frame.setResizable(false);
        frame.init();
        frame.setVisible(true);
    }
}
