package jss.w13_1.bean.dao;

public class Ordering {

    private String field;
    private Type type;

    public Ordering() {
    }

    public Ordering(String field, Type type) {
        this.field = field;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ordering{" +
                "field='" + field + '\'' +
                ", type=" + type +
                '}';
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public enum Type {ASC, DESC}
}
