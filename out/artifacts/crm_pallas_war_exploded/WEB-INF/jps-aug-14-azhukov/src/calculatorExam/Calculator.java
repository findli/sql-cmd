package calculatorExam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Калькулятор.
 *
 * @author Artem Zhukov
 */
public class Calculator extends JFrame implements ActionListener {

    private JTextField inputOutputField = new JTextField();
    private JLabel display = new JLabel();

    private static String[] namesBut = {"7", "8", "9", "BackSpace", "C",
            "4", "5", "6", "Plus", "Multi",
            "1", "2", "3", "Minus", "Div",
            "0", ".",
            "Equal"};
    private static JButton[] but = new JButton[namesBut.length];

    Processor processor = new Processor(this);

    public Calculator() {
        super("Calculator");
        final Container container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.BLACK);
        createFormButtons();
        container.add(inputOutputField);
        container.add(display);
        //Присвоение лисенера каждой кнопке
        addListener(container, but);
        Font font = new Font("Times New Roman", Font.BOLD, 20);
        Font fontDisplay = new Font("Times New Roman", Font.BOLD, 15);
        inputOutputField.setBackground(Color.BLACK);
        inputOutputField.setForeground(Color.WHITE);
        inputOutputField.setFont(font);
        inputOutputField.setHorizontalAlignment(JTextField.RIGHT);

        display.setForeground(Color.WHITE);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(fontDisplay);

        setSize(370, 385);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        inputOutputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char symbol = e.getKeyChar();
                int keyCode = e.getKeyCode();
                processor.actionKeyListener(symbol);
                processor.checkInputEnterEscBackSpace(keyCode);
                processor.checkDoublePoint(keyCode);
            }
        });
    }

    public enum ButtonIndex {
        BUT_7,
        BUT_8,
        BUT_9,
        BUT_BACKSPACE,
        BUT_C,
        BUT_4,
        BUT_5,
        BUT_6,
        BUT_PLUS,
        BUT_MULTI,
        BUT_1,
        BUT_2,
        BUT_3,
        BUT_MINUS,
        BUT_DIV,
        BUT_0,
        BUT_POINT,
        BUT_EQUAL
    }

    private JButton getButton(ButtonIndex i) {
        return but[i.ordinal()];
    }

    private int getIndexButton(ButtonIndex i) {
        return i.ordinal();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(getButton(ButtonIndex.BUT_C))) {
            processor.pushButtonC();
        } else if (e.getSource().equals(getButton(ButtonIndex.BUT_BACKSPACE))) {
            processor.pushButtonBackSpace();
        } else if (e.getSource().equals(getButton(ButtonIndex.BUT_EQUAL))) {
            processor.checkPushEqually();
        } else {
            char symbol = e.getActionCommand().charAt(0);
            processor.pushOperand(symbol);
            processor.actionKeyListener(symbol);
        }
    }


    private void addListener(Container container, JButton[] arrayBut) {
        for (JButton anArrayBut : arrayBut) {
            anArrayBut.addActionListener(this);
            anArrayBut.setFocusable(false);
            container.add(anArrayBut);
        }
    }

    public void viewResult(String result) {
        inputOutputField.setText(result);
    }

    private void createFormButtons() {
        for (int i = 0; i < but.length; i++) {
            but[i] = new JButton(new ImageIcon(Constants.ICON_PATH + namesBut[i] + Constants.ICON_FILE_EXTENSION));
        }

        inputOutputField.setBounds(35, 15, 300, 50);
        display.setBounds(35, 70, 300, 20);
        int horLine = -25;
        int verLine = 85;
        int step = 60;
        int sizeIcon = 50;
        /**
         * ОС Windows запрещает в именах файлов использовать знаки "/", "*", для корректной работы калькулятора после
         * добавления кнопок на панель необходимо изменить название в namesBut.
         */
        namesBut[getIndexButton(ButtonIndex.BUT_PLUS)] = Constants.PLUS;
        namesBut[getIndexButton(ButtonIndex.BUT_MULTI)] = Constants.MULTI;
        namesBut[getIndexButton(ButtonIndex.BUT_MINUS)] = Constants.MINUS;
        namesBut[getIndexButton(ButtonIndex.BUT_DIV)] = Constants.DIV;
        for (int i = 0; i < namesBut.length - 1; i++) {
            horLine += step;
            but[i].setBounds(horLine, verLine, sizeIcon, sizeIcon);
            but[i].setActionCommand(namesBut[i]);
            if (horLine > 270) {
                verLine += step;
                horLine = -25;
            }
        }
        but[getIndexButton(ButtonIndex.BUT_EQUAL)].setBounds(275, 265, sizeIcon, sizeIcon);
        but[getIndexButton(ButtonIndex.BUT_EQUAL)].setActionCommand(Constants.EQUALLY);
    }

    public JTextField getInputOutputField() {
        return inputOutputField;
    }

    public JLabel getDisplayLabel() {
        return display;
    }

}
