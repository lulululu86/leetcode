package com.luo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator_341 {
    /*Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].


 */
//    private List<Integer>q;
//    int cur;
//    public FlattenNestedListIterator_341(List<NestedInteger>list){
//        q = new ArrayList<Integer>();
//        make(list,q);
//        cur = 0;
//
//    }
//    public boolean hasNext(){
//        return cur!=q.size();
//    }
//    public int next(){
//        return q.get(cur++);
//    }
//    public void make(List<NestedInteger>list,List<Integer>q){
//        for(NestedInteger ni:list){
//            if(ni.isInteger())q.add(ni.getInteger());
//            else make(ni.getList(),q);
//        }
//    }
    private Stack<NestedInteger>stack;
    public FlattenNestedListIterator_341(List<NestedInteger>list){
        stack = new Stack<NestedInteger>();
        for(int i=list.size()-1;i>=0;i--)
            stack.push(list.get(i));
    }
    public boolean hasNext(){
        while(!stack.isEmpty() && !stack.peek().isInteger()){
            List<NestedInteger>list = stack.pop().getList();
            for(int i=list.size()-1;i>=0;i--)
                stack.push(list.get(i));
        }
        return !stack.isEmpty() && stack.peek().isInteger();
    }
    public int next(){
        return stack.pop().getInteger();
    }
}
