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

    static class Solution {
        public void reorderList(ListNode head) {
            // 먼저 list의 길이를 구하고 /2를 진행한다음, 반으로 자르고 후위노드들을 역순으로 바꾼다.
            // 조금 더 쉬운생각은 반으로 자르고 나서 뒤에는 스택에 저장한뒤, 스택만큼 돌면서 재연결을 해준다.


            int size = 0;
            ListNode current = head;
            while (current != null) {
                current = current.next;
                size++;
            }

            int cutPosition = size / 2;
            Stack<ListNode> stack = new Stack<>();
            ListNode cutNode = head;
            for (int i = 0; i < size; i++) {
                if (cutPosition <= i) {
                    stack.add(cutNode);
                }
                cutNode = cutNode.next;
            }

            ListNode newNode = head;

            while(newNode != null && !stack.isEmpty()) {
                ListNode next = newNode.next;
                ListNode node = stack.pop();
                newNode.next = node;
                node.next = next;
                newNode = next;
                if (stack.isEmpty()) {
                    node.next = null;
                }
            }

        }
    }
}
