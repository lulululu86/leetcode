package com.luo.leetcode;

import java.util.*;

public class LineReflection_356 {
    /*Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n2)?

Hint:

Find the smallest and largest x-value for all points.
If there is a line then it should be at y = (minX + maxX) / 2.
For each point, make sure that it has a reflected point in the opposite side.
Credits:
Special thanks to @memoryless for adding this problem and creating all test cases.*/
    public boolean isReflected(List<int[]> points) {
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        Set<String>pointsSet = new HashSet<String>();
        for(int[]point:points){
            pointsSet.add(point[0]+","+point[1]);
            min = Math.min(min,point[0]);
            max = Math.max(max,point[0]);
        }
        int y = min+max;
        for(int[]point:points){
            System.out.println(point[0]+" "+point[1]+" "+(y-point[0])+" "+point[1]);
            if(y-point[0]!=point[0] && !pointsSet.contains((y-point[0])+","+point[1]))return false;
        }
        return true;
    }
}
