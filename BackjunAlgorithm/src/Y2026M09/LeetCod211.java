package Y2026M09;

public class LeetCod211 {
    static class Solution {
        public int numTrees(int n) {

            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            // 여기서 dp는 n일때 완성할 수 있는 트리의 개수
            // dp[2] = dp[0] * dp[1] , dp[1] * dp[0]
            // dp[2] = 2 * dp[0] * dp[1]
            // dp[3] = dp[0] * dp[2] +  dp[1] * dp[1] + dp[2] * dp[0]
            // dp 점화식을 만들때 간단하게 만들수 있지 않다. N을 작게하면서부터 만들어나아간다면 쉽게 답에 도달할 수 있다.

            for (int nodeCount = 2; nodeCount <= n; nodeCount++) {
                // root가 2로 변경될것까지 생각하면 아래와같은 범위가 될 수 있다.
                for (int root = 1; root <= nodeCount; root++) {
                    int left = root - 1;
                    int right = nodeCount - root;
                    dp[nodeCount] += dp[left] * dp[right];
                }
            }
            return dp[n];
        }


    }
}
