package com.dsa.graphs;
import java.util.*;

public class BreadthFirstSearchImplementation {

    private  static void bfs(int sourceNode, List<Integer> ans, Map<Integer,List<Integer>> adj, Map<Integer,Boolean> visited){

        Queue<Integer> queue = new LinkedList<>();
        // adding source node to queue
        queue.add(sourceNode);



        //updating front node visited as true
        visited.put(sourceNode,true);

        while(!queue.isEmpty()){
            int frontNode = queue.remove();

            //adding front node to bfs sequence
            ans.add(frontNode);


            //visiting all the neighbours of front node
            for (int neighbour : adj.get(frontNode)){
                if(!visited.get(neighbour)){
                    //adding it to queue
                    queue.add(neighbour);

                    //marking it as visited
                   visited.put(neighbour,true);
                }
            }

        }
    }

    public static List<Integer> bfsTraversal(int n, int[][] edges){
        //storing result of breadth first search sequence
        List<Integer> result = new ArrayList<>();

        //creating adjacency list from provided edges
        Map<Integer, List<Integer>> adjList = AdjacencyList.prepare(edges,n,true,1,false);

        //keeping track of visited nodes
        Map<Integer,Boolean> visited = new HashMap<>();

        for(int i = 1; i<=n; i++){
            visited.put(i,false);
        }

        for (int i = 1; i <=n ; i++) {
            if(!visited.get(i)){
                bfs(i,result,adjList,visited);
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

        List<Integer> result = bfsTraversal(n,edges);

        System.out.println("BFS Sequence:- "+result);

    }

}

