package com.luo.leetcode;
import java.util.*;
public class GeneralizedAbbreviation_320 {
    /*Write a function to generate the generalized abbreviations of a word.

Example:

Given word = "word", return the following list (order does not matter):

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]*/
    public List<String> generateAbbreviations(String s) {
        int n = s.length();
        char[]c = s.toCharArray();
        List<String>res = new ArrayList<String>();
        for(int i=0;i<(1<<n);i++){
            res.add(valueToString(i,c));
        }
        return res;
    }
    private String valueToString(int value,char[]c){
        StringBuilder sb = new StringBuilder();
        //0000,0010,0110,1010,1111
        int n = c.length,cnt = 0;
        int i=0;
        while(i<n){
            if((value&1)==0){
                sb.append(cnt>0?cnt:"").append(c[i]);
                cnt = 0;
            }else cnt++;

            value>>=1;
            i++;
        }
        if(cnt>0)sb.append(cnt);
        return sb.toString();
    }

    public List<String> generateAbbreviations1(String s) {
        List<String>res = new ArrayList<String>();
        dfs(s,res,0,"",0);
        return res;
    }
    private void dfs(String s,List<String>res,int cnt,String cur,int pos){
        if(pos==s.length()){
            res.add(cnt>0?cur+cnt:cur);
            return;
        }
        dfs(s,res,0,cur+(cnt>0?cnt:"")+s.charAt(pos),pos+1);
        dfs(s,res,cnt+1,cur,pos+1);
    }
}
