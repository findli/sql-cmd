package ru.javajoy.jps.w2.firsttask;

/**
 * Created by Артем on 26.08.2014.
 */
public class TimeUtils {

    public static int Compare(Time t, Time tInput) {
        if (t.result > tInput.result) {
            return 1;
        } else if (t.result < tInput.result) {
            return 2;
        }
        return 0;
    }

}


