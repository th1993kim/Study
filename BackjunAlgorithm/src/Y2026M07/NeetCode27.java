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
            // 더미 생성
            ListNode dummy = new ListNode(0, head);
            // 현재, N칸앞 노드 생성
            ListNode slow = dummy;
            ListNode fast = dummy;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            // 빠른쪽이 종착하는 위치에서 종료
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }


            // 현재 노드의 다음 연결 노드와 다음다음 노드를 연결
            slow.next = slow.next.next;

            return dummy.next;
        }
    }

}
