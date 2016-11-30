package ru.javajoy.jps.w4;

/**
 * Created by Артем on 16.09.2014.
 */
public final class Immutable extends MatrixImpl implements Matrix {

    public Immutable(int[][] matrix) {
        super(matrix);
    }

    public Immutable() {

    }

    //Метод складывает массивы
    @Override
    public Matrix add(Matrix m) {
        int[][] result = null;
        if (m instanceof Immutable) {
            result = new int[matrix.length][matrix.length];
            Immutable mInt = (Immutable) m;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    result[i][j] = matrix[i][j] + mInt.getMatrix()[i][j];
                }
            }
        }
        return new Immutable(result);
    }

    //Метод умножает массивы
    @Override
    public Matrix multiply(Matrix m) {
        int[][] result = null;
        if (m instanceof Immutable) {
            result = new int[1][matrix.length + 2];
            Immutable mInt = (Immutable) m;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < mInt.getMatrix()[i].length; j++) {
                    for (int l = 0; l < mInt.getMatrix().length; l++) {
                        result[i][j] += matrix[i][l] * mInt.getMatrix()[l][j];
                    }
                }
            }
        }
        return new Immutable(result);
    }
}

