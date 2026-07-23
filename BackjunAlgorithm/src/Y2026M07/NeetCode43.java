package Y2026M07;

public class NeetCode43 {


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
        private static final int MIN_VALUE = -1001;
        private static final int MAX_VALUE = 1001;

        public boolean isValidBST(TreeNode root) {
            return validate(root, MIN_VALUE, MAX_VALUE);
        }

        private boolean validate(TreeNode root, int min, int max) {
            if (root == null) return true;

            if (root.val <= min || root.val >= max) return false;

            return validate(root.left, min ,root.val)
                    && validate(root.right, root.val, max);

        }
    }

}
