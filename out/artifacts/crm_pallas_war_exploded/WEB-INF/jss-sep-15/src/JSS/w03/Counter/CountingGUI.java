package JSS.w03.Counter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Cyrill on 19.09.2014.
 */
public class CountingGUI {
    private JButton butRefresh;
    private JTextField textCounter;
    private JPanel contentPane;
    private static int counter = 0;

    private JButton butStart;
    private JButton butStop;
    private JTextField textCounter1;
    private JButton butPause;

    private static int counter1 = 0;
    private boolean bStop = true;

    private CountingThread countingThread = null;

    public CountingGUI() {
        butRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textCounter.setText(String.valueOf(counter));
            }
        });

         initSecondCounter();
        // initUnrespondingCounter();
    }


    private void initUnrespondingCounter() {
        butStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bStop = false;
                textCounter1.setText("started");
                for (int i = 0; i < 10; ++i) {
                    if (bStop) break;  // check if STOP button has been pushed,
                    //  which changes the stop flag to true
                    textCounter1.setText(String.valueOf(counter1));
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException ie) {}
                    ++counter1;
                }
            }
        });
        butStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bStop = true;
            }
        });
    }


    private void initSecondCounter() {

        // Counting start-stop
        butStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (countingThread!=null && countingThread.isAlive()) {
                    countingThread.stopCounting();
                }
                (countingThread = new CountingThread()).start();
                butStart.setEnabled(true);
                butPause.setEnabled(true);
                butStop.setEnabled(true);
            }
        });

        butPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countingThread.pauseCounting();
            }
        });

        butStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countingThread.stopCounting();
                butStart.setEnabled(true);
                butPause.setEnabled(false);
                butStop.setEnabled(false);
            }
        });

        // refresh UI thread
        new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {
                        textCounter1.setText(String.valueOf(
                                (countingThread!=null)? countingThread.getCount() : 0));
                        sleep(200);
                    } catch (InterruptedException e) {}

                }
            }
        }.start();


    }


    public static void main(String[] args) {



        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame("Counting");
                frame.setContentPane(new CountingGUI().contentPane);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        } );

        while (true) {
            counter++;
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
