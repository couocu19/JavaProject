package com.pojo;

public class Place {
    private String name;
    private String msg;

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Place(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public Place() {
    }
}
