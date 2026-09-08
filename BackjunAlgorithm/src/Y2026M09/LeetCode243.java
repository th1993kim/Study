package Y2026M09;

public class LeetCode243 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // left전의 노드와 => right와 연결
            // right후의 노드 정보를 알고 => left와 연결
            // left부터 right노드까지 역정렬해준다.

            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode previousLeft = dummy;
            for (int i = 1; i < left; i++) {
                previousLeft = previousLeft.next;
            }

            ListNode prev = null;
            ListNode current = previousLeft.next;
            ListNode leftNode = current;
            for (int i = 0; i <= right - left; i++) { // 현재노드부터 시작 4-2의 경우 2,3,4를 시행해야한다. 그러므로 포함관계가된다.
                ListNode next = current.next;
                current.next = prev;

                prev = current;
                current = next;
            }

            previousLeft.next = prev;
            leftNode.next = current;

            return dummy.next;
        }
    }
}
