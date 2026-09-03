package Y2026M09;

import java.util.Stack;

public class LeetCode218 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public void reorderList(ListNode head) {
            // 먼저 list의 길이를 구하고 /2를 진행한다음, 반으로 자르고 후위노드들을 역순으로 바꾼다.
            // 조금 더 쉬운생각은 반으로 자르고 나서 뒤에는 스택에 저장한뒤, 스택만큼 돌면서 재연결을 해준다.


            // 1번안으로 처리해보자 1번이 먼저 떠올랐었어.

            // slow와 fast를 이용하여 중앙 위치 (분리 위치를 찾는다.)

            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // 12345
            // slow 2 3 << 여기서 멈춤
            // fast 3 5 << 여기서 멈춤
            ListNode requireReverse = slow.next;
            slow.next = null;
            ListNode reverse = reverse(requireReverse);

            ListNode current = head;
            // 왼쪽길이 > 오른쪽길이이기때문에 reverse만 하여도되고
            // 만약 왼쪽길이 만큼만 남는다고하여도 이미 위에서 연결을 끊어준 상태이기때문에 순환하지 않는다.
            while (reverse != null) {
                ListNode next = current.next;
                ListNode reverseNext = reverse.next;
                current.next = reverse;
                reverse.next = next;

                current = next;
                reverse = reverseNext;

            }

        }

        private ListNode reverse(ListNode node) {
            ListNode prev = null;
            ListNode current = node;

            while (current != null) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            return prev;
        }
    }
}
