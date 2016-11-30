package ru.javajoy.jps.w12;


import javax.swing.*;

/*
1.Реализуйте игру «пазл». В начале игры прямоугольные фрагменты пазла
размещаются на форме произвольным образом. Далее фрагменты можно
выделять и перемещать с помощью мыши.
Для отображения каждого фрагмента используйте JLabel c картинкой.
При выделении у фрагмента должна появляться красная рамка.

2*.Реализуйте «склеивание» подходящих друг к другу фрагментов, если
между ними маленькое расстояние, а также проверку, собран ли пазл
полностью.

3. В игре «пазл» реализуйте пункты меню (со значками и мнемониками ),
панель инструментов и горячие клавиши для действий:
- «новая игра»,
- «выбор цвета фона»,
- «выбор цвета рамки выделения»

4.Реализуйте пункты меню «File - Open»,
«File - Save»и «File – SaveAs», используя . Должно сохраняться состояние
игры (расположение фрагментов) и настройки (цвета фона, рамки и т.п.)

5.В разработанной ранее игре «пазл» реализуйте пункты меню «File - Open»,
«File - Save» и «File – Save As», используя сериализацию и JFileChooser.
*/

/**
 * @author Artem Zhukov
 */
public class Demo extends JFrame {

    public static void main(String[] args) throws CloneNotSupportedException {
        new Demo();
    }

    public Demo() throws CloneNotSupportedException {
        super("Puzzle");
        setSize(620, 465);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        Game game = new Game();
        Board board = new Board(game);

        getContentPane().add(board);
        revalidate();
    }
}
