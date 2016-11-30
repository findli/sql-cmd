package ru.javajoy.jps.w1.Массивы;

import java.util.Random;

/**
 * Created by Артем on 19.08.2014.
 */
/*      Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его
        на экран в строку. Определить и вывести на экран сообщение о том, является
        ли массив строго возрастающей последовательностью.*/
public class L1_5 {
    public static void main(String[] args) {
        int[] ar = new int[4];
        Random random = new Random();
        for (int i= 0; i<ar.length; i++){
            ar[i] = (int)(Math.random()*90+10);
            System.out.print(ar[i] + " ");
        }
        System.out.println();
        for (int i = 0; i<ar.length; i++){
            if (i>0){
                if(ar[i-1]>=ar[i]){
                    System.out.println("Не возрастающая последовательность");
                    break;
                }
            }
            if ( i==ar.length-1)
            System.out.println("Строго возрастающая последовательнсть");
        }
    }
}
