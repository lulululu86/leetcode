package com.luo.leetcode;

public class ShortestWordDistance_243 {
    /*
    *Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
    * */
    public int shortestDistance(String[] words, String word1, String word2) {
        int pos1 = -1,pos2 = -1,n = words.length,res = n;
        for(int i=0;i<n;i++){
            if(words[i].equals(word1)){
                if(pos2>0)res = Math.min(res,i-pos2);
                pos1 = i;
            }else if(words[i].equals(word2)){
                if(pos1>0)res = Math.min(res,i-pos1);
                pos2 = i;
            }
        }
        return res;
    }
}
