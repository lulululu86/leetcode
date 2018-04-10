package com.luo.leetcode;

public class CountUnivalueSubtrees_250 {
    /*
    * Question:

Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,

              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
    * */
    int countUnivalSubtrees(TreeNode root){
        int[]count = {0};
        dfs(root,count);
        return count[0];
    }
    private boolean dfs(TreeNode root,int[]count){
        if(root==null)return false;
        boolean left = dfs(root.left,count);
        boolean right = dfs(root.right,count);
        if(root.left==null&&root.right==null){
            count[0]++;
            return true;
        }else if(root.left==null||root.right==null){
            if(root.left==null&&root.right.val==root.val&&right){
                count[0]++;
                return true;
            }
            else if(root.right==null&&root.left.val==root.val&&left){
                count[0]++;
                return true;
            }else return false;
        }else{
            if(left&&right&&root.val==root.left.val&&root.val==root.right.val){
                count[0]++;
                return true;
            }
            return false;
        }
    }
}
