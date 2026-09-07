package Y2026M09;

import java.util.Arrays;

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
            int[] dp = new int[n];
            Arrays.fill(dp, 1);

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[j] = dp[j-1] + dp[j];
                }
            }

            return dp[n-1];
        }
    }
}
