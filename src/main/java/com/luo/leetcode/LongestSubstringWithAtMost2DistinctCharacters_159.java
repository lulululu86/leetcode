package com.luo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMost2DistinctCharacters_159 {
    /*Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
For example, Given s = “eceba”,
T is "ece" which its length is 3.*/
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int res = 0;
        char[]c = s.toCharArray();
        int n = c.length;
        if(n<=2)return n;
        char c1 = '0',c2 = '0';
        int p1 = -1,p2 = -1;
        int cur = 0;
        for(int i=0;i<n;i++){
            if(c1!=c[i]&&c2!=c[i]){
                if(c1=='0'){
                    c1 = c[i];
                    p1 = i;
                    res = Math.max(++cur,res);
                    continue;
                }
                if(c2=='0'){
                    c2 = c[i];
                    p2 = i;
                    res = Math.max(++cur,res);
                    continue;
                }

                cur = i-p2+1;
                c1 = c2;
                p1 = p2;
                c2 = c[i];
                p2 = i;
            }else{
                res = Math.max(res,++cur);
            }
        }
        return Math.max(res,cur);
    }
}
