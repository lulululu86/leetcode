package com.luo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithAtMostKDistinctCharacters_340 {
    /*Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.*/
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[]c = s.toCharArray();
        int n = c.length,i=0,j = 0;
        Set<Character>set = new HashSet<Character>();
        while(i<n&&set.size()<k){
            set.add(c[i++]);
        }
        int res = i;
        for(;i<n;i++){
            set.add(c[i]);
            int sz = set.size();
            if(sz==k){
                res = Math.max(res,i-j+1);
                continue;
            }
            else{
                while(sz>k&&set.contains(c[j])){
                    set.remove(c[j]);
                    j++;
                }
            }
        }
        return res;
    }
}
