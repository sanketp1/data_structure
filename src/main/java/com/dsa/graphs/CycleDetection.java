package com.dsa.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CycleDetection {

    public static boolean detectCycleUsingDFS(int sourceNode, Map<Integer, List<Integer>> adj, Map<Integer, Boolean> visited, Map<Integer, Boolean> dfsVisited) {
        visited.put(sourceNode, true);
        dfsVisited.put(sourceNode, true);

        for (int neighbor : adj.get(sourceNode)) {
            if (!visited.get(neighbor)) {
                boolean isCycleDetected = detectCycleUsingDFS(neighbor, adj, visited, dfsVisited);
                if (isCycleDetected) {
                    return true;
                }
            } else if (dfsVisited.get(neighbor)) {
                // If neighbor is in dfsVisited, a cycle is detected
                return true;
            }
        }

        String abc = "hakjdhkasd";



        dfsVisited.put(sourceNode, false); // Backtracking
        return false;
    }

    public static boolean isCycleInGraph(int n, Map<Integer, List<Integer>> adj) {
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Boolean> dfsVisited = new HashMap<>();

        // Initialize visited maps
        for (int i = 1; i <= n; i++) {
            visited.put(i, false);
            dfsVisited.put(i, false);
        }

        // Check for cycles in each component of the graph
        for (int i = 1; i <= n; i++) {
            if (!visited.get(i)) {
                if (detectCycleUsingDFS(i, adj, visited, dfsVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 3}, // This edge creates a cycle among nodes 1, 2, and 3
                {3, 4},
                {4, 5}
        };

        Map<Integer, List<Integer>> adjList = AdjacencyList.prepare(edges, n, false, 1, false); // Assume this is your method for preparing the adjacency list

        System.out.println(adjList);

        boolean isCyclePresent = isCycleInGraph(n, adjList);

        System.out.print("Is cycle present: ");
        if (isCyclePresent) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
