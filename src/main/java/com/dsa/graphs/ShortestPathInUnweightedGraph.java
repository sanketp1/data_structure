package com.dsa.graphs;

import java.util.*;

public class ShortestPathInUnweightedGraph {

    private static Map<Integer,List<Integer>> prepareAdj(int n, int[][] edges){
        Map<Integer,List<Integer>> adj = new HashMap<>();

        for(int i = 1; i<=n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] vertices : edges){
            int u = vertices[0];
            int v = vertices[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }

    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
        //preparing adjacency list
        Map<Integer,List<Integer>> adj = prepareAdj(n, edges);

        //applying bfs
        Map<Integer,Boolean> visited = new HashMap<>();
        Map<Integer,Integer> parent = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <=n; i++) {
            visited.put(i, false);
        }

        //adding source node to the queue
        queue.add(1);

        //keeping parent of the source node as -1
        parent.put(1, -1);

        //marking it as visited
        visited.put(1, true);

        while(!queue.isEmpty()){
            int front = queue.remove();

            //visiting neighbours
            for(int v  : adj.get(front)){
                if(!visited.get(v)){
                    visited.put(v, true);
                    parent.put(v, front);
                    queue.add(v);
                }
            }

        }

        LinkedList ans = new LinkedList<>();

        int currentNode = t;
        ans.add(currentNode);

        while(currentNode!=s){
            currentNode = parent.get(currentNode);
            ans.add(currentNode);
        }



        Collections.reverse(ans);
        return ans;



    }

}