package com.luo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortTransformedArray_360 {
    /*Given a sorted array of integers nums and integer values a, b and c.
    Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example:
nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

Result: [-23, -5, 1, 7]
Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.*/
    List<Integer> sortTransformedArray(List<Integer>nums,int a,int b,int c){
        double axis = -(double)b/2/a;
        int n = nums.size(),l = 0,r = n-1;
        int[]res = new int[n];
        int idx = a>=0?n-1:0;
        while(l<=r){
            if(a>=0){
                int x = 0;
                if(Math.abs(nums.get(l)-axis)<Math.abs(nums.get(r)-axis)){
                    x = nums.get(r--);
                }else{
                    x = nums.get(l++);
                }
                res[idx--]=a*x*x+b*x+c;
            }else{
                int x = 0;
                if(Math.abs(nums.get(l)-axis)<Math.abs(nums.get(r)-axis)){
                    x = nums.get(r--);
                }else{
                    x = nums.get(l++);
                }
                res[idx++]=a*x*x+b*x+c;
            }
        }
        List<Integer>ret = new ArrayList<Integer>();
        for(int i:res)ret.add(i);
        return ret;
    }
}
