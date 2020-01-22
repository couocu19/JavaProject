package com.pojo;

import java.util.List;

public class PageInfo {
    private int pageNum;
    private int pageSize;
    private List list;
    private int pageSum;

    public PageInfo() {
    }

    public PageInfo(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageStart=" + pageNum +
                ", pageSize=" + pageSize +
                ", list=" + list +
                ", pageSum=" + pageSum +
                '}';
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageInfo(int pageStart, int pageSize, List list, int pageSum) {
        this.pageNum = pageStart;
        this.pageSize = pageSize;
        this.list = list;
        this.pageSum = pageSum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageStart(int pageStart) {
        this.pageNum = pageStart;
    }



    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getPageSum() {
        return pageSum;
    }

    public void setPageSum(int pageSum) {
        this.pageSum = pageSum;
    }

}
