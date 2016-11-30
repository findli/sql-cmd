package ru.javajoy.jps.w12;

import java.awt.*;
import java.io.*;

public class Game implements Serializable {

    public static final int MAX_COLUMN = 4;
    public static final int MAX_ROW = 4;
    private int[][] model = new int[MAX_COLUMN][MAX_ROW];
    private static String[] newFile;
    private BoardSettings boardSettings = new BoardSettings();

    public Game() throws CloneNotSupportedException {
        createModel();
    }

    public BoardSettings getSettings() {
        return new BoardSettings(boardSettings);
    }

    public void setSettings(BoardSettings bs) {
        boardSettings = new BoardSettings(bs);
    }

    //Создание матрицы для пазла
    public void createModel() {
        for (int i = 0; i < MAX_COLUMN; i++) {
            for (int j = 0; j < MAX_ROW; j++) {
                model[i][j] = -1;
            }
        }
        for (int count = 0; count < MAX_COLUMN * MAX_ROW; count++) {
            int valueI = (int) (Math.random() * MAX_COLUMN);
            int valueJ = (int) (Math.random() * MAX_ROW);
            if (model[valueI][valueJ] >= 0) {
                count--;
                continue;
            }
            model[valueI][valueJ] = count;
        }
    }

    //Изменение матрицы
    public void movePuzzle(int iFirstClick, int jFirstClick, int finalI, int finalJ) {
        int numFirst = model[iFirstClick][jFirstClick];
        int numSecond = model[finalI][finalJ];
        model[finalI][finalJ] = numFirst;
        model[iFirstClick][jFirstClick] = numSecond;
    }

    //Проверка окончания игры
    public Boolean checkEndGame() {
        int countPos = 0;
        for (int i = 0; i < getMaxColumn(); i++) {
            for (int j = 0; j < getMaxRow(); j++, countPos++) {
                if (getPuzzleAt(i, j) != countPos) {
                    return false;
                }
            }
        }
        return true;
    }

    //Сохранение в файл
    public void saveToTextFile(String fileName, Color colorBorder, Color colorBackground) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(fileName)))) {
            for (int i = 0; i < getMaxColumn(); i++) {
                for (int j = 0; j < getMaxRow(); j++) {
                    printWriter.print(getPuzzleAt(i, j));
                    printWriter.print(" ");
                }
            }
            printWriter.print(colorBorder.getRGB());
            printWriter.print(" ");
            printWriter.print(boardSettings.getColorBackground().getRGB());
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Открытие из файла
    public String[] getInput(String fileName) throws IOException, ClassNotFoundException {
        String[] tempArray;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }
            tempArray = stringBuilder.toString().split(" ");
            bufferedReader.close();
        }
        return tempArray;
    }


    public void openFromFile() {
        int count = 0;
        if (newFile != null) {
            for (int i = 0; i < getMaxColumn(); i++) {
                for (int j = 0; j < getMaxRow(); j++, count++) {
                    setPuzzleAt(i, j, Integer.parseInt(newFile[count]));
                }
            }
            String colorString;
            colorString = newFile[16];
            Color color;
            color = new Color(Integer.parseInt(colorString));
            boardSettings.setColorBorder(color);
            colorString = newFile[17];
            color = new Color(Integer.parseInt(colorString));
            boardSettings.setColorBackground(color);
            Board.panelForImages.setBackground(boardSettings.getColorBackground());
        }
    }


    public static int getMaxColumn() {
        return MAX_COLUMN;
    }

    public static int getMaxRow() {
        return MAX_ROW;
    }

    public int getPuzzleAt(int i, int j) {
        return model[i][j];
    }

    public int setPuzzleAt(int i, int j, int k) {
        return model[i][j] = k;
    }

    public void setNewFile(String[] newFile) {
        Game.newFile = newFile;
    }
}
