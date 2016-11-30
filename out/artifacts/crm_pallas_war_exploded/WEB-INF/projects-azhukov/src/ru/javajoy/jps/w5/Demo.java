package ru.javajoy.jps.w5;

import java.util.Iterator;

/**
 * Created by Артем on 25.09.2014.
 * <p/>
 * Поиск строк, а также реализация исключений
 * <p/>
 * v.06.10
 */
/*      1. Требуется реализовать поиск строк в тексте по произвольному условию. Создайте
        класс, хранящий массив строк (методы «добавить», «изменить», «удалить»).
        Также создайте вложенный класс-итератор, который проходит по строкам,
        удовлетворяющим заданному условию. Само условие должно задаваться методом
        setCondition( Condition c ), где Condition – абстрактный класс или интерфейс,
            содержащий 1 (абстрактный) метод findByValue() – проверку условия.
        Для вызова метода setCondition() используйте анонимный класс.
        Протестируйте решение с разными условиями поиска.
        2. В задании 1 реализуйте обработку исключений. Генерируйте и обрабатывайте
        исключения «неправильный аргумент», «индекс за пределами массива». Создайте
        также свой класс исключения «условие нельзя проверить», и генерируйте его в методе
        findByValue().*/
public class Demo {

    public static void main(String[] args) throws Exception {

        final StringArray text = new StringArray(5);
        //AZ Добавление строк массива
        text.add("од");
        text.add("два");
        text.add("три");
        System.out.print("Печать массива:   ");
        for (int i = 0; i < text.getSize(); i++) {
            System.out.print(text.get(i) + " | ");
        }
        //AZ Удаление строки массива
        text.remove(2);
        //AZ Добавление строк массива
        text.add("четыре");
        text.add("пять");
        text.change(2, "семь");
        text.add("два");


        System.out.println();
        //AZ Изменения строк в массиве
        System.out.print("Печать массива после изменений:   ");
        for (int i = 0; i < text.getSize(); i++) {
            System.out.print(text.get(i) + " | ");
        }

        System.out.println();

        //AZ Поиск
        System.out.println(text.find("пять"));

        text.setCondition(new Condition() {
            @Override
            public boolean check(String word) {
                return word.equals("два");
            }
        });

        Iterator<String> it = text.iterator();

        int i = 0;
        while (it.hasNext()) {
            System.out.println("Элемент " + i + ": " + it.next());
            i++;
        }

    }
}
