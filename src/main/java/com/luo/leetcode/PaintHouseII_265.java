package com.luo.leetcode;

public class PaintHouseII_265 {
    /*There are a row of n houses, each house can be painted with one of the k colors.
    The cost of painting each house with a certain color is different. You have to paint
    all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix.
 For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2]is the cost of
 painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?

*/
    public int minCostII(int[][] costs) {
        int n = costs.length,K = costs[0].length;
        int min1 = 0,min2 = 0,idx1 = -1;
        int curmin1 = 0,curmin2 = 0,curidx1 = -1,lastidx1 = -1;
        for(int i=0;i<n;i++){
            curmin1 = Integer.MAX_VALUE;curmin2 = Integer.MAX_VALUE;
            for(int k=0;k<K;k++){
                int cost = costs[i][k] + (lastidx1==k?min2:min1);
                if(cost<curmin1){
                    curmin2 = curmin1;
                    curmin1 = cost;
                    curidx1 = k;
                }else if(cost<curmin2)curmin2 = cost;
            }
            min1 = curmin1;min2 = curmin2;lastidx1 = curidx1;
        }
        return min1;
    }
}
