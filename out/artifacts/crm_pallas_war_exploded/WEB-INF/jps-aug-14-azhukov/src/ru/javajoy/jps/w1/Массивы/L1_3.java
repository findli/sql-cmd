package ru.javajoy.jps.w1.Массивы;


import java.util.Random;

/**
 * Created by Артем on 19.08.2014.
 */
/*      Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите
        массив на экран в строку. Замените каждый элемент с нечётным индексом на
        ноль. Снова выведете массив на экран на отдельной строке.*/
public class L1_3 {
    public static void main(String[] args) {
        int[] numb = new int[8];
        Random r = new Random();

        for (int i = 0; i<numb.length; i++){
            numb[i] = r.nextInt(10)+1;
            System.out.print(numb[i] + " ");
        }
        System.out.println();
        for (int i = 0; i <numb.length; i++){
            if (numb[i] % 2 != 0 ){
                numb[i] = 0;
            }
            System.out.print(numb[i] + " ");
        }
    }
}
