package ru.javajoy.jps.w9;

/**
 * В классе «Дата», который был написан ранее, реализуйте методы hashCode() и
 * equals().
 * 2.  Задача по выбору:
 * а)  Напишите программу-ежедневник, которая хранит список текстовых записей по
 * каждой дате и позволяет просматривать записи (по заданной дате), добавлять и
 * удалять записи. Для хранения данных используйте Map c ключами вашего класса
 * «Дата».
 */

import java.util.Scanner;

/**
 * @author Artem Zhukov
 */
public final class Demo {

    private static final Scanner scanner = new Scanner(System.in).useDelimiter("\\z*[\n]+");
    private Diary diary;
    private Dialog dialog;

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.diary = new Diary(demo);
        demo.dialog = new Dialog(demo.diary);
        demo.inputCommand();
    }

    public void inputCommand() {
        String str;
        do {
            statusString("Input command add/get/remove. For finish input exit. Time to divide the mark : ");
            str = scanner.next();
            if (!str.equals("exit")) {
               dialog.onNewCommand(str);
            }
        }
        while (!str.equals("exit"));
    }

    public static String getInputLine(){
        return scanner.next();
    }

    public static void statusString(String str) {
        System.out.println(str);
    }

}

