package Y2026M07;

import java.util.HashMap;
import java.util.Map;

public class NeetCode28 {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;

            //인덱스 & Node Map생성한다.
            Node current = head;
            Map<Node, Node> nodeMap = new HashMap<>();
            //반복문을 통해 인덱스 + 노드(depCopy)맵을 만든다.
            Node dummy = new Node(0);
            Node dummyCurrent = dummy;
            while (current != null) {
                dummyCurrent.next = new Node(current.val);
                nodeMap.put(current, dummyCurrent.next);
                dummyCurrent = dummyCurrent.next;
                current = current.next;
            }

            // 다시 한번 반복문을 통해 Map의 노드와 연결짓는다.
            current = head;
            while (current != null) {
                Node newNode = nodeMap.get(current);
                newNode.next = nodeMap.get(current.next);
                newNode.random = nodeMap.get(current.random);
                current = current.next;
            }

            return dummy.next;
        }
    }

}
