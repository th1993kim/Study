package Y2026M09;

public class LeetCode213 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // node를 뒤집은다음에 N번재까지 간후 삭제한다음 다시 뒤집는다면?
            // prev.next = current;
            ListNode copy = new ListNode();
            copy.next = head;
            ListNode slow = copy;
            //quick은 slow보다 n만큼 빨라야한다.
            ListNode quick = copy;

            // 처음에 n까지만 이동하는게 맞지 않나 싶은데, 멈춰야할 위치가 1칸더 앞에 있어야한다
            // 이유는 삭제해야할 대상에서 멈추는게 아니라 삭제야할 대상 앞에칸에 있어야하기 때문이다.
            for (int i = 0; i <= n; i++) {
                quick = quick.next;
            }

            // slow 1에서 시작
            // quick 4에서 시작
            while(quick != null) {
                slow = slow.next;
                quick = quick.next;
            }
            // slow 4에서 종료

            slow.next = slow.next.next;
            return copy.next;
        }
    }
}
