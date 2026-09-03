package Y2026M09;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode217 {

    public class TreeNode {
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

    static class Solution {
        public void flatten(TreeNode root) {
            // 전위순회 힌트 -> 전위순회를 돌면서 트리 구조를 바꿀 수 있을까? 생각하기가 어려움
            // 전위순회를 돌면서 노드들을 전부 Queue 혹은 스택에 넣고 꺼내면서 노드처리를 해보자.
            // Queue로 넣는게 순차적으로 꺼내기가 편해보인다.

            Queue<TreeNode> queue = new ArrayDeque<>();

            dfs(root, queue);

            TreeNode prev = null;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (prev != null) {
                    prev.left = null;
                    prev.right = node;
                }
                prev = node;
            }

        }

        void dfs(TreeNode node, Queue<TreeNode> queue) {
            if (node == null) return;

            queue.offer(node);

            dfs(node.left, queue);
            dfs(node.right, queue);
        }
    }
}
