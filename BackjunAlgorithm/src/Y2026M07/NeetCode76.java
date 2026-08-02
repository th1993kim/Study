package Y2026M07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NeetCode76 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    class Solution {
        private Map<Node, Node> nodeMap;

        public Node cloneGraph(Node node) {

            if (node == null) {
                return null;
            }
            nodeMap = new HashMap<>();

            return dfs(node);
        }

        private Node dfs(Node node) {
            if (nodeMap.containsKey(node)) return nodeMap.get(node);
            Node copy = new Node(node.val);
            nodeMap.put(node, copy);
            for (Node child : node.neighbors) {
                copy.neighbors.add(dfs(child));
            }

            return copy;
        }
    }
}
