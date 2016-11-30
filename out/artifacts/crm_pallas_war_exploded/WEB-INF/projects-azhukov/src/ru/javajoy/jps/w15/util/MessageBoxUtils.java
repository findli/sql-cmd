package ru.javajoy.jps.w15.util;

import javax.swing.*;

/**
 * Класс содержит методы для вспомогательных окон
 *
 * @author Artem Zhukov
 */
public class MessageBoxUtils {

    /**
     * Сообщение, что файл не существует
     */
    public static void showFileNotFoundDialog() {
        showMessageDialog("File or directory is not found");
    }

    /**
     * Подтверждение операции
     */
    public static void showActionCompleteMessage() {
        JFrame parent = new JFrame();
        JOptionPane.showMessageDialog(parent, "Action complete");
    }

    public static void showMessageDialog(String message) {
        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(message);
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(null, "Info");
        dialog.setVisible(true);
    }
}
