package com.shan.admin.utils;

/**
 * @Author: chenjunshan
 * @Date: 19-5-30 上午11:26
 */
public class FiledBean {
    private String name;
    private Object value;
    private String type;

    public FiledBean(String name, Object value, String type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FiledBean{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", type='" + type + '\'' +
                '}';
    }
}
