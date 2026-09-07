package Y2026M09;

import java.util.Arrays;

public class LeetCode234 {
    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            // 아까와 비슷한문제 , 장애물 (1)을 만나면 해당 값을 0으로 하면 되지 않을까?
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];

            for (int i = 0; i < n; i++) {
                if (i > 0 && dp[0][i-1] == 0) break;
                dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : 1;
            }

            for (int i = 0; i < m; i++) {
                if (i > 0 && dp[i-1][0] == 0) break;
                dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i-1][j] + dp[i][j-1];
                }
            }

            return dp[m-1][n-1];
        }
    }
}
