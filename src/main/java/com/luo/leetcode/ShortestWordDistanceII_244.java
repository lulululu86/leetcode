package com.luo.leetcode;

import java.util.List;
import java.util.*;
public class ShortestWordDistanceII_244 {
    /*
    * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method
     * will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor,
and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
    * */
    private Map<String,List<Integer>>map;
    public ShortestWordDistanceII_244(String[] words) {
        map = new HashMap<String, List<Integer>>();
        int n = words.length;
        for(int i=0;i<n;i++){
            if(!map.containsKey(words[i]))map.put(words[i],new ArrayList<Integer>());
            map.get(words[i]).add(i);
        }
    }
    public int shortest(String word1, String word2) {
        List<Integer>list1 = map.get(word1);
        List<Integer>list2 = map.get(word2);
        int i1=0,i2=0,n1 = list1.size(),n2 = list2.size(),res = Integer.MAX_VALUE;
        while(i1<n1 && i2<n2){
            res = Math.min(res,Math.abs(list1.get(i1)-list2.get(i2)));
            if(list1.get(i1)<list2.get(i2))i1++;
            else i2++;
        }
        return res;
    }
}
