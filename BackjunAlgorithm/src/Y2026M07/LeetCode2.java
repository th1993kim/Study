package Y2026M07;

public class LeetCode2 {

    public static void main(String[] args) {

    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        addNumbers(l1, l2, 1);
    }

    private ListNode addNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int l1Value = l1 == null ? 0 : l1.val;
        int l2Value = l2 == null ? 0 : l2.val;

        int sum = l1Value + l2Value + carry;

        ListNode listNode = new ListNode(sum % 10);

        listNode.next = addNumbers(
                l1 != null ? l1.next : null,
                l2 != null ? l2.next : null,
                sum / 10);

        return listNode;
    }
}
