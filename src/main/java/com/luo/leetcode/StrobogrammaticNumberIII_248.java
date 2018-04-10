package com.luo.leetcode;
import java.util.*;
public class StrobogrammaticNumberIII_248 {
    /*
    * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

For example,
Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

Note:
Because the range might be a large number, the low and high numbers are represented as string.
    * */
    public int strobogrammaticInRange(String low, String high) {
        //0 1 8 69
        int m = low.length(),n = high.length();
        List<String>can = new ArrayList<String>();
        for(int i=m;i<=n;i++){
            can.addAll(dfs(i,i));
        }
        int res = 0;
        for(String s:can){
            System.out.print(s+" ");
            if(low.length()==s.length()&&s.compareTo(low)<0 || high.length()==s.length()&&s.compareTo(high)>0)continue;
            res++;
        }
        return res;
    }
    private List<String>dfs(int len,int n){
        if(len==0)return new ArrayList<String>(Arrays.asList(""));
        if(len==1)return new ArrayList<String>(Arrays.asList("0","1","8"));
        List<String>list = dfs(len-2,n);
        List<String>res = new ArrayList<String>();
        for(String s:list){
            if(len<n)res.add("0"+s+"0");
            res.add("1"+s+"1");
            res.add("6"+s+"9");
            res.add("8"+s+"8");
            res.add("9"+s+"6");
        }
        return res;
    }

}
