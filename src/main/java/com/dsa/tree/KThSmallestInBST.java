package com.dsa.tree;

public class KThSmallestInBST {

    public static void main(String[] args) {
        TreeNode root = null;

        root = new TreeNode(5);

        //left subtree
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        //right subtree
        root.right = new TreeNode(6);

        int k = 3;

        int result = kthSmallest(root,k);

        System.out.println(result);
    }

    private static int solve(TreeNode root, int[] count, int k){
        if(root == null) return -1;

        int left = solve(root.left, count, k);

        if(left != -1) return left;

        count[0]++;

        if(k == count[0]) return root.data;

        return solve(root.right,count,k);
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] count = {0};
        return solve(root,count,k);
    }



}
