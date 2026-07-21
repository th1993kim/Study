package Y2026M07;

public class NeetCode27 {


    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 역정렬
            ListNode previous = null;
            ListNode current = head;
            while (current != null) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            // N만큼 깊이 탐색
            ListNode newHead = previous;
            ListNode twoHead = newHead;
            previous = null;
            for (int i = 0; i < n - 1; i++) {
                previous = twoHead;
                twoHead = twoHead.next;
            }
            // 이전노드와 다음노드를 연결
            if (previous != null) {
                previous.next = twoHead.next;
            } else {
                newHead = twoHead.next;
            }
            twoHead.next = null;

            // 다시 역정렬
            previous = null;
            current = newHead;
            while (current != null) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            return previous;
        }
    }

}
