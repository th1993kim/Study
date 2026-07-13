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

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        int sum = l1.val + l2.val;
        int addVal = sum / 10;

        ListNode nextNode = addTwoNumbers(l1.next, l2.next);
        if (addVal > 0) {
            nextNode = addTwoNumbers(nextNode, new ListNode(addVal));
        }
        return new ListNode(sum % 10, nextNode);
    }
}
