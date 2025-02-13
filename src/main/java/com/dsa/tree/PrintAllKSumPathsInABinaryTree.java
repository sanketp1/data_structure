package com.dsa.tree;
import java.util.*;

public class PrintAllKSumPathsInABinaryTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);

        int k = 5;
        Vector<Integer> v = new Vector<>();

        printAllKSumPath(root,k);
    }

    private static void printAllKSumPath(Node root,int k){
        if(root == null){
            return;
        }

        List<Integer> paths = new ArrayList<>();

        //printing all k sum paths
        solve(root,paths,k);
    }

    static void printVector(List<Integer> v, int i)
    {
        for (int j = i; j < v.size(); j++)
            System.out.print(v.get(j) + " ");
        System.out.println();
    }

    private static void solve(Node root, List<Integer> paths, int k){
        if(root == null) return;

        paths.add(root.data);

        //processing for left and right subtree
        solve(root.left, paths, k);
        solve(root.right, paths, k);

        int sum = 0;

        for(int i = paths.size()-1; i>=0; i--){
            sum+=paths.get(i);

            if(sum==k){
              printVector(paths,i);
            }
        }

        //removing current element from the list
        paths.remove(paths.size()-1);

    }

}
