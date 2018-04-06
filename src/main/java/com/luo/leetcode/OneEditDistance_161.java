package com.luo.leetcode;

public class OneEditDistance_161 {
    /*Given two strings S and T, determine if they are both one edit distance apart.
     */
    public boolean isOneEditDistance(String s, String t) {
        char[]sc = s.toCharArray();
        char[]st = t.toCharArray();
        int[]buffer = new int[26];
        for(char c:sc)buffer[c-'a']++;
        for(char c:st)buffer[c-'a']--;
        int res = 0;
        for(int i=0;i<26;i++){
            if(buffer[i]>1||buffer[i]<-1){
                return false;
            }
            res += Math.abs(buffer[i]);
        }
        return res==1;
    }
}
