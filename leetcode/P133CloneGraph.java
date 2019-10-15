package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P133CloneGraph {
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node) {
        if ( node == null ){
            return null;
        }
        if ( map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        map.put( node.val, clone);
        for ( Node neighbour : node.neighbors){
            clone.neighbors.add(dfs( neighbour));
        }
        return clone;
    }
}
