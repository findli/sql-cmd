package ru.javajoy.jps.w2.firsttask;

import java.util.Scanner;

/**
 * Created by Артем on 26.08.2014.
 */

public class Time {

    public static final int SECONDINHOUR = 3600;
    public static final int SECONDINMINUTE = 60;
    public int hour;
    public int minute;
    public int second;
    protected int result;

    public Time() {
        getCheckTime();
        getSecondTotal();
    }


    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        getSecondTotal();
    }

    public Time(Time t) {
        this.hour = t.hour;
        this.minute = t.minute;
        this.second = t.second;
    }

    public static Time createTime(int hour, int minute, int second) {
        return new Time(hour, minute, second);
    }

    public void getTimePrint() {
        Time t = new Time(0, 0, 0);
        System.out.println(hour + ":" + minute + ":" + second);
    }

    public void getSecondTotal() {
        result = hour * SECONDINHOUR + minute * SECONDINMINUTE + second;
    }

    public void getDiff(Time tInput) {
        System.out.println("Разница в секундах между объектами: " + Math.abs(result - tInput.result));
    }

    public void getCheckTime() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите часы: ");
        do
            if (scn.hasNextInt()) {
                hour = scn.nextInt();
                if (hour >= 0 && hour < 24) {
                    break;
                }

                System.out.println("Введите корректные часы, число от 0 до 24");
            } else {
                scn.next();
                System.out.println("Введите корректные часы, число от 0 до 24");
            }
        while (true);
        System.out.print("Введите минуты: ");
        do
            if (scn.hasNextInt()) {
                minute = scn.nextInt();
                if (minute >= 0 && minute <= 60) {
                    break;
                }
                System.out.println("Введите корректные минуты, число от 0 до 60");
            } else {
                scn.next();
                System.out.println("Введите корректные минуты, число от 0 до 60");
            }
        while (true);

        System.out.print("Введите секунды: ");
        do
            if (scn.hasNextInt()) {
                second = scn.nextInt();
                if (second >= 0 && second <= 60) {
                    break;
                }
                System.out.println("Введите корректные секунды, число от 0 до 60");
            } else {
                scn.next();
                System.out.println("Введите корректные секунды, число от 0 до 60");
            }
        while (true);
    }
}



