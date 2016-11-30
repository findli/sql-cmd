package ru.javajoy.jps.w1.Массивы;
import java.util.Random;
/**
 * Created by Артем on 19.08.2014.
 *//*
        Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите
        массив на экран. Подсчитайте сколько в массиве чётных элементов и
        выведете это количество на экран на отдельной строке.*/
public class L1_2 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] numb = new int[15];
        int totalSum = 0;

        for (int i = 0; i < numb.length; i++) {
            numb[i] = r.nextInt(9);
            System.out.print(numb[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < numb.length; i++) {

            if (numb[i] != 0 && numb[i] % 2 == 0) {
                totalSum ++;
            }
        }
        System.out.print("Количество чётных элементов составляет: " + totalSum);
    }
}
