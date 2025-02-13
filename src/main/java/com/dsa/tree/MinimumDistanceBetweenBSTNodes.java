package com.dsa.tree;

public class MinimumDistanceBetweenBSTNodes {

    public static void main(String[] args) {
        TreeNode root = null;

        //root node
        root = new TreeNode(4);

        //left subtree
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        //right subtree
        root.right = new TreeNode(6);

        int dist = minDiffInBST(root);
        System.out.println(dist);
    }

    public static int minDiffInBST(TreeNode root) {
       if(root == null) return 0;
       int[] minDiff = {Integer.MAX_VALUE};

       solve(root,minDiff);
       return minDiff[0];
    }

    private static int solve(TreeNode root, int[] minDiff){
        if(root == null) return 0;

        if(root.left == null && root.right == null){
            return root.data;
        }

        int left = solve(root.left,minDiff);
        minDiff[0] = Math.min(minDiff[0], Math.abs(root.data - left));
        int right = solve(root.right,minDiff);
        minDiff[0] = Math.min(minDiff[0], Math.abs(root.data - right));

        minDiff[0] = Math.min(minDiff[0], Math.abs(left-right));

        return Math.min(left,right);
    }
}
