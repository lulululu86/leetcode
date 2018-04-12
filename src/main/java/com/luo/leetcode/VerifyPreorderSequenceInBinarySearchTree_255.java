package com.luo.leetcode;
import java.util.*;
public class VerifyPreorderSequenceInBinarySearchTree_255 {
    /*
    * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?
    * */
    public boolean verifyPreorder(int[] preorder){
        Stack<Integer>stack = new Stack<Integer>();
        int min = Integer.MIN_VALUE;
        for(int p:preorder){
            if(p<min)return false;
            while(!stack.isEmpty() && stack.peek()<p)min = stack.pop();
            stack.push(p);
        }
        return true;
    }
    public boolean verifyPreorder1(int[]preorder){
        int low = Integer.MIN_VALUE,i=-1;
        for(int a:preorder){
            if(a<low)return false;
            while(i>=0 && preorder[i]<a){
                low = preorder[i--];
            }
            preorder[++i] = a;
        }
        return true;
    }
}
