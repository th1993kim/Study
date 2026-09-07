package Y2026M09;

public class LeetCode233 {
    static class Solution {
        public int uniquePaths(int m, int n) {
            // dfs
            // 0, 1 -> 1
            // 1, 0 -> 1
            // 1, 1 -> 2
            // 0, 2 -> 1
            // 1, 2 -> 3
            // 위에서 오는 경로 + 왼쪽에서 오는 경로
            int[][] dp = new int[m][n];
            dp[0][0] = 1;
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }

            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }

            return dp[m-1][n-1];
        }
    }
}
