package Y2026M09;

public class LeetCode239 {
    static class Trie {

        private Trie[] tries;
        private boolean isEnd;

        public Trie() {
            tries = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie trie = this;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (trie.tries[index] == null) {
                    trie.tries[index] = new Trie();
                }

                trie = trie.tries[index];
            }
            trie.isEnd = true;
        }

        public boolean search(String word) {
            Trie trie = this;
            for (char ch : word.toCharArray()) {
                Trie child = trie.tries[ch - 'a'];
                if (child == null) return false;

                trie = child;
            }

            return trie.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie trie = this;
            for (char ch : prefix.toCharArray()) {
                Trie child = trie.tries[ch - 'a'];
                if (child == null) return false;

                trie = child;
            }
            return true;
        }
    }
}
