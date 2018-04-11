package com.luo.leetcode;
import java.util.*;
public class FactorCombinations_254 {
    /*
    * Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note:

Each combination’s factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
For example:Input: 12
Output: [[2, 2, 3], [2, 6], [3, 4]]
Input: 15
Output: [[3, 5]]
Input: 28
Output: [[2, 2, 7], [2, 14], [4, 7]]    * */
    public List<List<Integer>> getFactors(int n){
        List<List<Integer>>res = new ArrayList<List<Integer>>();
        backtrack(n,2,res,new ArrayList<Integer>());
        return res;
    }
    public void backtrack(int n,int start,List<List<Integer>>res,List<Integer>cur){
        for(int i=start;i*i<=n;i++){
            if(n%i==0){
                List<Integer>next = new ArrayList<Integer>(cur);
                next.add(i);
                backtrack(n/i,i,res,next);
                next.add(n/i);
                res.add(next);
            }
        }
    }
    public List<List<Integer>>getFactors1(int n){
        List<List<Integer>>res = new ArrayList<List<Integer>>();
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                List<List<Integer>>v = getFactors1(n/i);
                List<Integer>cur = new ArrayList<Integer>();
                cur.add(i);
                cur.add(n/i);
                res.add(cur);
                for(List<Integer>list:v){
                    if(i<=list.get(0)){
                        list.add(0,i);
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }












//    public List<List<Integer>> getFactors(int n) {
//        List<List<Integer>>res = new ArrayList<List<Integer>>();
//        backtrack(n,2,res,new ArrayList<Integer>());
//        return res;
//    }
//    private void backtrack(int n,int start,List<List<Integer>>res,List<Integer>cur){
//        for(int i=start;i*i<=n;i++){
//            if(n%i==0){
//                List<Integer>out = new ArrayList<Integer>(cur);
//                out.add(i);
//                backtrack(n/i,i,res,out);
//                out.add(n/i);
//                res.add(out);
//            }
//        }
//    }
//    public List<List<Integer>> getFactors1(int n) {
//        List<List<Integer>>res = new ArrayList<List<Integer>>();
//        for(int i=2;i*i<=n;i++){
//            if(n%i==0){
//                List<List<Integer>>v = getFactors1(n/i);
//                List<Integer>out = new ArrayList<Integer>();
//                out.add(i);
//                out.add(n/i);
//                res.add(out);
//                for(List<Integer> list:v){
//                    if(i<=list.get(0)){
//                        list.add(0,i);
//                        res.add(list);
//                    }
//                }
//
//            }
//        }
//        return res;
//    }
}
