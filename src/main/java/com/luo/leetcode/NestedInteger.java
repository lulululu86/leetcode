package com.luo.leetcode;
import java.util.*;
public class NestedInteger {
    private Integer value;
    private List<NestedInteger>list;
    public NestedInteger(){
        value = null;
        list = null;
    }
    public NestedInteger(int value){
        this.value = value;
        list = null;
    }
    public NestedInteger(List<NestedInteger>list){
        this.list = list;
        value = null;
    }
    public void setValue(Integer value){
        this.value = value;
    }
    public void setList(List<NestedInteger>list){
        this.list = new ArrayList<NestedInteger>();
        this.list.addAll(list);
    }
    public void setIntegerList(List<Integer>integerList){
        this.list = new ArrayList<NestedInteger>();
        for(int i:integerList){
            list.add(new NestedInteger(i));
        }
    }
    public boolean isInteger(){
        return value!=null;
    }
    public Integer getInteger(){
        return value;
    }
    public List<NestedInteger> getList(){
        return list;
    }
}
