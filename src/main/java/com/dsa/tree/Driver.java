package com.dsa.tree;

public class Driver {

    public static void main(String[] args) {
        int[] inorder = {1, 6, 8, 7};
        int[] preorder = {1, 6, 7, 8};

        Node result = ConstructBinaryTreeFromInorderAndPreorder.buildTree(inorder,preorder);

        //validating using post order sequence
        postOrder(result);

    }

    private static void postOrder(Node root){
        if(root == null) return ;

        postOrder(root.left);
        postOrder(root.right);

        System.out.print(root.data+" ");
    }
}
