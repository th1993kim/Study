package Y2026M09;

public class LeetCode232 {
    static class Solution {
        public boolean canJump(int[] nums) {
            // dp[i] = 해당 위치까지 도달 가능 여부
            // dp[0] = 1
            // dp[i]를 순회하면서 1인 경우 해당 nums[i] 만큼 또다시 순회해서 dp[i]들을 진행하는건 어떨까?
            int n = nums.length;
            boolean[] dp = new boolean[n];
            dp[0] = true;

            for (int i = 0; i < dp.length; i++) {
                if (dp[i]) {
                    int max = Math.min(n-1, i + nums[i]);
                    for (int j = i + 1; j <= max; j++) {
                        dp[j] = true;
                    }
                }
            }

            return dp[n-1];
        }
    }
}
