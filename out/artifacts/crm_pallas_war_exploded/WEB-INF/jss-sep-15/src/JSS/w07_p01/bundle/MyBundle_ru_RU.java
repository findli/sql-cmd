package JSS.w07_p01.bundle;

import java.util.ListResourceBundle;

/**
 * @author Cyril Kadomsky
 */
public class MyBundle_ru_RU extends ListResourceBundle {

    static Object[][] resource = new Object[][] {
            {"setLocale.language","Язык"},
            {"setLocale.select","Выберите ..."},
            {"setLocale.en_US","Английский"},
            {"setLocale.ru_RU","Русский"},
            {"setLocale.apply","Применить"},
            {"localizedPage.date","Дата"}
    };


    @Override
    protected Object[][] getContents() {
        return resource;
    }
}
