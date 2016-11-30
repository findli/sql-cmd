package ru.javajoy.jps.w1.Массивы;

/**
 * Created by Артем on 18.08.2014.
 */
/*      Создайте массив из всех нечётных чисел от 3 до 35 и выведите элементы
        массива на экран сначала в строку, отделяя один элемент от другого
        пробелом, а затем в столбик (отделяя один элемент от другого началом новой
        строки). Перед созданием массива подумайте, какого он будет размера.*/
public class L1_1 {
    public static void main(String[] args) {
        int[] ar = new int[17];
        int sum = 1;
        for (int i = 0; i <= 16; i++) {
            sum += 2;
            ar[i] = sum;
            System.out.print(ar[i] + " ");
        }
        System.out.println();
        for (int a : ar)
            System.out.println(a);
    }
}

