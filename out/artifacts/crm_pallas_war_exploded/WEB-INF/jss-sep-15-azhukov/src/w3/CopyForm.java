package w3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyForm {
    private JTextField copyFrom = new JTextField(100);
    private JTextField copyTo = new JTextField(100);
    private JButton stopBut;
    private JButton pauseBut;
    private JButton copyBut;
    private JLabel file;
    private JLabel destination;
    private JLabel process;
    private JPanel panel;
    FileInputStream in;
    FileOutputStream out;


    public CopyForm() {
        copyBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("!!!!" + copyFrom.getText());
                    in = new FileInputStream("d:/1.txt");
                    out = new FileOutputStream("d:/Δενό11.png");
                    int c;
                    while ((c = in.read()) != -1) {
                        out.write(c);
                    }
                } catch (FileNotFoundException exc) {
                    exc.printStackTrace();
                } catch (IOException exc){
                    exc.printStackTrace();
                }
            }
        });
    }


    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame("CopyFiles");
                frame.setContentPane(new CopyForm().panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
