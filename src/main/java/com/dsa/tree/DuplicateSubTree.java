package com.dsa.tree;

import java.util.*;

public class DuplicateSubTree {

    public static void main(String[] args) {
        /*
               1
             /   \
           2       3
         /   \       \
        4     5       2
                     /  \
                    4    5
         */
        // Creating the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(2);
        root.right.right.left = new Node(4);
        root.right.right.right = new Node(5);

        if (dupSub(root) == 1) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static int dupSub(Node root){
        if(root == null) return 0;

//        Map<String,Integer> map = new HashMap<>();
//
//        dupSubRecur(root,map);
//
//        for(int val : map.values()){
//            if(val>1) return 1;
//        }
//
//        return 0;

        Set<String> s = new HashSet<>();
        int[] ans = {0};

        dupSubRecur(root,s,ans);

        return ans[0];
    }

    private static String dupSubRecur(Node root, Map<String,Integer> map){
        // For null node returning N
        if(root == null) return "N";

        // For all leaf nodes returning its value
        if(root.left != null && root.right == null){
            return String.valueOf(root.data);
        }

        //processing in left and right subtree
        String left = dupSubRecur(root.left,map);
        String right = dupSubRecur(root.right,map);

        StringBuilder curr = new StringBuilder();
        curr.append(root.data);
        curr.append("*");
        curr.append(left);
        curr.append("*");
        curr.append(right);

        String temp = curr.toString();

        map.put(temp, map.getOrDefault(temp,0)+1);

        return temp;
    }


    private static String dupSubRecur(Node root, Set<String> s , int[] ans){
        // For null nodes
        if(root == null){
            return "N";
        }

        // For leaf nodes, return its value in string
        if(root.left == null && root.right == null){
            return String.valueOf(root.data);
        }

        StringBuilder curr =  new StringBuilder();
        curr.append(root.data);

        //process the left and right sub tree
        String left = dupSubRecur(root.left, s, ans);
        String right = dupSubRecur(root.right, s, ans);

        // If node is parent of 2
        // leaf nodes, or 1 leaf node and 1
        // null node, then concatenate the strings
        if(!left.equals("") && !right.equals("")){
            curr.append("*");
            curr.append(left);
            curr.append("*");
            curr.append(right);
        }
        else{
            return "";
        }

        // If this subtree string
        // Already present in the set
        // Then set ans value to 1
        String value = curr.toString();
        if(s.contains(value)){
            ans[0] = 1;
        }
        else{
            s.add(value);
        }

        return "";
    }




}
