package Y2026M07;

public class NeetCode44 {


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

        int answer = -1;
        int count = 0;
        public int kthSmallest(TreeNode root, int k) {
            if (root == null) return 0;
            dfs(root, k);

            return answer;
        }

        private boolean dfs(TreeNode node, int k) {
            if (node == null) return false;
            if (dfs(node.left, k)) return true;
            count++;
            if (count == k) {
                answer = node.val;
                return true;
            }

            return dfs(node.right, k);
        }
    }

}
