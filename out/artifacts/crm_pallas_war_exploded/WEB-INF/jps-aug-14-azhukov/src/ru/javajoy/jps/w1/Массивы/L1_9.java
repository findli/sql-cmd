package ru.javajoy.jps.w1.Массивы;

/**
 * Created by Артем on 20.08.2014.
 */
/*      Создайте массив из 11 случайных целых чисел из отрезка [-1;1], выведите
        массив на экран в строку. Определите какой элемент встречается в массиве
        чаще всего и выведите об этом сообщение на экран. Если два каких-то
        элемента встречаются одинаковое количество раз, то не выводите ничего.*/
public class L1_9 {
    public static void main(String[] args) {
        int[]   ar = new int[11];
        int minusOne = 0;
        int zero = 0;
        int plusOne = 0;

        for (int i=0; i<ar.length; i++) {
            ar[i] = (int) (Math.random() * 3) - 1;
            System.out.print(ar[i] + " ");
        }
        for (int i=0; i<ar.length; i++){
                if (ar[i]<= -1){
                    minusOne ++;
                }else{
                    if (ar[i]>= 1){
                        plusOne ++;
                }else{
                    zero ++;
                    }
                }
        }
        System.out.println();
        System.out.print("1 элемент: " + minusOne +"; 2 элемент "+ zero + "; 3 элемент " + plusOne);
        System.out.println();
        if(minusOne > zero && minusOne > plusOne){
            System.out.println("1 элемент встречается чаще");
        }else {
        if (plusOne > zero && plusOne >minusOne){
            System.out.println("3 элемент встречается чаще");
        }else{
                if (zero > minusOne && zero >plusOne) {
                System.out.println("2 элемент встречается чаще");
                }
            }
        }
    }
}
