package Y2026M09;

import java.util.Arrays;

public class LeetCode234 {
    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            // 아까와 비슷한문제 , 장애물 (1)을 만나면 해당 값을 0으로 하면 되지 않을까?
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];

            if (obstacleGrid[0][0] == 1) return 0;

            dp[0][0] = 1;

            for (int i = 1; i < n; i++) {
                if (obstacleGrid[0][i] == 0) {
                    dp[0][i] = dp[0][i-1];
                }
            }

            for (int i = 1; i < m; i++) {
                if (obstacleGrid[i][0] == 0) {
                    dp[i][0] = dp[i-1][0];
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 0) {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }

            return dp[m-1][n-1];
        }
    }
}
