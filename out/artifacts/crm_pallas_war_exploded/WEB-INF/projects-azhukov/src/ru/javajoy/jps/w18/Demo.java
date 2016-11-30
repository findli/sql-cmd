package ru.javajoy.jps.w18;

import java.util.ArrayList;
import java.util.List;
/*      Напишите приложение, создающее крупные объекты по мере ввода данных и
        проследите за использованием памяти с помощью jvisualvm.
        Поэкспериментируйте с количеством объектов, ссылки на которые удаляются.
        Как влияет их количество на заполнение сегментов Survivor и Old Generation?

        Если Old Generation будет полностью заполннен, то будет брошено искключени OutOfMemoryError.

        2. Добейтесь заполнения всего пространства heap. Что будет, если продолжить
        создавать объекты?
        3. Запакуйте все классы, созданные на предыдущем занятии в один .jar-архив.*/

/**
 * @author Artem Zhukov
 */
public class Demo {
    private List<int[]> data = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
        demo.load();

    }

    private void load() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            data.add(new int[1024*1024]);
            Thread.sleep(1000);
        }
    }
}
