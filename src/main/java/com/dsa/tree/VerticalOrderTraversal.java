package com.dsa.tree;
import java.util.*;



public class VerticalOrderTraversal {

    private class Pair<K,V>{
        K first;
        V second;

        public Pair(){}

        public Pair(K first, V second){
            this.first = first;
            this.second = second;
        }
    }


    public ArrayList <Integer> verticalOrder(Node root)
    {

        Map<Integer,Map<Integer,List<Integer>>> nodes;
        Queue<Pair<Node,Pair<Integer,Integer>>> queue;

        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        nodes = new HashMap<>();
        queue = new LinkedList<>();

        //adding root node
        /*
            where,
                Horizontal Distance -> 0
                Level ->  0
         */
        queue.add(new Pair<>(root,new Pair<>(0,0)));

        while(!queue.isEmpty()){
            Pair<Node,Pair<Integer,Integer>> temp = queue.poll();

            Node frontNode = temp.first;
            // horizontal distance
            int hd = temp.second.first;
            // level
            int level = temp.second.second;

            nodes.putIfAbsent(hd, new HashMap<>());
            nodes.get(hd).putIfAbsent(level,new ArrayList<>());
            nodes.get(hd).get(level).add(frontNode.data);

            if(frontNode.left!=null){
                queue.add(new Pair<>(frontNode.left, new Pair<>(hd-1,level+1)));
            }

            if(frontNode.right!=null){
                    queue.add(new Pair<>(frontNode.right,new Pair<>(hd+1,level+1)));
            }
        }

        for (Map.Entry<Integer,Map<Integer,List<Integer>>> entry : nodes.entrySet()){
            entry.getValue().values().forEach(x-> {
                ans.addAll(x);
            });
        }

        return ans;

    }

}
