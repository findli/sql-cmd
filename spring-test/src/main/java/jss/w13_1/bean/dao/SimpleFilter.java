package jss.w13_1.bean.dao;

import java.util.Map;

public class SimpleFilter {
    private String field;
    private String value;
    private Map filter;

    public SimpleFilter() {
    }

    public SimpleFilter(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SimpleFilter{" +
                "field='" + field + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
