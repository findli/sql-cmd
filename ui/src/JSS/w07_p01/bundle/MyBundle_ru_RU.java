package JSS.w07_p01.bundle;

import java.util.ListResourceBundle;

public class MyBundle_ru_RU extends ListResourceBundle {
    static Object[][] resource=new Object[][]{
            {"seLocale.language", "Язык"},
            {"seLocale.select", "Выберете"},
            {"seLocale.en_US", "Английский"},
            {"seLocale.ru_RU", "Русский"},
            {"seLocale.apply", "Применить"},
            {"localizedPage.date", "Дата"}
    };
    @Override
    protected Object[][] getContents() {
        return resource;
    }
}
