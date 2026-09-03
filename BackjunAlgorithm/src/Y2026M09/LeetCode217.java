package Y2026M09;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode217 {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public void flatten(TreeNode root) {
            // 모리스 순회를 사용하면 O(1) 공간을 사용할 수 있다.
            // 모리스 순회법은 가장 오른쪽의 노드가 다음에 가야할 길을 미리 지정해두는 방법이다.

            TreeNode current = root;

            while (current != null) {
                TreeNode left = current.left;
                if (left != null) {
                    TreeNode leftRightMost = left;

                    while (leftRightMost.right != null) {
                        leftRightMost = leftRightMost.right;
                    }
                    leftRightMost.right = current.right;
                    current.right = left;
                    current.left = null;
                }
                current = current.right;
            }

        }
    }
}
