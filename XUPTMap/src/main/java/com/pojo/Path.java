package com.pojo;

public class Path {
    private int id;
    private String start;
    private String end;
    private int length;

    @Override
    public String toString() {
        return "Path{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", length=" + length +
                '}';
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Path() {
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Path(String start, String end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
}
