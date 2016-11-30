package ru.javajoy.jps.w1.Массивы;

import java.util.Random;

/**
 * Created by Артем on 20.08.2014.
 */
/*      Создайте массив из 12 случайных целых чисел из отрезка [-20;20]. Определите
        какой элемент является в этом массиве максимальным и сообщите индекс его
        последнего вхождения в массив.*/
public class L1_7 {
    public static void main(String[] args) {
        int[] ar = new int[12];
        int max = ar[0];
        int j = 0;
        Random random = new Random(); //Лишний

        for (int i = 0; i < ar.length; i++) {
            ar[i] = (int) (Math.random() * 41) - 20;
            System.out.print(ar[i] + " ");
            if (max < ar[i])
                max = ar[i];
        }
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] >= max) {
                max = ar[i];
                j = i;
            }
        }
        System.out.println();
        System.out.print("Max: " + max);
        System.out.println();
        System.out.print("Элемент в массиве " + j);

    }
}

