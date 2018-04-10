package com.luo.leetcode;

public class StrobogrammaticNumber_246 {
    /*
    * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers “69”, “88”, and “818” are all strobogrammatic.
    * */
    public boolean isStrobogrammatic(String num) {
        int[] map = new int[10];
        map[0] = 0;
        map[1] = 1;
        map[2] = -1;
        map[3] = -1;
        map[4] = -1;
        map[5] = -1;
        map[6] = 9;
        map[7] = -1;
        map[8] = 8;
        map[9] = 6;
        char[]c = num.toCharArray();
        int n = c.length;
        int j = 0;
        for(int i=n-1;i>=0;i--){
            int cur = c[i]-'0';
            int rev = c[n-1-i]-'0';
            if(map[cur]!=rev)return false;
        }
        return true;
    }
}
