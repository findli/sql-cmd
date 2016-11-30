package ru.javajoy.jps.w1.Массивы;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Артем on 21.08.2014.
 */

    /*    Пользователь вводит с клавиатуры натуральное число большее 3, которое
        сохраняется в переменную n. Если пользователь ввёл не подходящее число,
        то программа должна просить пользователя повторить ввод. Создать массив
        из n случайных целых чисел из отрезка [0;n] и вывести его на экран. Создать
        второй массив только из чётных элементов первого массива, если они там
        есть, и вывести его на экран.*/
public class L1_12 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n;
        int a;
        /*int Count = 0;*/
        Random random = new Random();
        ArrayList ar2 = new ArrayList();

        if (scn.hasNextInt()){
            do{
                n = scn.nextInt();
                if (n <= 3){
                    System.out.println("Ведите число больше 3х");
                }
            }
            while (n <= 3);
           int[] ar1 = new int[n];
           for (int i =0; i<n;i++){
               ar1[i] = random.nextInt(n+1)+0;
               System.out.print(ar1[i] + " ");
           }
            System.out.println();

/*            for (int i =0;i <ar1.length; i++) {
                if (ar1[i] != 0){
                       if (ar1[i] % 2 == 0) {
                          Count++;
                    }
                }
            }
            System.out.println();
            System.out.println("Count: " + Count);*/
          //  int[] ar2 = new int[Count];
            for (int i = 0; i< ar1.length; i++) {
                if (ar1[i] != 0) {
                    if (ar1[i] % 2 == 0) {
                        a = ar1[i];
                        ar2.add(a);
                    }
                }
            }
            //ar2.remove(0);
            System.out.print(ar2 + " ");
            //System.out.print(ar2.length);
        }
    }
}
