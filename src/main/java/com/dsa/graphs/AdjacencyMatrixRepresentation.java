package com.dsa.graphs;

public class AdjacencyMatrixRepresentation {

    /// Adjacency Matrix
    private int[] adjMatrix;

    /// Number of vertices
    private int vertex;

    /// Number of edges
    private int edge;

    public AdjacencyMatrixRepresentation(){
        // by default keeping size of adjacency matrix to 10
        this.adjMatrix = new int[10];
    }

    /// method for checking whether current graph is empty or not
    /// return boolean value if graph is empty then returns true otherwise false
    public boolean isEmpty(){
        // TODO: implement logic for checking is graph empty or not
        return false;
    }

    /// method for inserting vertex
    public void insertVertex(int u, int v){}

    /// method for inserting edge
    public void insertEdge(int u){}

    /// method for deleting vertex
    public void deleteVertex(int u, int v){}

    /// method for deleting edge
    public void deleteEdge(int u){}
}
 