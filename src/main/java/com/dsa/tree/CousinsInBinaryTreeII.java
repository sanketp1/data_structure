package com.dsa.tree;
import java.util.*;

public class CousinsInBinaryTreeII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(1), new TreeNode(10)),
                new TreeNode(9, null, new TreeNode(7)));


        System.out.print("Initial: ");
        printTree(root);
        System.out.println();

        TreeNode modifiedRoot = replaceValueInTree(root);

        // Print the modified tree values using BFS
        System.out.print("Modified:- ");
        printTree(modifiedRoot);
        System.out.println();
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    public static TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;

        // Queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        root.data = 0; // Root has no cousins

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            Map<TreeNode, Integer> siblingSums = new HashMap<>();

            // First pass: Calculate level sum and sibling sums
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    siblingSums.put(node.left, node.left.data +   (node.right != null ? node.right.data : 0));
                    queue.offer(node.left);
                    levelSum += node.left.data;
                }
                if (node.right != null) {
                    siblingSums.put(node.right, node.right.data + (node.left != null ? node.left.data : 0));
                    queue.offer(node.right);
                    levelSum += node.right.data;
                }
            }

            // Second pass: Update values for each node
            for (TreeNode node : siblingSums.keySet()) {
                int siblingSum = siblingSums.get(node);
                node.data = levelSum - siblingSum;
            }
        }

         return root;

    }

}
