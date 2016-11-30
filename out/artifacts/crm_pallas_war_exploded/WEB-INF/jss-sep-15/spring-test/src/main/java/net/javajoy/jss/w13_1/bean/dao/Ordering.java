package net.javajoy.jss.w13_1.bean.dao;

/**
 * @author Cyril Kadomsky
 */
public class Ordering {

    public enum Type { ASC, DESC }

    private String field;
    private Type type;

    public Ordering() {
    }

    public Ordering(String field, Type type) {
        this.field = field;
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ordering{" +
                "field='" + field + '\'' +
                ", type=" + type +
                '}';
    }
}
