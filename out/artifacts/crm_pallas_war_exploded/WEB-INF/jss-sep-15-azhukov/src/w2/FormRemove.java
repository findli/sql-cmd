package w2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class FormRemove extends JFrame implements ActionListener {

    private static final String DOTS = "...";
    private static final String OK = "Ok";
    private static final String CANCEL = "Cancel";
    private JPanel panelLb = new JPanel();
    private JPanel panelBut = new JPanel();
    private JTextField inputUrl = new JTextField();
    private JButton butUrl = new JButton(DOTS);
    private JButton butOk = new JButton(OK);
    private JButton butCancel = new JButton(CANCEL);
    private Form form = new Form();

    public FormRemove() {
        super("Remove photo");
        setSize(500, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        panels();
        butUrl.addActionListener(this);
        butOk.addActionListener(this);
        butCancel.addActionListener(this);
    }

    private void panels() {
        inputUrl.setEnabled(false);
        Dimension dimension = new Dimension(400, 30);
        inputUrl.setPreferredSize(dimension);
        panelLb.add(inputUrl);
        panelLb.add(butUrl, new FlowLayout(FlowLayout.RIGHT));
        panelBut.add(butOk);
        panelBut.add(butCancel);
        add(panelLb);
        add(panelBut);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(DOTS)) {
            JFileChooser fileChooser = new JFileChooser();
            final int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                inputUrl.setText(String.valueOf(selectedFile));
            }
        } else if (e.getActionCommand().equals(OK)) {
            try {
                CallableStatement remove = Form.getConn().prepareCall("{call photogallery.remove(?)}");
                remove.setString(1, String.valueOf(inputUrl.getText()));
                remove.execute();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            dispose();
            form.updateListUrl();

        } else if (e.getActionCommand().equals(CANCEL)) {
            inputUrl.setText(null);
            dispose();

        }
    }
}
