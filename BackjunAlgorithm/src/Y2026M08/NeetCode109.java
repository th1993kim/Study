package Y2026M08;

public class NeetCode109 {
    static class Solution {

        private Integer[][] memo;

        public int minDistance(String word1, String word2) {
            memo = new Integer[word1.length() + 1][word2.length() + 1];
            return dfs(word1, word2, 0, 0);
        }

        private int dfs(String s1, String s2, int i1, int i2) {

            if (i1 == s1.length()) {
                return s2.length() - i2;
            }

            if (i2 == s2.length()) {
                return s1.length() - i1;
            }

            if (memo[i1][i2] != null) return memo[i1][i2];


            if (s1.charAt(i1) == s2.charAt(i2)) {
                memo[i1][i2] = dfs(s1, s2, i1 + 1, i2 + 1);
                return memo[i1][i2];
            }

            int insert = 1 + dfs(s1, s2, i1, i2 + 1);
            int replace = 1 + dfs(s1, s2, i1 + 1, i2 + 1);
            int delete = 1 + dfs(s1, s2, i1 + 1, i2);

            memo[i1][i2] = Math.min(insert, Math.min(replace, delete));

            return memo[i1][i2];
        }
    }

}
