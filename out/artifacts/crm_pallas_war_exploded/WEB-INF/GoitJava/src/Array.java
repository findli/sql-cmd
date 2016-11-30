import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Artem on 10.11.2016.
 */
public class Array {

    public static void main(String[] args) {
        ArrayList<String> elements = new ArrayList<>();

        String[] array = {"element1", "element2", "element3"};
        System.out.println("Size before add =" + elements.size());
        Collections.addAll(elements, array);

        for (String elem : elements) {
            System.out.println(elem);
        }
        System.out.println("Size after add  elements = " + " " + elements.size());
        if (elements.isEmpty()) {
            System.err.println("list empty...");
        } else {
            System.out.println("Elements add successful ");
        }
    }
}

