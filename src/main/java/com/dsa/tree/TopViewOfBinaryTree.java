package com.dsa.tree;
import java.util.*;

public class TopViewOfBinaryTree {

    private static class Pair<K,V>{
        K first;
        V second;

        public Pair(){}

        public Pair(K first, V second){
            this.first = first;
            this.second = second;
        }
    }



    static ArrayList<Integer> topView(Node root) {
        if(root == null) return new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();


        // map consist of
        // key -> horizontal distance
        // value -> node value
        Map<Integer,Integer> topNodes = new TreeMap<>();
        //queue consist of pair
        /*
            where,
                first of pair -> node of tree
                second of pair -> horizontal distance
         */
        Queue<Pair<Node,Integer>> queue = new LinkedList<>();

        //adding root node of horizontal distance 0 to the queue
        queue.offer(new Pair(root,0));

        while(!queue.isEmpty()){
            Pair<Node,Integer> temp = queue.poll();

            Node frontNode = temp.first;

            // horizontal distance
            int hd = temp.second;

            if(!topNodes.containsKey(hd)){
                topNodes.put(hd, frontNode.data);
            }

            if(frontNode.left!=null){
                queue.offer(new Pair<>(frontNode.left,hd-1));
            }

            if(frontNode.right!=null){
                queue.offer(new Pair<>(frontNode.right,hd+1));
            }
        }

        for (Map.Entry<Integer,Integer> entry : topNodes.entrySet()){
            result.add(entry.getValue());
        }

        return result;
    }

}
