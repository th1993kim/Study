package Y2026M07;

public class NeetCode37 {


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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null && q != null) {
                return false;
            } else if (p != null && q == null) {
                return false;
            }

            boolean leftResult = isSameTree(p.left, q.left);
            boolean rightResult = isSameTree(p.right, q.right);

            return p.val == q.val && leftResult && rightResult;
        }
    }

}
