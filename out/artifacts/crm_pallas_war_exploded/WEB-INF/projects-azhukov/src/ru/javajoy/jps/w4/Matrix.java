package ru.javajoy.jps.w4;

/**
 * Created by Артем on 16.09.2014.
 */
public interface Matrix {
    Matrix add(Matrix m);

    Matrix multiply(Matrix m);

    int[][] getMatrix();

}
