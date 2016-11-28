package JSS.w07_p01.tag;

import java.lang.reflect.Type;
import java.util.Map;

public class Util {
    public static String map2String(Map map, String entrySeparator, String keyValueSeparator) {
        StringBuilder stringBuilder = new StringBuilder();
        /*for (Object key : map.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(entrySeparator);
            }
//            String value = map.get(key).toString();
            String value = map.get(key);
            stringBuilder.append(key != null ? key.toString() : "null");
            stringBuilder.append(keyValueSeparator);
            stringBuilder.append(value != null ? value.toString() : "null");
            stringBuilder.append(" null ");
        }*/
        return stringBuilder.toString();
//        return "map2String called";
    }

    public static String concat(String first, String second) {
        if (first == null || second == null) {
            return first;
        }
        return first + second;
    }
}
