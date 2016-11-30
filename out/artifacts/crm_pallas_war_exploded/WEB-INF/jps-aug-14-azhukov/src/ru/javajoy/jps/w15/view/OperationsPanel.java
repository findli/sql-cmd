package ru.javajoy.jps.w15.view;

import ru.javajoy.jps.w15.controller.FileVisitor;
import ru.javajoy.jps.w15.model.OperationsEnum;
import ru.javajoy.jps.w15.util.MessageBoxUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

/**
 * Описание функционала JComboBox
 *
 * @author Artem Zhukov
 */
public class OperationsPanel extends JPanel {

    private JPanel parent;
    private JButton btnOk = new JButton("Ok");
    private JComboBox<OperationsEnum> cbOperations = new JComboBox<>(OperationsEnum.values());

    /**
     *
     */
    public OperationsPanel(JPanel parent) {
        this.parent = parent;
        add(this.btnOk);
        add(this.cbOperations);
        initListeners();
    }

    /**
     *
     */
    private void initListeners() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperationsEnum operation = (OperationsEnum) cbOperations.getSelectedItem();
                ((MainPanel) parent).getLblOperationResultMessage().setText("");

                File pathFrom = new File(((MainPanel) parent).getTfFirstPath().getText());
                File pathTo = new File(((MainPanel) parent).getTfSecondPath().getText());

                try {
                    FileVisitor visitor = new FileVisitor(pathFrom, pathTo, operation, parent);
                    Files.walkFileTree(Paths.get(String.valueOf(pathFrom)), visitor);
                } catch (NoSuchFileException e0) {
                    MessageBoxUtils.showFileNotFoundDialog();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //Делает неактивное второй textField для операция Delete, Size
        cbOperations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperationsEnum operation = (OperationsEnum) cbOperations.getSelectedItem();
                switch (operation) {
                    case COPY:
                    case MOVE:
                        setVisibleTextField(true);
                        break;
                    case DELETE:
                    case SIZE:
                        setVisibleTextField(false);
                        break;
                }
            }
        });
    }

    /**
     * Видимость поля tfSecondPath
     *
     * @param bol
     */
    private void setVisibleTextField(boolean bol) {
        ((MainPanel) parent).getTfSecondPath().setEnabled(bol);
    }

}
