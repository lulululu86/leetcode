package com.luo.leetcode;

public class ShortestWordDistanceIII_245 {
    /*
    * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = [“practice”, “makes”, “perfect”, “coding”, “makes”].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = “makes”, word2 = “makes”, return 3.

Note:
You may assume word1 and word2 are both in the list.
    * */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int n = words.length,res = n,pos1 = -1,pos2 = -1;
        if(!word1.equals(word2)) {
            for (int i = 0; i < n; i++) {
                if (words[i].equals(word1)) {
                    if (pos2 > 0) res = Math.min(res, i - pos2);
                    pos1 = i;
                } else if (words[i].equals(word2)) {
                    if (pos1 > 0) res = Math.min(res, i - pos1);
                    pos2 = i;
                }
            }
            return res;
        }else{
            for(int i=0;i<n;i++){
                if(words[i].equals(word1)){
                    if(pos1>0)res = Math.min(res,i-pos1);
                    pos1 = i;
                }
            }
            return res;
        }
    }
}
