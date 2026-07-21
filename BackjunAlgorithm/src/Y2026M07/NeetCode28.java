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

            //새로운 노드를 만들어서 연결한다.
            Node temp = head;

            while(temp != null) {
                Node temp2 = new Node(temp.val);
                temp2.next = temp.next;
                temp.next = temp2;
                temp = temp2.next;
            }

            //random을 저장한다.
            temp = head;
            while (temp != null) {
                if (temp.random != null) {
                    temp.next.random = temp.random.next;
                }
                temp = temp.next.next;
            }


            //노드를 분리한다.
            temp = head;
            Node dummy = new Node(0);
            Node res = dummy;
            while (temp != null) {
                Node nextTemp = temp.next.next;
                res.next = temp.next;
                temp.next = nextTemp;
                temp = temp.next;
                res = res.next;
            }


            return dummy.next;
        }
    }

}
