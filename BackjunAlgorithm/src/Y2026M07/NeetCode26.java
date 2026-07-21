package Y2026M07;

public class NeetCode26 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    class Solution {
        public void reorderList(ListNode head) {
            // 중앙을 찾는다.
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 연결리스트를 분리한다.
            ListNode twoHead = slow.next;
            slow.next = null;

            ListNode previous = null;
            ListNode current = twoHead;
            while (current != null) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }


            // 두 연결리스트를 순차적으로 합친다.
            ListNode ln = head;
            ListNode rn = previous;
            while (ln != null && rn != null) {
                ListNode lnNext = ln.next;
                ListNode rnNext = rn.next;
                ln.next = rn;
                rn.next = lnNext;
                ln = lnNext;
                rn = rnNext;
            }
        }
    }

}
