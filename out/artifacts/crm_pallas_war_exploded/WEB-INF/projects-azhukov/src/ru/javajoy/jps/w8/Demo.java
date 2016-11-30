package ru.javajoy.jps.w8;

/*
1.      Напишите программу, которая по названию цвета, например
        «crimson», «ametist», «cobalt» выдает его RGB-представление, например «R=255, G
        = 32, B = 64». Цвета и их названия храните в объекте Map. Если введенного цвета
        нет в наборе, то его нужно добавлять.
        Используйте консоль для ручного ввода цветов и вывода результатов
        добавления и поиска цвета. Ввод цвета с именем “all”, должен печатать все
        цвета в алфавитном порядке (какую реализацию Map Вы будете использовать
        для этого?).
*/

import java.awt.*;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Хранение и добавления цветов, а так же  их RGB.
 * <p/>
 * Программа позволяет хранить, добавлять, а так же искать цвета и их RGB в объекте Map. Ввод данных осуществляется с консоли.
 * Команда "all" печатает все цвета в алфавитном порядке.
 *
 * @author Артем
 */
public class Demo {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        Map<String, Object> colorMap = new TreeMap<String, Object>();

        System.out.println("Введите название цвета");
        String color = scanner.next();

        colorMap.put("Blue", Color.BLUE);
        colorMap.put("Black", Color.BLACK);
        colorMap.put("Ametist", new Color(99, 66, 204));
        colorMap.put("Crimson", new Color(220, 20, 60));
        colorMap.put("Orchid", new Color(218, 112, 214));

        while (!color.equals("all")) {
            colorMap.entrySet();
            if (colorMap.containsKey(color)) {
                System.out.println("RGB цвета " + color + "-" + colorMap.get(color));
                System.out.println("Введите название цвета");
                color = scanner.next();
                continue;
            }
            System.out.println("Введите последовательно цвета в формате RGB");
            int r = scanner.nextInt();
            int g = scanner.nextInt();
            int b = scanner.nextInt();

            colorMap.put(color, new Color(r, g, b));

            System.out.println("Введите название цвета");
            color = scanner.next();
        }

        for (Map.Entry<String, Object> mapEntry : colorMap.entrySet()) {
            System.out.println(mapEntry.getKey());
        }
    }
}
