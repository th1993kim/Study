package Y2026M08;

public class NeetCode88 {
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            for (int i = 0 ; i < dp.length; i++) {
                dp[i] = amount + 1;
            }
            dp[0] = 0;
            for (int coin : coins) {
                for (int i = 1; i <= amount; i++) {
                    if (i >= coin) {
                        dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                    }
                }
            }

            return dp[amount] > amount ? -1 : dp[amount];
        }
    }

}
