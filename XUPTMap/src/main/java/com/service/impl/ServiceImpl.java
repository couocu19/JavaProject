package com.service.impl;

import com.mapper.PathMapper;
import com.mapper.PlaceMapper;
import com.pojo.PageInfo;
import com.pojo.Path;
import com.pojo.Place;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceImpl {
    private PathMapper pathMapper;
    private PlaceMapper placeMapper;
    node[] map;
    Map<String, Integer> index;
    int shortPath;
    int lowPath;
    int k = 0;
    int minStep = 32767;
    int minSum = 32767;
    List arrayList = new ArrayList();
    List<List<String>> main = new ArrayList<>();
    List<String> main2 = new ArrayList<>();
    public Map query(String start, String end)
    {
        Map result = new HashMap();
        int size = placeMapper.selCount();
        index = new HashMap();
        map = new node[size];
        List<Place> places = placeMapper.SelList();
        int i = 0;
        for (Place place : places) {
            map[i] = new node();
            map[i].placeName = place.getName();
            index.put(place.getName(), i);
            i++;
        }
        for(int j = 0 ; j < size; j++)
        {
            String place = map[j].placeName;
            node temp = map[j];
            node prev = map[j];
            List<Path> paths = pathMapper.selPath(place);
            for (Path path : paths) {
//                System.out.println(path.getEnd()+ path.getStart());
                    if(path.getStart().equals(place))
                    {
                        temp = new node(path.getEnd(), path.getLength());
                        temp.setNext(null);
                        prev.setNext(temp);
                        prev = temp;
                    }
                    if(path.getEnd().equals(place))
                    {
                        temp = new node(path.getStart(), path.getLength());
                        temp.setNext(null);
                        prev.setNext(temp);
                        prev = temp;
                    }
            }
        }
        dfs(start, end, 0, 0);
        StringBuilder  sp = new StringBuilder("");
        for (String s : main.get(shortPath)) {
            sp.append(s + "  ");
        }
        StringBuilder lp = new StringBuilder("");
        for (String s : main.get(lowPath) ) {
            lp.append(s + "  ");
        }
        for (List<String> strings : main) {
            StringBuilder sb = new StringBuilder("");
            for (String string : strings) {
                sb.append(string);
            }
            main2.add(sb.toString());
        }

        result.put("shortPath", sp);
        result.put("lowPath", lp);
        result.put("minSum", minSum);
        result.put("main2", main2);
        //        node temp;
//        for (node node : map) {
//            temp = node;
//            while (temp != null)
//            {
//                System.out.print(temp.getPlaceName() + temp.getLength());
//                temp = temp.next;
//            }
//            System.out.println();
//        }
//        return;
//
//        System.out.println(shortPath + " " + minSum);
//        System.out.println(lowPath +" " +minStep);

//            while (temp != null)
//            {
//                System.out.print(temp.getPlaceName() + temp.getLength());
//                temp = temp.next;
//            }
//            System.out.println();
//        }
        return result;
    }

    public void dfs(String name, String end, int step, int sum)
    {

        node temp;
        Integer i = index.get(name);
        if(i == null)
            return;
        if(map[i].step == true)
            return;
        step++;
        map[i].step = true;
        if(map[i].placeName.equals(end)) {
            if (step < minStep) {
                minStep = step;
                lowPath = k;
            }
            if (sum < minSum) {
                minSum = sum;
                shortPath = k;
            }
        }
        arrayList.add(name);
        List<String> t = new ArrayList();
        for(int m = 0; m < arrayList.size(); m++)
        {
            t.add((String) arrayList.get(m));
        }
        main.add(k++, t);
        temp = map[i].next;
        while (temp != null)
        {
            dfs(temp.placeName, end, step, sum + temp.getLength());
            temp = temp.next;
        }
        map[i].step = false;
        arrayList.remove(name);
    }

    class node{
        String placeName;
        int length;
        boolean step;
        node next;

        public node() {
        }

        public String getPlaceName() {
            return placeName;
        }

        public void setPlaceName(String placeName) {
            this.placeName = placeName;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public boolean isStep() {
            return step;
        }

        public void setStep(boolean step) {
            this.step = step;
        }

        public node getNext() {
            return next;
        }

        public void setNext(node next) {
            this.next = next;
        }

        public node(String placeName, int length){
                this.placeName = placeName;
                this.length = length;
        }
    }
    public int insPlace(String name, String msg)
    {
        return placeMapper.insPlace(name, msg);
    }

    public int insPath(String start, String end, int length)
    {
        return pathMapper.insPath(start, end, length);
    }
    public int delPath(String start, String end)
    {

        return pathMapper.delete(start, end);
    }
    public int delPlace(String name)
    {
        pathMapper.delete2(name);
        return placeMapper.delete(name);
    }
    public PageInfo showPlace(int pageNum)
    {
        int pageSize = 10;
        PageInfo pageInfo = new PageInfo(pageNum, pageSize);
        int count = placeMapper.selCount();
        pageInfo.setPageSum(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
        pageInfo.setList(placeMapper.selAll((pageNum-1) * pageSize, pageSize));
        return pageInfo;
    }

    public List selList()
    {
        return placeMapper.SelList();
    }
    public List showPath(String name)
    {
        List<Path> paths = pathMapper.selByStart(name);
        return paths;
    }

    public Place showPlaceByName(String name)
    {
        return placeMapper.selByName(name);
    }

    public List showPathByStart(String start)
    {
        return pathMapper.selByStart(start);
    }
    public PathMapper getPathMapper() {
        return pathMapper;
    }

    public void setPathMapper(PathMapper pathMapper) {
        this.pathMapper = pathMapper;
    }

    public PlaceMapper getPlaceMapper() {
        return placeMapper;
    }

    public void setPlaceMapper(PlaceMapper placeMapper) {
        this.placeMapper = placeMapper;
    }
}
