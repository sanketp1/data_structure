package com.dsa.tree;
import java.util.*;

public class ConstructBinaryTreeFromInorderAndPreorder {

    private static int preOrderIndex = 0;

    //map for locating in oreder element in O(1) time
    private static Map<Integer,Integer> map;


    public static int findPosition(int element){
        return map.get(element);
    }



    private static Node solve(int[] inorder, int[] preorder, int inStart, int inEnd, int n){

        if(preOrderIndex >= n || inStart > inEnd) {
            return null;
        }

        //getting root element from preOrder sequence
        int element = preorder[preOrderIndex];

        //finding position of current root element in inorder sequence
        int position = findPosition(element);

        //incrementing pre order index
        preOrderIndex++;

        //creating object of root element
        Node root = new Node(element);

        //recursive calls

        //attaching left node
        root.left = solve(inorder, preorder, inStart, position-1, n);

        //attaching right node
        root.right = solve(inorder,preorder,position+1,inEnd,n);


        return root;


    }

    public static Node buildTree(int inorder[], int preorder[]) {
        // code here

        map = new HashMap<>();

        //size of array
        int n = inorder.length;

        //mapping in order element
        for(int i = 0; i<n; i++){
            map.put(inorder[i],i);
        }

        Node result = solve(inorder,preorder,0,n-1,n);

        return result;

    }


}
