package ru.javajoy.jps.w7;

import java.util.Arrays;
import java.util.List;

/**
 * @author Artem Zhukov
 */
public class DemoMatrix {

    public static void main(String[] args) {
        int[][] arrayA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arrayB = {{1, 2}, {4, 5}, {7, 8}};
        Matrix matrixA = new Matrix(arrayA);
        Matrix matrixB = new Matrix(arrayB);

        matrixA.multiply(matrixB);

        System.out.println("Результат умножения матриц");
        List<List<Integer>> innerMatrix = matrixA.getMainMatrix();

        for (List<Integer> anInnerMatrix : innerMatrix) {
            System.out.println(Arrays.toString(anInnerMatrix.toArray()));
        }
    }
}
