package JSS.w07_p01.beans;

import java.io.Serializable;

public class SimpleBean implements Serializable {
    public SimpleBean() {}
    public int[] getIntArray() {
        int[] arr = new int[10];
        for(int i=0; i<10; i++) {
            arr[i]=i;
        }
        return arr;
    }
    public String getStringValue() {
        return "sample string";
    }
}
