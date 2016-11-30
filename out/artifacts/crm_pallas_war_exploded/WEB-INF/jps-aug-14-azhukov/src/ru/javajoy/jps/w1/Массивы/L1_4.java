package ru.javajoy.jps.w1.Массивы;

import java.util.Random;

/**
 * Created by Артем on 19.08.2014.
 */
/*      Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый,
        выведите массивы на экран в двух отдельных строках. Посчитайте среднее
        арифметическое элементов каждого массива и сообщите, для какого из
        массивов это значение оказалось больше (либо сообщите, что их средние
        арифметические равны).*/
public class L1_4 {
    public static void main(String[] args) {
        int[] ar1 = new int[5];
        int[] ar2 = new int[5];
        int ar1Sum = 0;
        int ar2Sum = 0;
        Random random = new Random();

        for (int i = 0; i<ar1.length;i++){
            ar1[i] = random.nextInt(5);
            ar1Sum += ar1[i];
            System.out.print(ar1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i<ar2.length;i++) {
            ar2[i] = random.nextInt(5);
            ar2Sum += ar2[i];
            System.out.print(ar2[i] + " ");
        }
        System.out.println();
        System.out.println("Среднее 1го массива: " + ar1Sum/ar1.length);
        System.out.println("Среднее 2го массива: " + ar2Sum/ar2.length);
        if(ar1Sum/ar1.length > ar2Sum/ar2.length) {
            System.out.println("Среднее арифметическое значение 1го массива больше 2го массива.");
        }
        else{
            if (ar2Sum/ar2.length>ar1Sum/ar1.length){
                System.out.println("Среднее арифметическое значение 2го массива больше 1го массива.");
            }
            else{
                System.out.println("Средние арифметические значения массивов равны.");
            }
        }
    }
}
