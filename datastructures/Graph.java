package datastructures;

import java.util.LinkedList;

public class Graph {
    public  int V; // No. of vertices
    public LinkedList<Integer> adj[];  // Array of lists for Adjacency list representation

    //Constructor
    public Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for ( int i=0; i<v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    // Function to add edge in to the graph
    public void addEdge( int v, int w){
        adj[v].add(w); // Add w to v's list
    }
}
