package ru.javajoy.jps.w18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артем on 02.02.2015.
 */
public class Main {
    private static List<byte[]> objects = new ArrayList<byte[]>();
    private static boolean cont = true;
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Memory Tool!");

        while (cont) {
            System.out.println(
                    "\n\nI have " + objects.size() + " objects in use, about " +
                            "\nWhat would you like me to do?\n" +
                            "1. Create some objects(20Mb)\n" +
                            "2. Create some objects(2Mb)\n" +
                            "3. Remove some objects\n" +
                            "0. Quit");
            String input = in.readLine();
            if ((input != null) && (input.length() >= 1)) {
                if (input.startsWith("0")) cont = false;
                if (input.startsWith("1")) createObjects();
                if (input.startsWith("2")) createObjectsBytes();
                if (input.startsWith("3")) removeObjects();
            }
        }

        System.out.println("Bye!");
    }

    private static void createObjects() {
        System.out.println("Creating objects...");
        for (int i = 0; i < 2; i++) {
            objects.add(new byte[10*1024*1024]);
        }
    }
    private static void createObjectsBytes() {
        System.out.println("Creating objects...");
        for (int i = 0; i < 2; i++) {
            objects.add(new byte[1024*1024]);
        }
    }

    private static void removeObjects() {
        System.out.println("Removing objects...");
        int start = objects.size() - 1;
        int end = start - 2;
        for (int i = start; ((i >= 0) && (i > end)); i--) {
            objects.remove(i);
        }
    }
}
