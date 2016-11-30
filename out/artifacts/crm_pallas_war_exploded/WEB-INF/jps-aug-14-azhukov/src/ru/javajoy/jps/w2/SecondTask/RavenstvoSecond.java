package ru.javajoy.jps.w2.SecondTask;

/**
 * Created by Артем on 29.08.2014.
 */
public class RavenstvoSecond {


    public static int CompareSecond(Time t, Time t2) {
        if (t.result > t2.result) {
            return 1;
        } else if (t.result < t2.result) {
            return 2;
        }
        return 0;
    }
}
