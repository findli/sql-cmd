package ru.javajoy.jps.w15.view;

import javax.swing.*;
import java.awt.*;

/**
 * Добавление в окно полей, кнопок, информационой панели
 *
 * @author Artem Zhukov
 */
public class MainPanel extends JPanel {

    private JLabel lblOperationResultMessage = new JLabel();
    private JTextField tfFirstPath = new JTextField(30);
    private JTextField tfSecondPath = new JTextField(30);

    public MainPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel pInputDirectory = new JPanel();
        pInputDirectory.setPreferredSize(new Dimension(400, 100));
        JPanel pActions = new JPanel();
        pActions.setPreferredSize(new Dimension(400, 100));
        pInputDirectory.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbEnterFirstDirectory = new JLabel("Enter directory for search file: ");
        pInputDirectory.add(lbEnterFirstDirectory);
        pInputDirectory.add(tfFirstPath);
        JLabel lbEnterSecondDirectory = new JLabel("Enter directory for paste file: ");
        pInputDirectory.add(lbEnterSecondDirectory);
        pInputDirectory.add(tfSecondPath);

        JPanel pCombo = new JPanel();
        pCombo.add(new OperationsPanel(this));
        pCombo.add(lblOperationResultMessage, BorderLayout.WEST);

        add(pInputDirectory, BorderLayout.CENTER);
        add(pCombo, BorderLayout.SOUTH);
    }

    public void setInfo(String message) {
        this.lblOperationResultMessage.setText(message);
    }

    public JLabel getLblOperationResultMessage() {
        return lblOperationResultMessage;
    }

    public JTextField getTfFirstPath() {
        return tfFirstPath;
    }

    public JTextField getTfSecondPath() {
        return tfSecondPath;
    }
}
