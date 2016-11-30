package ru.javajoy.jps.w16;

import java.util.Arrays;

/**
 * @author Artem Zhukov
 */
/*Разработайте программу, которая слева отображает список ваших
        знакомых, а справа - список ваших лучших друзей (каждый человек может быть
        только в одном из списков). Реализуйте перемещение записей между этими
        двумя списками. Для перемещения необходимо выделить записи в одном
        списке и нажать кнопку «-->» (переместить вправо) или кнопку «<--»
        (переместить влево):

        С помощью сериализации реализуйте сохранение результатов работы
программы в файл и загрузку из файла.*/

public class Main {

    //Driver
    public static void main(String[] args) {
        //Model
        PersonCompositeModel personCompositeModel = new PersonCompositeModel(
                Arrays.asList("Андрей", "Алексей", "Артур", "Александр", "Анатолий", "Антон"));
        //View
        MainForm mainForm = new MainForm(personCompositeModel.getFriendListModel(), personCompositeModel.getPersonListModel());

        //Controller
        new MainController(mainForm, personCompositeModel);

        mainForm.display();
    }


}
