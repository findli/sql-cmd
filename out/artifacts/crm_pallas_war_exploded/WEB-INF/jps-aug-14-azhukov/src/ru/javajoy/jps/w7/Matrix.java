package ru.javajoy.jps.w7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Zhukov
 */
public class Matrix {
    private int rowSize; //AN: корректнее с точки зрения английского назвать rowSize
    private int sizeColumn; //AN: columnSize
    private List<List<Integer>> mainMatrix;

    public List<List<Integer>> getMainMatrix() { //AN: лучше назвать getMatrixView, так как возвращается внутрення реализация матрицы ввиду List<List>
        return mainMatrix;
    }

    public Matrix(int[][] arrayMainMatrix) {
        this.rowSize = arrayMainMatrix.length;
        this.sizeColumn = arrayMainMatrix[0].length;
        this.mainMatrix = new ArrayList<>(this.rowSize);

        for (int i = 0; i < this.rowSize; i++) { //AN: обычно индексы используются сначало i, потом j, k, l, m, n
            this.mainMatrix.add(i, new ArrayList<Integer>(this.sizeColumn));

            for (int j = 0; j < this.sizeColumn; j++) {
                this.mainMatrix.get(i).add(j, arrayMainMatrix[i][j]);
            }
        }
    }

    //Умножение матриц
    public void multiply(Matrix secondMatrix) {
        List<List<Integer>> arrayIml = secondMatrix.getMainMatrix();
        ArrayList<List<Integer>> multiplyMatrix = new ArrayList<>(rowSize); //AN: тип должен быть более абстрактный, например List
        //AN: тип после равно можно не ставить в <> в Java 1.7

        for (int k = 0; k < rowSize; k++) {
            multiplyMatrix.add(k, new ArrayList<Integer>(arrayIml.get(0).size()));
        }

        for (int i = 0; i < rowSize; i++) {
            for (int k = 0; k < arrayIml.get(0).size(); k++) {
               int multiply = 0;
                for (int j = 0; j < sizeColumn; j++) {
                    multiply = multiply + mainMatrix.get(i).get(j) * arrayIml.get(j).get(k);
                }
                multiplyMatrix.get(i).add(k, multiply);
            }
        }

        mainMatrix = multiplyMatrix;
    }

}
