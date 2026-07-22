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
            // l1 노드와 l2 노드를 합산하여 current.next에 넣는다.
            int addNumber = 0;
            while (l1 != null && l2 != null) {
                int additionalNumber = addNumber;
                if (addNumber > 0){
                    addNumber--;
                }
                current.next = new ListNode((l1.val + l2.val + additionalNumber) % 10);
                if ((l1.val + l2.val + additionalNumber) / 10 > 0) {
                    addNumber++;
                }
                l1 = l1.next;
                l2 = l2.next;
                current = current.next;
            }

            while (l1 != null) {
                int additionalNumber = addNumber;
                if (addNumber > 0){
                    addNumber--;
                }
                current.next = new ListNode((l1.val + additionalNumber) % 10);
                if ((l1.val + additionalNumber) / 10 > 0) {
                    addNumber++;
                }
                l1 = l1.next;
                current = current.next;
            }


            while (l2 != null) {
                int additionalNumber = addNumber;
                if (addNumber > 0){
                    addNumber--;
                }
                current.next = new ListNode((l2.val + additionalNumber) % 10);
                if ((l2.val + additionalNumber) / 10 > 0) {
                    addNumber++;
                }
                l2 = l2.next;
                current = current.next;
            }
            if (addNumber > 0) {
                current.next = new ListNode(addNumber);
            }
            // (l1 + l2) % 10 은 current.next에 넣고 (l1 + l2) / 10 > 0 이면
            // 다음 node 계산시 1를 첨가 해주거나 다음 노드가 없을시 next에 새로 생성해준다.

            return dummy.next;
        }
    }

}
