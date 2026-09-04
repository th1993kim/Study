package Y2026M09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode222 {
    static class Node {
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

    static class Solution {
        public Node cloneGraph(Node node) {
            // 재귀를 통해 카피하면 되지 않을까? 이웃 노드가 있는 경우 이웃노드들을 순회하면서 역시 카피해주면 된다.
            Map<Node, Node> copyMap = new HashMap<>();
            return deepCopy(node, copyMap);
        }

        Node deepCopy(Node node, Map<Node, Node> copyMap) {
            if (node == null) return null;
            if (copyMap.get(node) != null) return copyMap.get(node);

            Node copy = new Node(node.val);
            copyMap.put(node, copy);

            node.neighbors.forEach(neighbor -> {
                copy.neighbors.add(deepCopy(neighbor, copyMap));
            });

            return copy;
        }
    }
}
