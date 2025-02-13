package com.dsa.graphs;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 4},
                {3, 4},
                {4, 5}
        };

        int v = 5;

        //preparing adjacency list
        Map<Integer, List<Integer>> adj = AdjacencyList.prepare(edges, 5, false, 1,false);

        topologicalSort(adj,v);
    }

    private static void dfs(int sourceNode, Map<Integer,List<Integer>> adj, Stack<Integer> stack, Map<Integer,Boolean> visited){
        visited.put(sourceNode,true);

        for(int v : adj.get(sourceNode)){
            if(!visited.get(v)){
                dfs(v,adj, stack, visited);
            }
        }
        stack.add(sourceNode);
    }

    /// Applying modified DFS to find out valid topological sort
    private static void topologicalSort(Map<Integer,List<Integer>> adj, int v){
        //keeping track of visited node
        Map<Integer,Boolean> visited = new HashMap<>();

        for(int i = 1; i<=v; i++){
            visited.put(i,false);
        }
        Stack<Integer> temp = new Stack<>();

        for(int i = 1; i<=adj.size(); i++){
            if(!visited.get(i)){
                dfs(i, adj,temp,visited);
            }
        }

        //printing topological sequence
        System.out.print("Topological Sequence: ");
        while(!temp.isEmpty()){
            System.out.print(temp.pop()+" ");
        }
        System.out.println();

    }

}
