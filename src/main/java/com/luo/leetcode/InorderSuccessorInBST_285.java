package com.luo.leetcode;

public class InorderSuccessorInBST_285 {
    /*Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.*/
    private TreeNode pre = null;
    private TreeNode suc = null;
    TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root,p);
        return suc;
    }
    private void inorder(TreeNode root,TreeNode p){
        if(root==null)return;
        inorder(root.left,p);
        if(pre==p)suc = root;
        pre = root;
        inorder(root.right,p);
    }
    TreeNode inorderSuccessor1(TreeNode root,TreeNode p){
        TreeNode res = root;
        while(root!=null){
            if(root.val<p.val){
                res = root;
                root = root.left;
            }else root = root.right;
        }
        return res;
    }
}
