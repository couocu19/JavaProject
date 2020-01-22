package com.mapper;

import com.pojo.Path;

import java.util.List;

public interface PathMapper {
    List<Path> selPath(String name);
    int insPath(String start, String end, int length);
    int delete(String start, String end);
    List<Path> selAll();
    int delete2(String name);
    List<Path> selByStart(String start);
}
