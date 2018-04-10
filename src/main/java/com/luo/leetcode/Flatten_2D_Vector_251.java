package com.luo.leetcode;
import java.util.*;
public class Flatten_2D_Vector_251 {
    /*
    Implement an iterator to flatten a 2d vector.

For example, Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
     */
    private List<Iterator<Integer>> iterators;
    private int cur;
    public Flatten_2D_Vector_251(List<List<Integer>> vec2d) {
        iterators = new ArrayList<Iterator<Integer>>();
        for(List<Integer>list:vec2d){
            if(list.size()>0)iterators.add(list.iterator());
        }
        cur = 0;
    }
    public int next(){
        int res = iterators.get(cur).next();
        if(!iterators.get(cur).hasNext())cur++;
        return res;
    }
    public boolean hasNext(){
        return cur<iterators.size()&&iterators.get(cur).hasNext();
    }
}
