package ru.javajoy.jps.w15.util;

/**
 * Class contains util methods for strings processing
 *
 * @author Artem Zhukov
 */
public class StringUtils {

    /**
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.equals("");
    }
}
