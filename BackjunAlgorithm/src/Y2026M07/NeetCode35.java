package Y2026M07;

public class NeetCode35 {

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


    static class Solution {

        int answer = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            calculateDepth(root);
            return answer;
        }

        private int calculateDepth(TreeNode root) {
            if (root == null) return 0;

            int leftDepth = calculateDepth(root.left);
            int rightDepth = calculateDepth(root.right);

            // 길이가 왜 leftDetph + rightDetph 냐면 이미 root에서 한단계 내려온 상태여서 depth만큼만 더해주면 되기 때문이다.
            answer = Math.max(answer, leftDepth + rightDepth);

            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

}
