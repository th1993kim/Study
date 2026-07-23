package Y2026M07;

public class NeetCode42 {

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
        int answer = 0;
        public int goodNodes(TreeNode root) {
            dfs(root, -101);

            return answer;
        }

        private void dfs(TreeNode node, int max) {
            if (node == null) return;
            if (node.val >= max) {
                answer++;
            }
            int nextMx = Math.max(node.val, max);
            dfs(node.left, nextMx);
            dfs(node.right, nextMx);
        }
    }

}
