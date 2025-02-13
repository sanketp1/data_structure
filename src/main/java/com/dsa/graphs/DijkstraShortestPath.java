package com.dsa.graphs;
import java.util.*;

class Node implements Comparable<Node> {
    int v; // vertex
    int w; // weight

    // No-argument constructor for the comparator
    public Node() {}

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.w, other.w);
    }

    @Override
    public String toString() {
        return "Node(vertex = " + v + ", weight = " + w + ")";
    }
}

public class DijkstraShortestPath {

    public static void main(String[] args) {
        int[][] vec = {
                {0, 1, 4},
                {0, 7, 8},
                {1, 2, 8},
                {1, 7, 11},
                {2, 3, 7},
                {2, 5, 4},
                {2, 8, 2},
                {3, 4, 9},
                {3, 5, 14},
                {4, 5, 10},
                {5, 6, 2},
                {6, 7, 1},
                {6, 8, 6},
                {7, 8, 7}
        };

        int vertices = 9;
        int edges = 14;
        int source = 0;

        int[] shortestPathFromSourceToAllNode = dijkstra(vec, vertices, edges, source);

        System.out.println("Shortest Path From Source To All Node : " + Arrays.toString(shortestPathFromSourceToAllNode));
    }

    public static int[] dijkstra(int[][] vec, int vertices, int edges, int source) {
        // Preparing adjacency list
        Map<Integer, List<Node>> adjList = new HashMap<>();

        for (int[] edge : vec) {
            
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());

            adjList.get(u).add(new Node(v, w));
            adjList.get(v).add(new Node(u, w)); // Since it's an undirected graph
        }

        // Initialize distances and visited array
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0; // Distance to the source is 0

        boolean[] visited = new boolean[vertices];

        // Priority queue for processing nodes (min-heap)
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(source, 0)); // Add source with distance 0

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentVertex = current.v;

            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;

            // Process neighbors
            for (Node neighbor : adjList.getOrDefault(currentVertex, new ArrayList<>())) {
                int neighborVertex = neighbor.v;
                int weight = neighbor.w;

                // Relaxation step
                if (!visited[neighborVertex] && distances[currentVertex] + weight < distances[neighborVertex]) {
                    distances[neighborVertex] = distances[currentVertex] + weight;
                    queue.add(new Node(neighborVertex, distances[neighborVertex]));
                }
            }
        }

        return distances;
    }
}
