package com.luo.leetcode;

import java.util.ArrayList;
import java.util.*;

public class MinimumUniqueWordAbbreviation_411 {
    /*A string such as "word" contains the following abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the smallest
possible length such that it does not conflict with abbreviations of the strings in the dictionary.

Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.

Note:

In the case of multiple answers as shown in the second example below, you may return any one of them.
Assume length of target string = m, and dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤ 20.


Examples:

"apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")

"apple", ["plain", "amber", "blade"] -> "1p3" (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1").
 */
    public String minAbbreviation(String target, List<String> dictionary) {
        List<String>abbrs = new ArrayList<String>();
        dfs(target,abbrs,0,0,"");

        Collections.sort(abbrs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        for(String abbr:abbrs){
            boolean use = true;
            for(String s:dictionary){
                if(isValid(s,abbr))use = false;
            }
            if(use)return abbr;
        }
        return "";
    }
    private void dfs(String target,List<String>abbrs,int len,int pos,String cur){
        if(pos==target.length()){
            abbrs.add(cur+(len==0?"":len));
            return;
        }
        dfs(target,abbrs,len+1,pos+1,cur);
        dfs(target,abbrs,0,pos+1,cur+(len==0?"":len)+target.charAt(pos));
    }
    private boolean isValid(String s,String abbr){
        char[] cs = s.toCharArray(),cAbbr = abbr.toCharArray();
        int n = abbr.length(),m = s.length(),i = 0,j=0;
        while(i<n){
            if(cAbbr[i]>='a'&&cAbbr[i]<='z'){
                if(j>m || cAbbr[i]!=cs[j])return false;
                i++;j++;
            }else if(cAbbr[i]>='0'&&cAbbr[i]<='9'){
                int num = 0;
                while(i<n&&cAbbr[i]>='0'&&cAbbr[i]<='9'){
                    num = num*10+(cAbbr[i++]-'0');
                }
                j+=num;
            }
        }
        return i==n&&j==m;
    }
}
