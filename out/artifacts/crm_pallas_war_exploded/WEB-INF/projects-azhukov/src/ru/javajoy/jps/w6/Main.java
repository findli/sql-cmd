package ru.javajoy.jps.w6;


import java.lang.String;
import java.util.Iterator;
import java.util.List;


/**
 * Данные для классов Vector, ListInt.
 * <p/>
 * Данный класс служит для ввода данных для обработки классами Vector, ListInt
 *
 * @author Артем
 * @version 1.0
 */
/*      1. Создайте интерфейс «Последовательность строк», который поддерживает основные
        операции:
        - поиск элементов по номеру и по значению;
        - добавление и удаление элементов (в произвольной позиции).
            Реализуйте этот интерфейс в классах «Вектор строк» и «Связный список строк».
        2. Реализуйте в этих классах также интерфейс Iterable и продемонстрируйте проход по
        последовательности строк с помощью цикла «foreach».
        3*. Используя класс «Вектор строк», реализуйте класс «Стек строк».
        С помощью класса стека проверьте, правильно ли расставлены скобки в строке.
        4*. В примере «Дерево» реализуйте нерекурсивный поиск в глубину, используя
        реализованный вами класс «Стек».*/

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("=== DEMO ITERATOR ===");
        demoIterator();

        System.out.println();

        System.out.println("=== DEMO ITERATOR LIST ===");
        demoIteratorList();


        Vector objectVector = new Vector();

        objectVector.add("String 10");
        objectVector.add("String 20");
        objectVector.add("String 30");
        objectVector.add("String 40");
        // objectVector.remove("String 20");


        for (int i = 0; i < objectVector.size(); i++) {
            System.out.print(objectVector.get(i) + ", ");
        }

        System.out.println();
        System.out.println("Изменненный массив");
        objectVector.add(1, "String 100");
        for (int i = 0; i < objectVector.size(); i++) {
            System.out.print(objectVector.get(i) + ", ");
        }

        //AZ Поиск значения
        System.out.println();
        String findNumb = objectVector.findByValue("String 10");
        System.out.println("Найдено значение: " + findNumb);
        //AZ Поиск знаения по индексу
        System.out.println();
        String findIndex = objectVector.findByIndex(1);
        System.out.println("Найдено значение по индексу: " + findIndex);
        System.out.println();


        System.out.println();
        System.out.println(objectVector);


        //СПИСОК


        ListInt list = new ListInt();
        list.add("String 1");
        list.add("String 2");
        list.add("String 3");
        list.add("String 4");
        list.add("String 5");
        list.revomeNode(4);
        list.add(2, "String 10");
        ListInt.Node head = list.head;

        System.out.println("Элементы в списке: ");
        while (head != null) {
            System.out.print(head.getValue() + " ");
            head = head.next;
            System.out.println();
        }

        String findList = list.findByValue("String 2");
        System.out.print("Найден элемент в списке: " + findList);
        System.out.println();

        String findIndexList = list.findByIndex(1);
        System.out.println("Найден элемент в списке по индексу: " + findIndexList);
    }


    // ИТЕРАТОРЫ
    private static void demoIterator() {
        Vector collection = new Vector();

        collection.add("String 1");
        collection.add("String 2");
        collection.add("String 3");
        collection.add("String 4");
        collection.add("String 5");

        for (Object obj : collection) {
            System.out.println("Элемент " + obj);
        }

    }

    private static void demoIteratorList() {
        ListInt listCollection = new ListInt();

        listCollection.add("String 1111111111");
        listCollection.add("String 2222222222");
        listCollection.add("String 3333333333");

        for (Object obj : listCollection) {
            System.out.println(obj);
        }
    }
}


