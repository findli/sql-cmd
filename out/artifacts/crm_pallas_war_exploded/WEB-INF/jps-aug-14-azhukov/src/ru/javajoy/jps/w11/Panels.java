package ru.javajoy.jps.w11;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Игра "Реверс"
 * <p/>
 * Цель игры закрасить все ячейки в один цвет нажимая на ячейки. При нажатия на ячейку, ячейки в горизонтальной и
 * вертикальной линиях меняют цвет. В игре реализован подсчет количества ячеек каждого цвета, возможность выбора
 * цвета ячеек, оповещение об окончании игры.
 *
 * @author Артем
 */
public class Panels extends JPanel implements ActionListener {

    private static final String COLOR_1_IS = "Color 1 is: ";
    private static final String COLOR_2_IS = "Color 2 is: ";
    private static final int SIZE_THREE = 3;
    private static final int SIZE_FIVE = 5;
    private final JRadioButton boardSize3x3;
    private final JRadioButton boardSize5x5;
    private final JRadioButton colorPair1;
    private final JRadioButton colorPair2;
    private final JRadioButton colorPair3;
    private final JRadioButton colorPair4;

    private Color color1 = Color.BLUE;
    private Color color2 = Color.WHITE;

    private int row = SIZE_FIVE;
    private int column = SIZE_FIVE;

    private JButton[][] buttons = new JButton[row][column];
    private int model[][] = new int[row][column];
    private JPanel buttonPanel = new JPanel();
    /* todo: ? */ final JLabel statusLabel = new JLabel("------------------");
    private JLabel labelColor1 = new JLabel(COLOR_1_IS + cellsOfColor1(COLOR_1_IS));
    private JLabel labelColor2 = new JLabel(COLOR_2_IS + cellsOfColor1(COLOR_2_IS));

    public Panels() {

        JPanel infoPanel = new JPanel();
        setLayout(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setPreferredSize(new Dimension(150, 420));
        JPanel colorPanel2 = new JPanel();
        JPanel colorPanel1 = new JPanel();
        colorPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        colorPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        createModel();

        final JLabel statusLabel1 = new JLabel("------------------");
        final JLabel selectColor = new JLabel("Choose of colors");
        final JLabel selectBoard = new JLabel("Choose size of board");
        add(infoPanel, BorderLayout.NORTH);

        colorPair1 = new JRadioButton("Classic  ");
        colorPair2 = new JRadioButton("Shakhtar");
        colorPair3 = new JRadioButton("Adidas   ");
        colorPair4 = new JRadioButton("Yana's c colors");
        colorPair1.setSelected(true);
        boardSize3x3 = new JRadioButton("    3 x 3    ");
        boardSize5x5 = new JRadioButton("    5 x 5    ");
        boardSize5x5.setSelected(true);

        ActionListener pairsColors = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (colorPair1.isSelected()) {
                    color1 = Color.BLUE;
                    color2 = Color.WHITE;
                }
                if (colorPair2.isSelected()) {
                    color1 = Color.BLACK;
                    color2 = new Color(255, 140, 0);
                }
                if (colorPair3.isSelected()) {
                    color1 = Color.GRAY;
                    color2 = new Color(255, 0, 102);
                }
                if (colorPair4.isSelected()) {
                    color1 = new Color(68, 181, 3);
                    color2 = Color.WHITE;
                }
                changeColors();
            }
        };
        colorPair1.addActionListener(pairsColors);
        colorPair2.addActionListener(pairsColors);
        colorPair3.addActionListener(pairsColors);
        colorPair4.addActionListener(pairsColors);

        JButton button = new JButton("    Ok    ");
        button.addActionListener(this);

        ButtonGroup groupOfColors = new ButtonGroup();
        ButtonGroup groupOfSize = new ButtonGroup();
        groupOfColors.add(colorPair1);
        groupOfColors.add(colorPair2);
        groupOfColors.add(colorPair3);
        groupOfColors.add(colorPair4);
        groupOfSize.add(boardSize3x3);
        groupOfSize.add(boardSize5x5);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setPreferredSize(new Dimension(340, 420));
        createButtons(buttonPanel);
        changeColorsBut();
        cellsOfColor1(COLOR_1_IS);

        colorPanel1.add(labelColor1);
        colorPanel2.add(labelColor2);
        infoPanel.add(colorPanel1);
        infoPanel.add(colorPanel2);
        infoPanel.add(statusLabel);
        infoPanel.add(selectColor);
        infoPanel.add(colorPair1);
        infoPanel.add(colorPair2);
        infoPanel.add(colorPair3);
        infoPanel.add(colorPair4);
        infoPanel.add(statusLabel1);
        infoPanel.add(selectBoard);
        infoPanel.add(boardSize3x3);
        infoPanel.add(boardSize5x5);
        infoPanel.add(button);
        add(buttonPanel);

        infoPanel.setVisible(true);
        setVisible(true);
    }

    //Создание матрицы для окрашивания, по умолчанию размер поля 5х5
    private void createModel() {

        int[][] resMas = new int[row][column];
        int count;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                model[i][j] = 0;
            }
        }
        for (count = 0; count < (totalCell() - 1) / 2; count++) {
            int valueI = (int) (Math.random() * column);
            int valueJ = (int) (Math.random() * row);
            resMas[valueI][valueJ] = 1;
            if (model[valueI][valueJ] == resMas[valueI][valueJ]) {
                count--;
                continue;
            }
            model[valueI][valueJ] = resMas[valueI][valueJ];
            labelColor1.setText(COLOR_1_IS + cellsOfColor1(COLOR_1_IS));
            labelColor2.setText(COLOR_2_IS + cellsOfColor1(COLOR_2_IS));
        }
    }

    //Метод меняет модель в соответствии с правилами игры и цвета ячеек после каждого клика
    private void changeColors(int i, int j) {
        if (model[i][j] == 1) {
            model[i][j] = 0;
        } else if (model[i][j] == 0) {
            model[i][j] = 1;
        }
        changeColors();
    }

    //Считает количество ячеек одного цвета
    private int cellsOfColor1(String numColor) {
        int clr = 0;
        for (int x = 0; x < column; x++) {
            for (int y = 0; y < row; y++) {
                if (numColor.equals(COLOR_1_IS)) {
                    if (model[x][y] == 0) {
                        clr++;
                    }
                } else {
                    if (model[x][y] == 1) {
                        clr++;
                    }
                }
            }
        }
        return clr;
    }

    //Создание кнопок
    private void createButtons(JPanel buttonPanel) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                buttons[i][j] = new JButton("");
                buttonPanel.add(buttons[i][j]);
            }
        }
        buttonPanel.setLayout(new GridLayout(row, column));
        changeColors();
    }

    //Выбор размера поля
    @Override
    public void actionPerformed(ActionEvent e) {
        if (boardSize3x3.isSelected()) {
            createBoard(SIZE_THREE);
        }
        if (boardSize5x5.isSelected()) {
            createBoard(SIZE_FIVE);
        }
        changeColorsBut();
    }

    private void createBoard(int size) {
        setRow(size);
        setColumn(size);
        totalCell();
        model = new int[row][column];
        buttons = new JButton[row][column];
        createModel();
        buttonPanel.removeAll();
        buttonPanel.revalidate();
        createButtons(buttonPanel);
    }

    //Меняет цвет кнопок в горизонтальной и вертикальной линиях на противоположный
    private void changeColorsBut() {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                final int finalJ = j;
                final int finalI = i;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < column; i++) {
                            changeColors(i, finalJ);
                        }
                        if (finalJ == 0) {
                            for (int j = finalJ + 1; j < row; j++) {
                                changeColors(finalI, j);
                            }
                        } else {
                            for (int j = 0; j < finalJ; j++) {
                                changeColors(finalI, j);
                            }
                            for (int j = finalJ + 1; j < row; j++) {
                                changeColors(finalI, j);
                            }
                        }
                        labelColor1.setText("Color 1 is: " + cellsOfColor1(COLOR_1_IS));
                        labelColor2.setText("Color 2 is: " + cellsOfColor1(COLOR_2_IS));
                        if (cellsOfColor1(COLOR_1_IS) == 0 || cellsOfColor1(COLOR_2_IS) == 0) {
                            statusLabel.setForeground(Color.GREEN);
                            statusLabel.setText("End of the game");
                        }
                    }
                });
            }
        }
    }

    //Меняет цвета ячеек после каждого клика
    private void changeColors() {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (model[i][j] == 1) {
                    buttons[i][j].setBackground(color1);
                }
                if (model[i][j] == 0) {
                    buttons[i][j].setBackground(color2);
                }
            }
        }
    }

    //Общее количество ячеек
    private int totalCell() {
        return row * column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
