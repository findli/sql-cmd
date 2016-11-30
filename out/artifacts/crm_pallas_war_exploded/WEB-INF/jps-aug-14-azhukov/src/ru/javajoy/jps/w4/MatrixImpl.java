package ru.javajoy.jps.w4;


/**
 * Created by Артем on 15.09.2014.
 */
public class MatrixImpl implements Matrix {

    protected int[][] matrix;

    public MatrixImpl() {
    }

    public MatrixImpl(int[][] matrix) {
        this.matrix = matrix;
    }

    //Метод выводит массив на печать
    public static void print(Matrix matrix) {
        int[][] array = matrix.getMatrix();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void print() {
        print(this);

    }

    // Метод генерирует массив для сложения
    public void generate(int size) {
        matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) Math.round(Math.random() * 10);
            }
        }
    }

    // Метод генерирует массив для умножения
    public void generateMulty(int size) {
        matrix = new int[size - 1][size];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) Math.round(Math.random() * 10);
            }
        }
    }

    //Метод складывает массивы
    @Override
    public Matrix add(Matrix m) {
        int[][] result = null;
        if (m instanceof MatrixImpl) {
            result = new int[matrix.length][matrix.length];
            MatrixImpl mInt = (MatrixImpl) m;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    result[i][j] = matrix[i][j] + mInt.getMatrix()[i][j];
                }
            }
        }
        return new MatrixImpl(result);
    }

    //Метод умножает массивы
    @Override
    public Matrix multiply(Matrix m) {
        int[][] result = null;
        if (m instanceof MatrixImpl) {
            result = new int[1][matrix.length + 2];
            MatrixImpl mInt = (MatrixImpl) m;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < mInt.getMatrix()[i].length; j++) {
                    for (int l = 0; l < mInt.getMatrix().length; l++) {
                        result[i][j] += matrix[i][l] * mInt.getMatrix()[l][j];
                    }
                }
            }
        }
        return new MatrixImpl(result);
    }


    public int[][] getMatrix() {
        return matrix;
    }
}