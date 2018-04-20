package com.luo.leetcode;
import java.util.*;
public class NumberOfIslandsII_305 {
    /*A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?*/
    public List<Integer> numIslands2(int m, int n, List<int[]> positions) {
        int[]pa = new int[m*n];
        int[]de = new int[m*n];
        int[]dirs = {0,1,0,-1,-1,0,1,0};
        for(int i=0;i<m*n;i++)pa[i] = -1;
        List<Integer>res = new ArrayList<Integer>();
        int cnt = 0;
        for(int[]pos:positions){
            int i = pos[0];
            int j = pos[1];
            pa[i*n+j] = i*n+j;
            cnt++;
            for(int k=0;k<8;k+=2){
                int newi = i+dirs[k];
                int newj = j+dirs[k+1];
                if(newi>=0&&newi<m&&newj>=0&&newj<n&&pa[newi*n+newj]!=-1){
                    union(pa,de,i*n+j,newi*n+newj);
                    cnt--;
                }
            }
            res.add(cnt);
        }
        return res;
    }
    private int find(int[]pa,int i){
        return i==pa[i]?i:(pa[i] = find(pa,pa[i]));
    }
    private void union(int[]pa,int[]de,int i,int j){
        int ri = find(pa,i);
        int rj = find(pa,j);
        if(de[ri]==de[rj]){
            pa[ri] = rj;
            de[rj]++;
        }else if(de[ri]<de[rj]){
            pa[ri] = rj;
        }else pa[rj] = ri;
    }
}
