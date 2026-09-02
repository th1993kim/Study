package Y2026M09;

public class LeetCode212 {

    static public class TreeNode {
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
        public boolean isValidBST(TreeNode root) {

            //깊이 우선 탐색방식으로
            //root.val <= root.left.val
            //root.val >= root.right.val 이면 거짓을 반환한다.
            // 더이상 내려갈곳이 없으면 참을 반환한다.
            // 놓친부분, 왼쪽 노드의 경우 상위 부모보다 커지면 되지않고,
            // 오른쪽 노드의 경우 상위 부모보다 커져야한다.
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        boolean dfs(TreeNode node, long min, long max) {
            if (node == null) return true;
            if (node.val <= min || node.val >= max) return false;
            // 굳이 여기서 자식과 부모를 검증할 필요없이, 다음 연산에서 자식노드를 보내고 자식노드의 범위값을 통해 검증해줄 수 있다.
            return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
        }

    }
}
