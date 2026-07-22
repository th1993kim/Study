package Y2026M07;

public class NeetCode34 {


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
        public int maxDepth(TreeNode root) {
            return calculateMaxDepth(root, 0);
        }

        private int calculateMaxDepth(TreeNode root, int depth) {
            if (root == null) return depth;

            return Math.max(calculateMaxDepth(root.left, depth + 1), calculateMaxDepth(root.right, depth + 1));
        }
    }

}
