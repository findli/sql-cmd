package ru.javajoy.jps.w18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*        Напишите приложение, создающее крупные объекты по мере ввода данных и
        проследите за использованием памяти с помощью jvisualvm.
        Поэкспериментируйте с количеством объектов, ссылки на которые удаляются.
        Как влияет их количество на заполнение сегментов Survivor и Old Generation?

        2. Добейтесь заполнения всего пространства heap. Что будет, если продолжить
        создавать объекты?
        3. Запакуйте все классы, созданные на предыдущем занятии в один .jar-архив.*/
/**
 * @author Artem Zhukov
 */
public class App {
    public static final int BYTE_MULTIPLIER = 100;
    public static final int POPULATION_STEP = 2;

    private static List<byte[]> objects = new ArrayList<byte[]>();
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Memory Tool!");
        boolean cont = true;

        while (cont) {
            System.out.printf(
                    "%n%nI have %d objects in use, about %d MB.%n" +
                            "What would you like me to do?%n" +
                            "1. Create some objects%n" +
                            "2. Remove some objects%n" +
                            "0. Quit%n",
                    objects.size(), objects.size() * BYTE_MULTIPLIER);

            String input = in.readLine();

            if ((input != null) && (input.length() >= 1)) {
                if (input.startsWith("0")) cont = false;
                if (input.startsWith("1")) createObjects();
                if (input.startsWith("2")) removeObjects();
            }
        }

        System.out.println("Bye!");
    }

    private static void createObjects() {
        System.out.println("Creating objects...");

        for (int i = 0; i < POPULATION_STEP; i++) {
            objects.add(new byte[BYTE_MULTIPLIER * 1024 * 1024]);
        }
    }

    private static void removeObjects() {
        System.out.println("Removing objects...");
        int start = objects.size() - 1;
        int end = start - POPULATION_STEP;

        for (int i = start; ((i >= 0) && (i > end)); i--) {
            objects.remove(i);
        }
    }
}
