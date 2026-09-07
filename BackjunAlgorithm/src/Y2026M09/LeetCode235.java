package Y2026M09;

public class LeetCode235 {
    static class Solution {
        public int minPathSum(int[][] grid) {
            // dp[i][j] => 해당 경로로가기 위한 최소 경로값
            // 어떻게 계산 ? 왼쪽 혹은 위쪽에서 오는 경로 값 + 현재 경로값 중 MIN값으로 계산
            int n = grid.length;
            int m = grid[0].length;
            int[] dp = new int[m];
            dp[0] = grid[0][0];
            for (int i = 1; i < m; i++) {
                dp[i] = dp[i-1] + grid[0][i];
            }

            for (int i = 1; i < n; i++) {
                dp[0] += grid[i][0];
                for (int j = 1; j < m; j++) {
                    dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
                }
            }

            return dp[m-1];
        }
    }
}
