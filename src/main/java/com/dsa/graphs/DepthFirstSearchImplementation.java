package com.dsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthFirstSearchImplementation {


    private static  void dfs(int sourceNode, List<Integer> result, Map<Integer,List<Integer>> adj, Map<Integer,Boolean> visited){

        // adding source node to bfs result
        result.add(sourceNode);

        //marking it as visited
        visited.put(sourceNode,true);

        // now visiting neighbour node
        for(int i : adj.get(sourceNode)){
            if(!visited.get(i)){
                dfs(i,result,adj, visited);
            }
        }
    }

    public static List<Integer> dfsTraversal(int n,int[][] edges){
        //storing result of bfs sequence in list of integer
        List<Integer> result = new ArrayList<>();

        //preparing adjacency list from edges
        Map<Integer,List<Integer>> adjList = AdjacencyList.prepare(edges,n, true,1,false);

        //keeping track of visited node
        Map<Integer,Boolean> visited = new HashMap<>();

        for(int i = 1; i<=n; i++){
            visited.put(i,false);
        }

        for(int i = 1; i<=n; i++){
            if(!visited.get(i)){
                dfs(i,result,adjList,visited);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 8;

        int[][] edges = {
                {1,2}, {1,3}, {2,4}, {2,5}, {3,6}, {3,7},
                {4,8}, {5,8},{6,8},{7,8}
        };

        List<Integer> result = dfsTraversal(n,edges);

        System.out.println("DFS Sequence:- "+result);

    }

}
