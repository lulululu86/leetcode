package com.luo.leetcode;

public class ClosestBinarySearchTreeValue_270 {
    /*Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
    public int closestValue(TreeNode root, double target) {
        int[] res = {root.val};
        traverse(root, target, res);
        return res[0];
    }

    private void traverse(TreeNode root, double target, int[] res) {
        if (root == null) return;
        if (Math.abs(target - root.val) < Math.abs(target - res[0])) res[0] = root.val;
        traverse(root.left, target, res);
        traverse(root.right, target, res);
    }

    public int closestValueBetter(TreeNode root, double target) {

        int res = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - res)) res = root.val;
            if (target < root.val) root = root.left;
            else root = root.right;
        }
        return res;
    }
    public int closestValueBetter1(TreeNode root,double target){
        int res = root.val;
        TreeNode next = target<root.val?root.left:root.right;
        if(next==null)return res;
        int ret = closestValueBetter1(next,target);
        return Math.abs(target-ret)<Math.abs(target-res)?ret:res;
    }
}
