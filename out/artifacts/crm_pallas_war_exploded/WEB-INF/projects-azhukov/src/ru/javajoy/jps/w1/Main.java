package ru.javajoy.jps.w1;

/**
 * Created by Артем on 18.08.2014.
 */

//        1.Вычислить сумму от 1 до 100.
//        2.В ходе вычисления выводить промежуточную сумму каждые 10 элементов , сохранить сумму в массив.
//        3.Упорядочить массив промежуточных сумм по убыванию и вывести на консоль.

public class Main {
    public static void main(String[] args) {

        int[] ar = new int[10];
        int sum = 0;
        int count = 0;
        int sum1 = 0;

        for (int i = 1; i <= 100; i++) {
            sum += i;
            if (i % 10 == 0) {
                System.out.println(sum);
                ar[count] = sum;
                count++;
                sum1 +=sum;
                sum = 0;
            }
        }
        System.out.println("Общая сумма " + sum1);
        for (int j = ar.length; j > 0; j--)
        System.out.println(ar[j-1]);
        }
    }