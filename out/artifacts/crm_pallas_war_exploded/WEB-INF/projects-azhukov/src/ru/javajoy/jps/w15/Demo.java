package ru.javajoy.jps.w15;

import ru.javajoy.jps.w15.view.MainPanel;

import javax.swing.*;

/**
 * Запуск программы, формирование окна
 * Программа которая позволяет вводить (в текстовые поля) имена файлов или директорий, выбирать операции
 * (из выпадающего списка) и выполнять их:
 * - копировать
 * - переместить
 * - удалить
 * - узнать размер
 *
 * @author Artem Zhukov
 */

public class Demo extends JFrame {

    public static void main(String[] args) {
        new Demo();
    }

    public Demo() {
        super("File Manager");
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        MainPanel mainPanel = new MainPanel();
        getContentPane().add(mainPanel);
        setResizable(false);
    }
}
