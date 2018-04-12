package com.luo.leetcode;

public class PaintHouse_256 {
    /*
    * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
    * The cost of painting each house with a certain color is different. You have to paint all the houses
    * such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example,
costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting
house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

*/
    public int minCost(int[][] costs) {
       int[][]dp = costs;
       int n = dp.length;
       for(int i=1;i<n;i++){
           for(int j=0;j<3;j++){
               dp[i][j] = Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3]);
           }
       }
       int res = Integer.MAX_VALUE;
       for(int i=0;i<3;i++)res = Math.min(res,dp[n-1][i]);
       return res;
    }
}
