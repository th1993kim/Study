package Y2026M09;

public class LeetCode214 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode first;
            ListNode second;
            ListNode prev = dummy;

            while (prev.next != null && prev.next.next != null) {
                first = prev.next;
                second = first.next;

                first.next = second.next;
                second.next = first;
                prev.next = second;
                prev = first;
            }

            return dummy.next;
        }
    }
}
