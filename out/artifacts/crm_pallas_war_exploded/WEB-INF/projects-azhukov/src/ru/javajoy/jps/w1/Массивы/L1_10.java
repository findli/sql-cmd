package ru.javajoy.jps.w1.Массивы;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Артем on 20.08.2014.
 */
/*
        Пользователь должен указать с клавиатуры чётное положительное число, а
        программа должна создать массив указанного размера из случайных целых
        чисел из [-5;5] и вывести его на экран в строку. После этого программа должна
        определить и сообщить пользователю о том, сумма модулей какой половины
        массива больше: левой или правой, либо сообщить, что эти суммы модулей
        равны. Если пользователь введёт неподходящее число, то программа должна
        требовать повторного ввода до тех пор, пока не будет указано корректное
        значение.
        Ввод с клавиатуры можно заменить передачей параметра в метод.*/
public class L1_10 {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int numb = 0;
        int sumLeftHalf = 0;
        int sumRightHalf = 0;
        Random random = new Random();

        if (scn.hasNextInt()) {
            do {
                numb = scn.nextInt();
                if (numb % 2 != 0 || numb < 1)
                    System.out.println("Ошибка!!! Введите чётное положительное число.");
            }
            while (numb % 2 != 0 || numb < 1);
            int[] ar = new int[numb];
            for (int i = 0; i < ar.length; i++) {
                ar[i] = (int) (Math.random() * 11) - 5;
                System.out.print(ar[i] + " ");
                sumRightHalf += ar[i]; //сумма всего массива
            }
            //System.out.println();
            //System.out.println("Len" + ar.length);
            for (int i = 0; i < ar.length / 2; i++) {
                sumLeftHalf += ar[i]; // сумма левой половины массива
            }
            System.out.println();
            sumRightHalf = sumRightHalf - sumLeftHalf; // сумма правой половины массива
            if (sumLeftHalf > sumRightHalf) {
                System.out.println("Левая половина массива больше правой");
            } else {
                if (sumRightHalf > sumLeftHalf) {
                    System.out.println("Правая половина массива больше левой");
                } else {
                    System.out.println("Половины модулей равны");
                }
            }
        }
    }
}


