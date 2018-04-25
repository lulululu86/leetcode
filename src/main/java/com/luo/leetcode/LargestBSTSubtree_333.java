package com.luo.leetcode;

public class LargestBSTSubtree_333 {
    /*Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
    where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:

    10
    / \
   5  15
  / \   \
 1   8   7
The Largest BST Subtree in this case is the highlighted one.
The return value is the subtree's size, which is 3.



Hint:

You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree,
which will result in O(nlogn) time complexity.
Follow up:
Can you figure out ways to solve it with O(n) time complexity?*/

    public int largestBSTSubtree(TreeNode root) {
        int[]res = {1};
        dfs(root,res);
        return res[0];
    }
    private int[] dfs(TreeNode root,int[]res){
        if(root==null)return new int[]{1,0};
        int[] left = dfs(root.left,res);
        int[] right = dfs(root.right,res);
        if(left[0]==1&&right[0]==1){
            int sz = 1;
            if((root.left==null || root.left!=null&&root.left.val<root.val)
                    && (root.right==null || root.right!=null&&root.right.val>root.val)) {
                sz += left[1]+right[1];
                res[0] = Math.max(res[0], sz);
                return new int[]{1, sz};
            }else return new int[]{0,sz};
        }else return new int[]{0,1};
    }
}
