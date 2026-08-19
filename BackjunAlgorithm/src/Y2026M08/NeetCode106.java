package Y2026M08;

public class NeetCode106 {
    static class Solution {
        public int change(int amount, int[] coins) {
            int dp[] = new int[amount+1];
            // 여기서 dp는 지금까지 나온 코인으로 만들수 있는 금액의 조합의 수
            dp[0] = 1;
            for (int coin : coins) {
                int i = 0;
                while (i + coin <= amount) {
                    if (dp[i] > 0) {
                        int next = i+coin;
                        dp[next] += dp[i];
                    }
                    i++;
                }
            }
            return dp[amount];
        }
    }

}
