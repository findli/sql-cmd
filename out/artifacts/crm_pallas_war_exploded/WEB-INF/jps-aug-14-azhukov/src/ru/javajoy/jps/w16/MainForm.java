package ru.javajoy.jps.w16;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Artem Zhukov on 2/4/15.
 */
public class MainForm extends JFrame{
    private JList<String> personListComponent;
    private JList<String> friendListComponent;
    private static JButton moveRightButton;
    private static JButton moveLeftButton;
    private static JButton saveButton;
    private static JButton openButton;

    public MainForm(ListModel<String> friendListModel, ListModel<String> personListModel) {
        super("Список друзей");
        setLayout(new GridLayout(1, 3));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 200);
        initComponents(friendListModel, personListModel);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void initComponents(ListModel<String> friendListModel, ListModel<String> personListModel) {
        personListComponent = new JList<>(personListModel);
        personListComponent.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        friendListComponent = new JList<>(friendListModel);

        JPanel personPanel = new JPanel(new BorderLayout());
        personPanel.add(personListComponent);

        JPanel buttonsPanel = new JPanel();
        moveRightButton = new JButton("-->");
        moveLeftButton = new JButton("<--");
        saveButton = new JButton("Save");
        openButton = new JButton("Open");
        buttonsPanel.add(moveRightButton);
        buttonsPanel.add(moveLeftButton);
        buttonsPanel.add(saveButton);
        buttonsPanel.add(openButton);

        JPanel friendPanel = new JPanel(new BorderLayout());
        friendPanel.add(friendListComponent);

        getContentPane().add(personPanel);
        getContentPane().add(buttonsPanel);
        getContentPane().add(friendPanel);
    }

    public void display() {
        setVisible(true);
    }

    public JButton getMoveRightButton() {
        return moveRightButton;
    }

    public JButton getMoveLeftButton() {
        return moveLeftButton;
    }

    public static JButton getSaveButton() {
        return saveButton;
    }

    public static JButton getOpenButton() {
        return openButton;
    }

    public JList<String> getPersonListComponent() {
        return personListComponent;
    }

    public JList<String> getFriendListComponent() {
        return friendListComponent;
    }

}
