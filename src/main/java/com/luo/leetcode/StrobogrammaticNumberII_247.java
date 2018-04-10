package com.luo.leetcode;
import java.util.*;
public class StrobogrammaticNumberII_247 {
    /*
    * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Find all strobogrammatic numbers that are of length = n.
For example,
Given n = 2, return ["11","69","88","96"].
    * */
    public List<String> findStrobogrammatic(int n) {
        //0 1 8 69
        List<String>one = Arrays.asList("0","1","8");
        List<String>two = Arrays.asList("11","69","88","96","00");
        if(n==1)return one;
        if(n==2)return Arrays.asList("11","69","88","96");
        List<String>res =  dfs(n,one,two);
        for(String s:res)System.out.print(s+" ");
        System.out.println();
        return res;
    }
    private List<String> dfs(int n,List<String>one,List<String>two){
        if(n==1)return one;
        if(n==2)return two;
        List<String> cur = dfs(n-2,one,two);
        List<String> res = new ArrayList<String>();
        for(String s:cur){
            res.add("1"+s+"1");
            res.add("6"+s+"9");
            res.add("8"+s+"8");
            res.add("9"+s+"6");
        }
        return res;
    }
}
