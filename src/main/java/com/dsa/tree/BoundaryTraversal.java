package com.dsa.tree;
import java.util.*;

public class BoundaryTraversal {

    public static void main(String[] args) {

    }

    public static List<Integer> traverseBoundary(TreeNode root){

        if(root == null) return new ArrayList<>();

        List<Integer> result =  new ArrayList<>();

        //adding root at index 0
        result.add(root.data);

        //collecting left nodes
        leftNodes(root,result);

        //collect leaf nodes
        leafNodes(root,result);

        //collect right nodes
        rightNodes(root,result);

        return result;

    }

    private static void leftNodes(TreeNode root, List<Integer> result){
        if(root == null) return;

        //eliminating leaf nodes
        if(root.left == null && root.right == null) return ;

        result.add(root.data);

        //traversing to left
        if(root.left!=null){
            leftNodes(root.left, result);
        }
        else{
            //otherwise moving to right for collecting left boundary
            leftNodes(root.right, result);
        }

    }

    private static void leafNodes(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            result.add(root.data);
        }


        // processing for left and right subtree
        leafNodes(root.left, result);
        leafNodes(root.right, result);
    }

    private static void rightNodes(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        //eliminating the leaf nodes
        if(root.left == null && root.right == null) return;

        rightNodes(root.right, result);
        result.add(root.data);
    }



}
