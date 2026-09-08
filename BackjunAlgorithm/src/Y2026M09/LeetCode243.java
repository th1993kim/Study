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
            ListNode leftNode = previousLeft.next;
            ListNode rightNode = leftNode;
            for (int i = 0; i < right - left; i++) {
                rightNode = rightNode.next;
            }

            for (int i = 0; i < left - 1; i++) {
                previousLeft = previousLeft.next;
                leftNode = leftNode.next;
                rightNode = rightNode.next;
            }

            ListNode afterRight = rightNode.next;

            reverse(leftNode, right-left);

            previousLeft.next = rightNode;
            leftNode.next = afterRight;

            return dummy.next;
        }

        void reverse(ListNode node, int count) {
            ListNode prev = node;
            ListNode current = node.next;
            for (int i = 0; i < count; i++) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
        }
    }
}
