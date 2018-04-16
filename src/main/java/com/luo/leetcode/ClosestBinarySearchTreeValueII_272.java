package com.luo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClosestBinarySearchTreeValueII_272 {
    /*Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:

Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.


Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

Hint:

1. Consider implement these two helper functions:
　　i. getPredecessor(N), which returns the next smaller node to N.
　　ii. getSuccessor(N), which returns the next larger node to N.
2. Try to assume that each node has a parent pointer, it makes the problem much easier.
3. Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
4. You would need two stacks to track the path in finding predecessor and successor node separately.

 */
    List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer>res = new LinkedList<Integer>();
        inorder(root,target,k,res);
        return res;
    }
    public void inorder(TreeNode root,double target,int k,List<Integer>res){
        if(root==null)return;
        inorder(root.left,target,k,res);
        if(res.size()<k)res.add(root.val);
        else if(Math.abs(target-res.get(0))>Math.abs(target-root.val)){
            res.remove(0);
            res.add(root.val);
        }else return;
        inorder(root.right,target,k,res);
    }
}
