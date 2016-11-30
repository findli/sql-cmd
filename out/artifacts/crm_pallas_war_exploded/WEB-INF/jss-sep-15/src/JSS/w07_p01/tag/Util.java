package JSS.w07_p01.tag;

import java.util.Map;

public class Util {
    public static String map2String(Map map, String entrySeparator, String keyValueSeparator ) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object key : map.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(entrySeparator);
            }
            String value = map.get(key).toString();
            stringBuilder.append((key != null ? key.toString() : "null"));
            stringBuilder.append(keyValueSeparator);
            stringBuilder.append(value != null ? value.toString() : "null");
        }

        return stringBuilder.toString();
    }

    public static String concat(String first, String second) {
        if (first == null || second == null) {
            return first;
        }
        return first+second;
    }
}
