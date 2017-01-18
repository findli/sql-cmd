package ya.sqlcmd.controller.command.helper;

public class StringCommandParser {

    public static final int NOT_EQUAL_TWO = 1;
    public static final int NOT_EVEN_PARAM_AMOUNT = 2;
    public static final int NOT_EQUAL = 3;

    private static String[] data;
    // just for case NOT_EQUAL
    private static int count;

    private static boolean isCorrect(int checkType, String command) {
        data = command.split("\\|");
        if (checkType == NOT_EQUAL_TWO) {
            if (data.length != 2) {
                return false;
            }
        }
        if (checkType == NOT_EVEN_PARAM_AMOUNT) {
            if (data.length % 2 != 0) {
                return false;
            }
        }
        if (checkType == NOT_EQUAL) {
            if (data.length != count) {
                return false;
            }
        }
        return true;
    }

    public static String[] parse(String input, int checkType) throws IllegalArgumentException {
        if (!isCorrect(checkType, input)) {
            throw new IllegalArgumentException(String.format("Некорректный формат переданной команды: '%s'.", input));
        }
        return data;
    }

    public static String[] parse(String input, int checkType, int parameterAmount) throws IllegalArgumentException {
        count = parameterAmount;
        if (!isCorrect(checkType, input)) {
            throw new IllegalArgumentException(String.format("Некорректный формат переданной команды: '%s'.", input));
        }
        return data;
    }

}
