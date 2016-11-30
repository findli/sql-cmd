package ru.javajoy.jps.w13;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Провереят наличие вводимого имени с базой имен
 * <p/>
 * Провереят наличие вводимого имени с базой имен.При неизвестном имени вводимое поле окрашивается в красный цвет.
 * Кнопка Esc  - удаляет значения из TextField и JLable. Ctrl+ Space - в поле заносится текущая подсказка
 *
 * @Артем
 */
public class CheckName extends JFrame {

    private JPanel paneEnterName;
    private JPanel paneCheckName;

    private String name[] = {
            "Анна", "Анастасия", "София", "Виктория",
            "Валерия", "Алёна", "Диана", "Ольга",
            "Евгения", "Алеся", "Елена", "Ирина",
            "Яна", "Кристина", "Ева"};

    private JTextField enterName = new JTextField(10);

    private JLabel labelCheckName = new JLabel("");

    /**
     * Start point
     * @param args
     */
    public static void main(String[] args) {
        new CheckName();
    }

    /**
     *
     */
    public CheckName() {
        super("Check name");

        JLabel labelName = new JLabel("Enter name");
        setLayout(new GridLayout(2, 1));
        setResizable(false);
        setSize(250, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panels();

        paneEnterName.add(labelName);
        paneEnterName.add(enterName);
        setVisible(true);

        //Определение роли для кнопок клавиатуры Esc и Ctrl+Space
        enterName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //Удаляет текст в лэйбле, а так же текстфилде
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    labelCheckName.setText("");
                    enterName.setText("");
                    enterName.setBackground(Color.WHITE);
                }
                //Заносит имя в рабочий массив
                if ((e.getKeyCode() == KeyEvent.VK_SPACE) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    enterName.setBackground(Color.WHITE);
                    labelCheckName.setText(enterName.getText());
                    paneCheckName.add(labelCheckName);
                    revalidate();
                }
            }
        });

        enterName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                check();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                remove();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                check();
            }
        });
    }

    //Проверка вводимого имени на предмет наличия в рабочем массиве
    public void check() {
        for (int i = 0; i < name.length; i++) {
            if (name[i].startsWith(enterName.getText())) {
                labelCheckName.setText(name[i]);
                i = name.length;
                paneCheckName.add(labelCheckName);
                enterName.setBackground(Color.WHITE);
            }

            if (enterName.getText().equals("")) {
                labelCheckName.setText("");
                enterName.setBackground(Color.WHITE);
            }

            if (i + 1 == name.length) {
                enterName.setBackground(new Color(255, 132, 132));
                labelCheckName.setText("");
                i = name.length;
            }
            revalidate();
        }
    }

    //Удаление лэйблы для  public void removeUpdate(DocumentEvent e)
    public void remove() {
        labelCheckName.setText("");
        check();
    }

    //Формирование панелей
    public void panels() {
        paneEnterName = new JPanel();
        paneEnterName.setLayout(new FlowLayout(FlowLayout.CENTER));
        paneCheckName = new JPanel();
        paneCheckName.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(paneEnterName);
        add(paneCheckName);
    }

}
