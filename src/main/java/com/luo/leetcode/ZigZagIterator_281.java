package com.luo.leetcode;
import java.util.*;
public class ZigZagIterator_281 {
    /*Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not
look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].*/
    private List<Iterator> iterators;
    private int cur;
    public ZigZagIterator_281(List<List<Integer>>vectors){
        iterators = new ArrayList<Iterator>();
        for(List<Integer>list:vectors)iterators.add(list.iterator());
        cur = -1;
    }
    public int next(){
        return (Integer)iterators.get(cur).next();
    }
    public boolean hasNext(){
        int next = (cur+1)%iterators.size();
        while(next!=cur&&!iterators.get(next).hasNext()){
            next = (next+1)%iterators.size();
        }
        if(next!=cur){
            cur = next;
            return true;
        }else return iterators.get(cur).hasNext();


    }
}
