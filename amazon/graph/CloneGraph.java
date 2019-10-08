package amazon.graph;

import java.util.HashMap;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        if ( node == null ){
            return null;
        }
        if ( map.containsKey(node.label)){
            return map.get(node.label);
        }
        else{
            UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
            map.put(node.label, clone);
            for ( int i=0; i<node.neighbors.size(); i++){
                clone.neighbors.add(dfs( node.neighbors.get(i), map));
            }
            return clone;
        }
    }
}
