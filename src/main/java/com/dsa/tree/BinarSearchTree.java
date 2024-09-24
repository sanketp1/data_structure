package com.dsa.tree;

public class BinarSearchTree {
    
    private  TreeNode root;

    public void insert(int val){
        root = insertRecurr(val, root);
    }

    private TreeNode insertRecurr(int val, TreeNode root){
        if(root == null){
            return new TreeNode(val);
        }

        if(val>root.val){
                root.right = insertRecurr(val, root);
        }else{
            if(val >= root.val){
                root.left = insertRecurr(val, root);
            }
        }

        return root;
    }
    
}
