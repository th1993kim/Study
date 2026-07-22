package Y2026M07;

public class NeetCode38 {


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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot != null) return false;
            if (isSameTree(root, subRoot)) return true;

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean isSameTree(TreeNode l, TreeNode r) {
            if (l == null && r == null) {
                return true;
            }

            if (l == null || r == null) {
                return false;
            }

            if (l.val != r.val) {
                return false;
            }

            return isSameTree(l.left, r.left) && isSameTree(l.right, r.right);
        }
    }

}
