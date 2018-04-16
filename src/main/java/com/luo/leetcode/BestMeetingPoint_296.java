package com.luo.leetcode;
import java.util.*;
public class BestMeetingPoint_296 {
    /*A group of two or more people wants to meet and minimize the total travel distance.
    You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
    The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

Hint:

Try to solve it in one dimension first. How can this solution apply to the two dimension case?*/

    public int minTotalDistance(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int x=0,y=0,len=0;
        List<Integer>xx = new ArrayList<Integer>();
        List<Integer>yy = new ArrayList<Integer>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    xx.add(i);
                    yy.add(j);
                    x+=i;
                    y+=j;
                    len++;
                }
            }
        }
        int res = 0;
        Collections.sort(yy);
        int i=0,j=len-1;
        while(i<j){
            res+=xx.get(j)-xx.get(i)+yy.get(j)-yy.get(i);
            i++;
            j--;
        }
        return res;
    }
}
