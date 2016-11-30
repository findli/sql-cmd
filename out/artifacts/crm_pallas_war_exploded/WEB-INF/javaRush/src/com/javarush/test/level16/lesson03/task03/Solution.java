package com.javarush.test.level16.lesson03.task03;

//Task doesn't solution

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут

        Thread thread1 = new Thread(new SpecialThread());
        thread1.start();
        list.add(thread1);

        Thread thread2 = new Thread(new SpecialThread());
        thread2.start();
        list.add(thread2);

        Thread thread3 = new Thread(new SpecialThread());
        thread3.start();
        list.add(thread3);


        Thread thread4 = new Thread(new SpecialThread());
        thread4.start();
        list.add(thread4);

        Thread thread5 = new Thread(new SpecialThread());
        thread5.start();
        list.add(thread5);

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
