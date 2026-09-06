package Y2026M09;

import java.util.ArrayList;
import java.util.List;

public class LeetCode228 {

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

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            // root부터 시작하여 sum과 List를 누적해나아간다.
            // list누적방식은 백트래킹으로 하는방법이 지금 당장 생각난다.
            // 만약 노드가 null이면 아무것도 해주지 않고 진행한다.
            List<List<Integer>> answer  = new ArrayList<>();
            dfs(targetSum, root, new ArrayList<>(), answer);

            return answer;
        }

        void dfs(int remain, TreeNode node, List<Integer> subArr, List<List<Integer>> answer) {
            if (node == null) return;

            int newRemain = remain - node.val;
            subArr.add(node.val);
            if (node.left == null && node.right == null && newRemain == 0) answer.add(new ArrayList<>(subArr));

            dfs(newRemain, node.left, subArr, answer);
            dfs(newRemain, node.right, subArr, answer);

            subArr.removeLast();
        }
    }
}
