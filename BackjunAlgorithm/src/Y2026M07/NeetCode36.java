package Y2026M07;

public class NeetCode36 {


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

        boolean result = true;
        public boolean isBalanced(TreeNode root) {
            // root 의 left, right 뎁스를 구하고 비교한다.
            if (root == null) return true;

            calculateDepth(root);

            return result;
        }

        private int calculateDepth(TreeNode root) {
            if (root == null) return 0;
            int leftDepth = calculateDepth(root.left);
            int rightDepth = calculateDepth(root.right);
            if (Math.abs(leftDepth - rightDepth) > 1) result = false;
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

}
