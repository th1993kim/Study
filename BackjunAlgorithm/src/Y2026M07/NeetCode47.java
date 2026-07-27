package Y2026M07;

public class NeetCode47 {

    static class WordDictionary {

        private static class WordNode {
            private WordNode[] child = new WordNode[52];
            private boolean isEnd;
        }

        private final WordNode root;

        public WordDictionary() {
            root = new WordNode();
        }

        public void addWord(String word) {
            WordNode current = root;

            for (char ch : word.toCharArray()) {
                int index = findIndex(ch);
                if (current.child[index] == null) {
                    current.child[index] = new WordNode();
                }

                current = current.child[index];
            }

            current.isEnd = true;
        }

        private int findIndex(char ch) {
            if ('a' <= ch && ch <= 'z') return ch - 'a';

            return ch - 'A';
        }

        public boolean search(String word) {
            return dfs(root, word, 0);
        }

        private boolean dfs(WordNode node, String word, int index) {
            if (index == word.length()) return node.isEnd;

            char ch = word.charAt(index);

            WordNode current = node;

            if ('.' == word.charAt(index)) {
                for (WordNode cl : current.child) {
                    if (cl != null && dfs(cl, word, index + 1)) return true;
                }

                return false;
            }


            int idx = findIndex(word.charAt(index));
            if (current.child[idx] == null) return false;

            current = current.child[idx];

            return dfs(current, word, index + 1);
        }
    }

}
