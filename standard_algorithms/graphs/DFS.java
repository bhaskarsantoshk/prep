package standard_algorithms.graphs;

import datastructures.Graph;

import java.util.Iterator;

public class DFS {
    public static void main(String[] args){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        DFS obj = new DFS();
        //obj.dfs(g);
    }

    private void dfs(Graph g) {
        boolean visited[] = new boolean[g.V];
        for ( int i=0; i<g.V; i++) {
            if ( !visited[i]) {
                DFSUtil(g, i, visited);
            }
        }
    }

    private void DFSUtil(Graph g, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v+" ");
        Iterator<Integer> it = g.adj[v].listIterator();
        while ( it.hasNext() ){
            int n = it.next();
            if ( !visited[n]){
                DFSUtil(g, n, visited);
            }
        }
    }
}
