package ru.javajoy.jps.w2.SecondTask;

import java.util.Scanner;

/**
 * Created by Артем on 29.08.2014.
 */
public class Time {
    public int hour, minute, second, result;


    public Time() {
        ProverkaVremeni();
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void ProverkaVremeni() {
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

    public void SecondTotal() {
        result = (hour * 3600) + (minute * 60) + second;
    }

    public int raznica(Time t) {
        if (result > t.result) {
            return result - t.result;
        } else if (result < t.result) {
            return t.result - result;
        }
        return 0;
    }
}
