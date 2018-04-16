package com.luo.leetcode;
import java.util.*;
public class WiggleSort_280 {
    /*Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].*/
    public  int[] wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=1;i<n-1;i+=2){
            int t = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = t;
        }
        return nums;
    }
    public int[]wiggleSort1(int[]nums){
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(i%2==1&&nums[i]<=nums[i-1] ||i%2==0&&nums[i]>=nums[i-1]){
                int t = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = t;
            }
        }
        return nums;
    }
}
