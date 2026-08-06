package Y2026M08;

public class NeetCode89 {
    static class Solution {
        public int maxProduct(int[] nums) {
            int[][] dp = new int[nums.length][2];
            dp[0][0] = nums[0];
            dp[0][1] = nums[0];
            int max = dp[0][0];
            //여기서 [i][0] 는 해당 인덱스번호까지의 배열 최대곱
            //[i][1] 는 배열 최저곱
            for (int i = 1; i < nums.length; i++) {
                // 비교시에는 현재 자신, 이전까지의 최대곱 * 현재곱, 이전까지의 최소곱 * 현재곱 이렇게 해야한다. 음수 * 음수 , 음수 * 양수
                dp[i][0] = Math.max(nums[i], Math.max(dp[i-1][0] * nums[i], dp[i-1][1] * nums[i]));
                dp[i][1] = Math.min(nums[i], Math.min(dp[i-1][0] * nums[i], dp[i-1][1] * nums[i]));
                max = Math.max(dp[i][0], max);
            }

            return max;
        }
    }

}
