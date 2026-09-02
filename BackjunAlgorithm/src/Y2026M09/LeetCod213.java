package Y2026M09;

public class LeetCod213 {

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

        TreeNode first = null;
        TreeNode prev = null;
        TreeNode second = null;
        public void recoverTree(TreeNode root) {
            // 중위 순회 기법을 이용한다.
            // 중위순회라는 것은 BST에서 동작하였을때  왼 -> 중 -> 오 의 흐름으로 오름차순을 보장한다.
            // 여기서 첫번째로 깨졌을때의 prev값이 큰값이므로 first에 넣어주고
            // node 값은 second로 넣어주지만, 이때 node값이 정확하게 오름차순으로 증가하는 위치일 수 있기 때문에
            // 뒤에있는 노드들의 오름차순을 점검해보면서 갱신을진행해준다.

            middleOrder(root);

            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        void middleOrder(TreeNode node) {
            if (node == null) return;
            middleOrder(node.left);
            //중위 순회를 이용할 때 node.left를 선행하기때문에 prev가 비어있을 수 있다.
            if (prev != null && prev.val > node.val) {
                if (first == null) {
                    first = prev;
                }
                second = node;
            }
            // 가장 왼쪽부터 시작하기때문에 왼쪽 자신을 거치게 된다면 prev = 현재노드가 된다.
            prev = node;

            middleOrder(node.right);
        }
    }
}
