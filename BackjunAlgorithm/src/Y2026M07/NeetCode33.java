package Y2026M07;

public class NeetCode33 {


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
        public TreeNode invertTree(TreeNode root) {
            // 재귀를 통해서 left와 right를 바꿔주고, 없는 경우는 제외한다.
            if (root == null) return null;

            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = invertTree(right);
            root.right = invertTree(left);


            return root;
        }
    }

}
