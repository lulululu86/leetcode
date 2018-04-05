package com.luo.leetcode;

public class BinaryTreeUpsideDown156 {
    /*
    * Problem:

Given a binary tree where all the right nodes are either leaf nodes with a sibling
 (a left node that shares the same parent node) or empty, flip it upside down and
 turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},

    1
   / \
  2   3
 / \
4   5


return the root of the binary tree [4,5,2,#,#,3,1].

   4
  / \
 5   2
    / \
   3   1

    *
    * */
    public TreeNode upsideDownBinaryTree(TreeNode root){
        TreeNode node = root, right = null, pa = null;
        while(node!=null){
            TreeNode left = node.left;
            node.left = right;
            right = node.right;
            node.right = pa;
            pa = node;
            node = left;
        }
        return pa;
    }
//    public TreeNode upsideDownBinaryTree(TreeNode root) {
//        if(root==null)return null;
//        TreeNode pa = root, left = root.left,right = root.right;
//
//        if(root.left!=null){
//            TreeNode resRoot = upsideDownBinaryTree(left);
//            root.left = pa.right;
//            root.right = pa;
//            return resRoot;
//        }
//        return root;
//    }

}
