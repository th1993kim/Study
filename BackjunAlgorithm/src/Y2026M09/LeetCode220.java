package Y2026M09;

public class LeetCode220 {

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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // preOrder의 첫번째는 root
            // InOrder가 root까지 가는데의 사이즈가 왼쪽 노드의 크기
            // 이를 기준으로 좌우를 나누어서 노드를 만들어주면 진행이 가능하다.
            // leftSize = inStart - rootIndex
            // 좌우를 나누는 기준 preOrder => left = preStart + 1, preStart + leftSize , | preStart + leftSize + 1, preEnd)
            // inOrder => left = inStart, rootIndex - 1, rootIndex + 1 , inEnd
            return tree(preorder,
                    0,
                    preorder.length - 1,
                    inorder,
                    0,
                    inorder.length - 1
            );

        };

        TreeNode tree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }
            int rootValue = preorder[preStart];
            TreeNode root = new TreeNode(rootValue);

            int target = inStart;

            while (inorder[target] != rootValue) {
                target++;
            }

            int leftSize = target - inStart;

            root.left = tree(
                    preorder, preStart + 1, preStart + leftSize,
                    inorder, inStart, target - 1
            );

            root.right = tree(
                    preorder, preStart + leftSize + 1, preEnd,
                    inorder, target + 1, inEnd
            );


            return root;
        }
    }
}
