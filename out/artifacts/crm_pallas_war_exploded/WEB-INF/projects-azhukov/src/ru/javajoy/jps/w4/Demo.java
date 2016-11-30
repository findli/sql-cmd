package ru.javajoy.jps.w4;

/**
 * Created by Артем on 15.09.2014.
 * <p/>
 * Сложение, умножение матриц
 * <p/>
 * v 1.2
 */
public class Demo {
    public static void main(String[] args) {

        MatrixImpl m1 = new MatrixImpl();
        MatrixImpl m2 = new MatrixImpl();
        Immutable m3 = new Immutable();
        Immutable m4 = new Immutable();

        m1.generate(3);
        System.out.println("Матрица 1:");
        m1.print();
        System.out.println();
        m2.generate(3);
        System.out.println("Матрица 2:");
        m2.print();
        System.out.println();
        Matrix resultAdd = m1.add(m2);
        System.out.println("Результат сложения матриц:");
        MatrixImpl.print(resultAdd);
        System.out.println();
        System.out.println("Сложение неизменного класса");


        m3.generate(3);
        System.out.println("Матрица 1:");
        m3.print();
        System.out.println();
        m4.generate(3);
        System.out.println("Матрица 2:");
        m4.print();
        System.out.println();
        Matrix resultAddIm = m3.add(m4);
        System.out.println("Результат сложения матриц:");
        MatrixImpl.print(resultAddIm);


        System.out.println("~~~~~~~~~~");
        m1.generateMulty(2);
        System.out.println("Матрица 1:");
        m1.print();
        System.out.println();
        m2.generateMulty(3);
        System.out.println("Матрица 2:");
        m2.print();
        System.out.println();
        Matrix resultMultiply = m1.multiply(m2);
        System.out.println("Результат умножения матриц:");
        MatrixImpl.print(resultMultiply);
        System.out.println();

        System.out.println("Умножение неизменного класса");
        m3.generateMulty(2);
        System.out.println("Матрица 1:");
        m3.print();
        System.out.println();
        m4.generateMulty(3);
        System.out.println("Матрица 2:");
        m4.print();
        System.out.println();
        Matrix resultMultiplyIm = m3.multiply(m4);
        System.out.println("Результат умножения матриц:");
        MatrixImpl.print(resultMultiplyIm);


    }
}
