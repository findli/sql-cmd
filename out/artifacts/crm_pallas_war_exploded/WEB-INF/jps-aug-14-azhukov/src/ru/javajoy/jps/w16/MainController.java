package ru.javajoy.jps.w16;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.*;

/**
 * @author Artem Zhukov
 */
public class MainController implements ActionListener {
    private MainForm mainForm;
    private PersonCompositeModel personCompositeModel;
    private String directory = null;

    public MainController(MainForm mainForm, PersonCompositeModel personCompositeModel) {
        this.mainForm = mainForm;
        this.personCompositeModel = personCompositeModel;
        wireListeners();
    }

    private void wireListeners() {
        //Действие кнопки перемещения вправо
        mainForm.getPersonListComponent().addListSelectionListener(createPersonListSelectionListener());

        //Двойной клик для перемещения списка вправо
        mainForm.getPersonListComponent().addMouseListener(createPersonListMouseListener());

        //Действие кнопки перемещения влево
        mainForm.getFriendListComponent().addListSelectionListener(createFriendListSelectionListener());

        //Двойной клик для перемещения списка влево
        mainForm.getFriendListComponent().addMouseListener(createFriendListMouseListener());

        MainForm.getSaveButton().addActionListener(this);
        MainForm.getOpenButton().addActionListener(this);

    }

    private MouseInputAdapter createFriendListMouseListener() {
        return new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList friendList = mainForm.getFriendListComponent();
                    int selectedIndex = friendList.getSelectedIndex();

                    if (!friendList.isSelectionEmpty()) {

                        personCompositeModel.addPerson(personCompositeModel.getFriendAt(selectedIndex));
                        personCompositeModel.removeFriend(selectedIndex);
                    }
                }
            }
        };
    }

    private ListSelectionListener createFriendListSelectionListener() {
        return new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                JList list = (JList) e.getSource();
                int minIndex = list.getMinSelectionIndex();
                int maxIndex = list.getMaxSelectionIndex();

                for (int i = minIndex; i <= maxIndex; i++) {
                    final int finalI = i;

                    mainForm.getMoveLeftButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JList friendList = mainForm.getFriendListComponent();

                            if (friendList.isSelectedIndex(finalI)) {
                                personCompositeModel.addPerson(personCompositeModel.getFriendAt(finalI));
                                personCompositeModel.removeFriend(finalI);
                            }
                        }
                    });
                }
            }
        };
    }

    private MouseInputAdapter createPersonListMouseListener() {
        return new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList personList = mainForm.getPersonListComponent();
                    int selectedIndex = personList.getSelectedIndex();

                    if (!personList.isSelectionEmpty()) {
                        personCompositeModel.addFriend(personCompositeModel.getPersonAt(selectedIndex));
                        personCompositeModel.removePerson(selectedIndex);
                    }
                }
            }
        };
    }

    private ListSelectionListener createPersonListSelectionListener() {
        return new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }

                JList list = (JList) e.getSource();
                int minIndex = list.getMinSelectionIndex();
                int maxIndex = list.getMaxSelectionIndex();

                for (int i = minIndex; i <= maxIndex; i++) {
                    final int finalI = i;
                    mainForm.getMoveRightButton().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (mainForm.getPersonListComponent().isSelectedIndex(finalI)) {
                                personCompositeModel.addFriend(personCompositeModel.getPersonAt(finalI));
                                personCompositeModel.removePerson(finalI);
                            }
                        }
                    });
                }
            }
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Save")) {
            FileOutputStream fos;
            ObjectOutputStream out;
            FileNameExtensionFilter filter = new FileNameExtensionFilter(".dat", "*.*");
            JFileChooser chooserDirectory = new JFileChooser(directory);
            chooserDirectory.setFileFilter(filter);
            int ret = chooserDirectory.showDialog(null, "Сохранить файл");
            if (ret == 0) {
                try {
                    directory = String.valueOf(chooserDirectory.getSelectedFile());
                    fos = new FileOutputStream(directory);
                    out = new ObjectOutputStream(fos);
                    out.writeObject(personCompositeModel);
                    out.close();
                } catch (IOException e1) {
                    System.out.println("Исключение во время сериализации : " + e);
                }
            }
        } else {
            JFileChooser fileOpen = new JFileChooser(directory);
            int ret = fileOpen.showDialog(null, "Открыть файл");
            String fileName = String.valueOf(fileOpen.getSelectedFile());
            if (ret == 0) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                    personCompositeModel = (PersonCompositeModel) ois.readObject();
                    mainForm.getFriendListComponent().setModel(personCompositeModel.getFriendListModel());
                    mainForm.getPersonListComponent().setModel(personCompositeModel.getPersonListModel());
                } catch (Exception e1) {
                    System.out.println("Исключение во время сериализации: " + e1);
                }
            }
        }
    }
}
