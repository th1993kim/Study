package Y2026M07;

public class NeetCode32 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            // dummy 노드를 생성한다.
            ListNode dummy = new ListNode();
            // current = dummy로 넣는다.
            ListNode current = dummy;
            // l1 노드와 l2 노드를 + 올림수 합산하여 current.next에 넣는다.
            int carry = 0;
            while (l1 != null || l2 != null || carry > 0) {

                int l1Val = l1 == null ? 0 : l1.val;
                int l2Val = l2 == null ? 0 : l2.val;

                int sum = (l1Val + l2Val + carry) % 10;
                carry = (l1Val + l2Val + carry) / 10;
                current.next = new ListNode(sum);

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
                current = current.next;
            }

            return dummy.next;
        }
    }

}
