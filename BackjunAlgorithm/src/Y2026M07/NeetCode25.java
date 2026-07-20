package Y2026M07;

public class NeetCode25 {

    public class ListNode {
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


    static class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (slow != null && fast != null) {
                if (fast.next == null) {
                    return false;
                } else {
                    slow = slow.next;
                    fast = fast.next.next;
                }

                if (slow == fast) {
                    return true;
                }
            }

            return false;
        }
    }


}
