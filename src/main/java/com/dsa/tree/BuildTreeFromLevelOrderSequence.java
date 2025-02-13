package com.dsa.tree;

import java.util.*;
public class BuildTreeFromLevelOrderSequence {

    private int k; // Make k a class-level variable

    private TreeNode solve(TreeNode root, int node) {
        if (root == null) {
            return null;
        }

        // If the current node matches the target node
        if (root.data == node) {
            return root;
        }

        // Search in the left and right subtrees
        TreeNode left = solve(root.left, node);
        TreeNode right = solve(root.right, node);

        // If the node is found in either subtree
        if (left != null || right != null) {
            k--; // Decrement k for each ancestor
            if (k == 0) {
                return root; // Return the kth ancestor
            }
            return left != null ? left : right; // Propagate the found node up
        }

        return null; // TreeNode not found in this path
    }

    public int kthAncestor(TreeNode root, int k, int node) {
        this.k = k; // Initialize class-level k
        TreeNode ans = solve(root, node);

        // If ans is null or no ancestor was found within k steps, return -1
        return (ans == null || ans.data == node) ? -1 : ans.data;
    }

    public static void main(String[] args) {
        int node  = 7;
        TreeNode root = buildTree(node);

        BuildTreeFromLevelOrderSequence bl = new BuildTreeFromLevelOrderSequence();

        int n = 6;
        int k = 3;
        int ans = bl.kthAncestor(root, k, 3);
        System.out.println(ans);
    }



    private static TreeNode buildTree(int n){

        if (n <= 0) {
            return null;
        }

        TreeNode root = new TreeNode(0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int value = 1; // Start adding nodes from 1
        while (value < n) {
            TreeNode current = queue.poll();

            // Add left child if there's a value available
            if (value < n) {
                current.left = new TreeNode(value++);
                queue.add(current.left);
            }

            // Add right child if there's a value available
            if (value < n) {
                current.right = new TreeNode(value++);
                queue.add(current.right);
            }
        }

        return root;


    }

}
