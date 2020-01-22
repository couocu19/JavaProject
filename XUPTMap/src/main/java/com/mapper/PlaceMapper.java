package com.mapper;

import com.pojo.Place;

import java.util.List;

public interface PlaceMapper {
    int insPlace(String name, String msg);
    int delete(String name);
    List<Place> selAll(int start, int pageSize);
    List<Place> SelList();
    int selCount();
    Place selByName(String name);
}
