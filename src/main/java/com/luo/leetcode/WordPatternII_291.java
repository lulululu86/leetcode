package com.luo.leetcode;
import java.util.*;
public class WordPatternII_291 {
    /*Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Examples:

pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.


Notes:
You may assume both pattern and str contains only lowercase letters.*/
    boolean wordPatternMatch(String pattern, String str) {
        String[]map = new String[26];
        for(int i=0;i<26;i++)map[i] = "";
        return dfs(pattern,str,0,0,map);
    }
    private boolean dfs(String pattern,String str,int pos,int i,String[]map){
        if(i==pattern.length()-1){
            return str.substring(pos).equals(map[pattern.charAt(i)-'a']);
        }
        for(int j=pos+1;j<str.length();j++){
            String cur = str.substring(pos,j);
            if(map[pattern.charAt(i)-'a']==""){
                map[pattern.charAt(i)-'a'] = cur;
                if(dfs(pattern,str,pos+cur.length(),i+1,map))return true;
            } else if(map[pattern.charAt(i)-'a'].equals(cur)){
                if(dfs(pattern,str,pos+cur.length(),i+1,map))return true;
            }
            map[pattern.charAt(i)-'a'] = "";
        }
        return false;
    }
}
