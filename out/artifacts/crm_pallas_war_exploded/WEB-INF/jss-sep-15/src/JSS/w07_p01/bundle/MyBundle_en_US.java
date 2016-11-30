package JSS.w07_p01.bundle;

import java.util.ListResourceBundle;

/**
 * @author Cyril Kadomsky
 */
public class MyBundle_en_US extends ListResourceBundle {

    static Object[][] resource = new Object[][] {
            {"setLocale.language","Language"},
            {"setLocale.select","Select ..."},
            {"setLocale.en_US","English"},
            {"setLocale.ru_RU","Russian"},
            {"setLocale.apply","Apply"},
            {"localizedPage.date","Date"}
    };


    @Override
    protected Object[][] getContents() {
        return resource;
    }
}
