package w3;


import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {


    private JPanel outPnl = new JPanel();
    private JPanel inPnl = new JPanel();
    private JPanel butPnl = new JPanel();
    private JPanel statusPnl = new JPanel();
    private JLabel outLb = new JLabel("File");
    private JLabel inLb = new JLabel("Destination");
    private JTextField inTf = new JTextField(30);
    private JTextField outTf = new JTextField(30);
    private JButton startBut = new JButton("Copy");
    private JButton pauseBut = new JButton("Pause");
    private JButton stopBut = new JButton("Stop");


    public Form() {
        setSize(380, 200);
        setName("CopyFiles");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        createForm();
    }

    private void createForm() {
        outPnl.add(outLb);
        outPnl.add(outTf);
        inPnl.add(inLb);
        inPnl.add(inTf);
        butPnl.add(startBut);
        butPnl.add(pauseBut);
        butPnl.add(stopBut);
        add(outPnl);
        add(inPnl);
        add(statusPnl);
        add(butPnl);
    }

}
