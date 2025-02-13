package com.dsa.graphs;
import java.util.*;

public class AdjacencyList {

    private static Map<Integer, List<Integer>> adj;


   public static Map<Integer,List<Integer>> prepare(int[][] edges,int v, boolean isUndirected, int vertexStartIndex, boolean isZeroBasedIndex){
       adj = new HashMap<>();

       int startIndex = vertexStartIndex;

       //putting arraylist at each index
       for(int i = startIndex; isZeroBasedIndex? i<v : i<=v ; i++ ){
           adj.put(i, new ArrayList<>());
       }

       for(int[] vertexes :  edges){
           int u = vertexes[0];
           int w = vertexes[1];

           adj.get(u).add(w);

           // checking if is it undirected or not
           if(isUndirected){
               adj.get(w).add(u);
           }
       }

       return adj;
   }

}
