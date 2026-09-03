package Y2026M09;

public class LeetCode215 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            // 전체 길이를 구한다.
            // k/length (반복되는 회전수 제거) 수만큼 노드를 이동하고 해당 노드 뒤에는 null로 둔다.
            // 위에 잘려진 노드에서 tail노드를 찾아서 연결해주고 잘려진 노드 첫번째를 반환해준다.
            ListNode dummy = new ListNode();
            dummy.next = head;
            if (head == null) {
                return head;
            }
            int length = 0;
            ListNode realTail = dummy;
            while (realTail.next != null) {
                realTail = realTail.next;
                length++;
            }

            k %= length;

            if (k == 0) {
                return head;
            }

            ListNode tail = head;
            for (int i = 0; i < length - k - 1; i++) {
                tail = tail.next;
            }

            ListNode cutNode = tail.next;

            tail.next = null;
            realTail.next = head;
            return cutNode;
        }
    }
}
