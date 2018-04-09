package com.luo.leetcode;
import java.util.*;
public class TwoSumIII_170 {
    /*
    * Design and implement a TwoSum class. It should support the following operations:add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,

add(1); add(3); add(5);
find(4) -> true
find(7) -> false
    * */
    private List<Integer>list;
    private Set<Integer>sum;
    public TwoSumIII_170(){
        list = new ArrayList<Integer>();
        sum = new HashSet<Integer>();
    }
    public void add(int val){
        for(int i:list)sum.add(i+val);
        list.add(val);
    }
    public boolean find(int val){
        return sum.contains(val);
    }
}
