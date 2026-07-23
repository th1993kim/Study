package Y2026M07;

import java.util.HashMap;
import java.util.Map;

public class NeetCode45 {


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

        private int preorderIndex = 0;
        private Map<Integer, Integer> inorderIndexMap;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            inorderIndexMap = new HashMap<>();
            //맵에 앞으로 활용할 수 있는 인덱스를 저장한다.
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }

            return build(preorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int indexLeft, int indexRight) {
            if (indexLeft > indexRight) return null;

            int rootValue = preorder[preorderIndex++];

            TreeNode node = new TreeNode(rootValue);
            int index = inorderIndexMap.get(rootValue);
            node.left = build(preorder, indexLeft, index - 1);
            node.right = build(preorder, index + 1, indexRight);

            return node;
        }


    }

}
