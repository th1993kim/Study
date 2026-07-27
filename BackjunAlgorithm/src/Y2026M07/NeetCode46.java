package Y2026M07;

public class NeetCode46 {
    private static class PrefixTree {
        private static class TreeNode {
            private TreeNode[] child = new TreeNode[26];
            private boolean isEnd;
        }

        private final TreeNode root;

        public PrefixTree() {
            root = new TreeNode();
        }

        public void insert(String word) {
            TreeNode current = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (current.child[index] == null) {
                    current.child[index] = new TreeNode();
                }

                current = current.child[index];
            }

            current.isEnd = true;
        }

        public boolean search(String word) {
            TreeNode node = findNode(word);

            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {

            return findNode(prefix) != null;
        }

        private TreeNode findNode(String word) {
            TreeNode current = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (current.child[index] == null) return null;

                current = current.child[index];
            }

            return current;
        }
    }

}
