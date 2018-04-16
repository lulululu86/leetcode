package com.luo.leetcode;

public class BinaryTreeLongestConsecutiveSequence_298 {
    /*Given a binary tree, find the length of the longest consecutive sequence path.



The path refers to any sequence of nodes from some starting node to any node in the tree
along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,

   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    /
   2
  /
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
*/
    private int res = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root){
        if(root==null)return 0;
        int left = longestConsecutive(root.left);
        int right = longestConsecutive(root.right);
        int max = 1;
        if(root.left!=null&&root.val==root.left.val-1)max = Math.max(max,left+1);
        if(root.right!=null&&root.val==root.right.val-1)max = Math.max(max,right+1);
        res = Math.max(res,max);
        return max;
    }
}
