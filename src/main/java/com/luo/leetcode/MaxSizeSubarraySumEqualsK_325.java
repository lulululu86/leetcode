package com.luo.leetcode;
import java.util.*;
public class MaxSizeSubarraySumEqualsK_325 {
    /*Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
    If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?*/
    public int maxSubArrayLen(int[]nums,int k){
        int n = nums.length,res = 0,sum = 0;
        Map<Integer,Integer>map = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum==k)res = Math.max(res,i+1);
            else if(map.containsKey(sum-k))res = Math.max(res,i-map.get(sum-k));
            if(!map.containsKey(sum))map.put(sum,i);
        }
        return res;
    }
}
