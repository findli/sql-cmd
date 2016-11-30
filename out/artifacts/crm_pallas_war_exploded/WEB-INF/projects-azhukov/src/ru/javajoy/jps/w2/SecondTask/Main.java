package ru.javajoy.jps.w2.SecondTask;

/**
 * Created by Артем on 29.08.2014.
 */
/*
Создать	два	объекта	«время»	заполнив	их	значениями	из	консоли,	используя
        разные	способы	создания	экземпляра	объекта.	Вывести	результаты
        сравнения	двух	объектов	на	консоль	(кто	больше	из	них,	разница	в	секундах)*/

public class Main {
    public static void main(String[] args) {
        Time t = new Time();
        Time t2 = new Time(12, 37, 45);

        t.SecondTotal();
        t2.SecondTotal();

        int CompareSecondResult = RavenstvoSecond.CompareSecond(t, t2);
        System.out.println("Больше объект: " + CompareSecondResult);

        int raznica = t.raznica(t2);
        System.out.println("Разница в секундах между объектами: " + raznica);




    }
}
