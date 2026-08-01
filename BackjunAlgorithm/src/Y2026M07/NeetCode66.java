package Y2026M07;

public class NeetCode66 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            // 그냥 막연하게 현재 num까지 더했을때 0 이하면 부분배열을 종료하면 어떨까?
            int answer = Integer.MIN_VALUE;
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            answer = dp[0];
            for (int i = 1; i < nums.length; i++) {
                int current = nums[i];
                dp[i] = Math.max(current, dp[i-1] + current);
                answer = Math.max(dp[i], answer);
            }

            return answer;
        }
    }

}
