/**
 * Created by ����� on 15.04.2015.
 */
public class Bubble {

    public static void main(String[] args) {


        int arr[] = {3, 4, 9, 7, 6, 5};

        sort(arr);
        print(arr);
        palindrom("abba");
        palindrom1("rer");
        removeChar("скрока", 'а');
        System.out.println("Равны " + equals());

    }

    public static void sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int y = i + 1; y < arr.length; y++) {
                if (arr[i] > arr[y]) {
                    int t = arr[i];
                    arr[i] = arr[y];
                    arr[y] = t;
                }
            }
        }
    }

    public static void print(int arr[]) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

    private static void palindrom(String str) {
        if (str == null) {
            System.out.println("false");
        }
        StringBuilder stringBuild = new StringBuilder(str);
        stringBuild.reverse();
        System.out.println(stringBuild.toString().equals(str));
    }

    private static boolean palindrom1(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) ;
            return false;
        }
        return true;
    }

    private static String removeChar(String str, char ch) {
        if (str == null) {
            return null;
        }
        System.out.println(str.replaceAll(Character.toString(ch), ""));
        return str.replaceAll(Character.toString(ch), "");
    }

    public static Boolean equals() {
        String str = "hello";
        String str1 = new String("hello");
        return str == str1;
    }
}
