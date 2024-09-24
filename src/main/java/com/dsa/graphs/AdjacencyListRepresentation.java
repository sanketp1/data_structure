package com.dsa.graphs;
import java.util.*;


public class AdjacencyListRepresentation{
    static class Edge{
        
        int src;
    
        int dest;

        //weight of the edge
        // int wt;
        
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
            // this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graphs){
        for(int i =0; i<graphs.length; i++){
            graphs[i] = new ArrayList<Edge>();
        }

        // vertex:- 0
        graphs[0].add(new Edge(0, 1));
        graphs[0].add(new Edge(0, 2));
        
        //vertex:- 1
        graphs[1].add(new Edge(1, 3));

        //vertex:- 2
        graphs[2].add(new Edge(2,0));
        graphs[2].add(new Edge(2, 4));

        //vertext:- 3
        graphs[3].add(new Edge(3, 1));
        graphs[3].add(new Edge(3, 4));
        graphs[3].add(new Edge(3, 5));

        //vertex:- 4
        graphs[3].add(new Edge(4, 2));
        graphs[3].add(new Edge(4, 3));
        graphs[3].add(new Edge(4, 5));

        //vertex:- 5
        graphs[5].add(new Edge(5, 3));
        graphs[5].add(new Edge(5, 4));
        graphs[5].add(new Edge(5, 6));

        //vertex:- 6
        graphs[6].add(new Edge(6, 5));



    }

    public static void bfs(ArrayList<Edge>[] graphs, boolean[] visited){

        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!visited[curr]){
                System.out.print(curr+" ");
                visited[curr] = true;

                //adding all the neighbours of curr in the queue
                for(int i =0; i<graphs[curr].size(); i++){
                    Edge e = graphs[curr].get(i);
                    q.add(e.dest);
                }

            }
        }
        System.out.println();
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited){
        if(visited[curr]) return;

        System.out.print(curr+" ");
        visited[curr] = true;
        
        for(int i =0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            dfs(graph, e.dest, visited);
        }
    }

    public static void main(String[] args){
        int v = 7;
        ArrayList<Edge>[]  graphs = new ArrayList[v];
           
           //we are going to create this graph

            /*
                  1---------3
                 /          |\
                /           | \
               0            |  5
                \           | / \
                 \          |/   \
                  2---------4     6 
             */

        //creating graph
        createGraph(graphs);
        // boolean

        System.out.println("Breadth First Search: ");
        bfs(graphs, new boolean[v]);

        System.out.println("Depth First Search: ");
        dfs(graphs, 0, new boolean[v]);


        // System.out.println("\nNeighbours of vertex: 2");

        //accessing all the neighbours of 2
        // for(int i =0; i<graphs[2].size(); i++){
        //     Edge e = graphs[2].get(i);
        //     System.out.print(e.dest+" ");
        // }

        // System.out.println("\n\nWeights of Edges from vertex: 2");
        // for (int x = 0; x < graphs[2].size(); x++) {
        //     Edge e = graphs[2].get(x);
        //     System.out.println(e.src+"--->"+e.dest+" : "+e.wt);
        // }


    }
}