package com.luo.leetcode;

public class PaintFence_276 {
    /*There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.*/
    public int numWays(int n, int k) {
        int diff = k,same = 0;
        for(int i=1;i<n;i++){
            int t = diff;
            diff = (same+diff)*(k-1);
            same = t;
        }
        return same+diff;
    }



}
