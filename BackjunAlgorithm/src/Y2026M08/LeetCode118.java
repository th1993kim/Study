package Y2026M08;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode118 {

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

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> answer = new ArrayList<>();

            // bfs root를 넣고 거기에 존재하는 좌우의 노드들을 넣는방식으로 진행한다.
            Queue<TreeNode> queue = new ArrayDeque<>();
            if (root != null) {
                queue.offer(root);
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> subAnswer = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) continue;
                    subAnswer.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                answer.add(subAnswer);
            }

            return answer;
        }
    }
}
