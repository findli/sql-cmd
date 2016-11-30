package ru.javajoy.jps.w3;

/**
 * Created by Артем on 06.09.2014.
 * <p/>
 * <p/>
 * 1   В	классе	«Время»	переопределите	методы	toString(),	equals(),	getSettings().
 * 2.	Создайте	производный	класс,	в	котором:
 * -	добавьте	метод	определения	времени	дня	(результат	–	экземпляр	перечисления
 * «утро»,	«день»,	«вечер»,	«ночь»	);
 * -	переопределите	метод	toString()	для	вывода	времени	в	текстовом	виде,	например
 * «десять	часов	:	двадцать	пять	минут»	вместо	«10:25:00».
 * 3.	В	перечислении	(«утро»,	«день»,	«вечер»,	«ночь»)	сохраните	время	начала	и
 * конца	каждого	периода.	Реализуйте	конструктор	и	методы	в	этом
 * перечислении.
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Time time = new Time(18, 1, 2);
        Time time1 = new Time(19, 03, 4);
        ChildTime childTime = new ChildTime(20, 5, 6);
        Time tClone;

        //Печать времени
        System.out.print("Время: ");
        if (time.getHour() <= 9) {
            System.out.println("0" + time.getHour() + ":");
        } else {
            System.out.print(time.getHour() + ":");
        }
        if (time.getMinute() <= 9) {
            System.out.print("0" + time.getMinute() + ":");
        } else {
            System.out.print(time.getMinute() + ":");
        }
        if (time.getSecond() <= 9) {
            System.out.print("0" + time.getSecond());
        } else {
            System.out.print(time.getSecond());
        }

        System.out.println();

        System.out.print("Время: ");
        if (time1.getHour() <= 9) {
            System.out.println("0" + time1.getHour() + ":");
        } else {
            System.out.print(time1.getHour() + ":");
        }
        if (time1.getMinute() <= 9) {
            System.out.print("0" + time1.getMinute() + ":");
        } else {
            System.out.print(time1.getMinute() + ":");
        }
        if (time1.getSecond() <= 9) {
            System.out.print("0" + time1.getSecond());
        } else {
            System.out.print(time1.getSecond());
        }

        System.out.println();

        System.out.print("Время: ");
        if (childTime.getHour() <= 9) {
            System.out.println("0" + childTime.getHour() + ":");
        } else {
            System.out.print(childTime.getHour() + ":");
        }
        if (childTime.getMinute() <= 9) {
            System.out.print("0" + childTime.getMinute() + ":");
        } else {
            System.out.print(childTime.getMinute() + ":");
        }
        if (childTime.getSecond() <= 9) {
            System.out.print("0" + childTime.getSecond());
        } else {
            System.out.print(childTime.getSecond());
        }
        System.out.println();

        System.out.println("Время toString: " + childTime.toString());
        //Время суток
        String strTime = childTime.timeOfDay();
        System.out.println("Время суток: " + strTime);

        tClone = time.clone(); //
        System.out.println("Копия времени: " + tClone);

        System.out.println("Время суток: " + time.whichPeriod(time));
        System.out.println("Проверка на равенство 2х объектов: " + childTime.equals(time1));

        int differentOfTime = time.differenceOfTime(time1);
        System.out.println("Разница во времени, сек.: " + differentOfTime);

    }

}