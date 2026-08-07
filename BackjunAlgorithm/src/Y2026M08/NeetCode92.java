package Y2026M08;

public class NeetCode92 {
    static class Solution {
        public boolean canPartition(int[] nums) {
            int total = 0;
            for (int num : nums) {
                total += num;
            }
            if (total % 2 != 0) return false;

            int target = total / 2;
            boolean[] dp = new boolean[target+1];
            dp[0] = true;
            for (int num : nums) {
                for (int i = target; i >= num; i--) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }

            return dp[target];
        }


        private boolean dfs(int index, int sum, int target, int[] nums) {
            if (target == sum) return true;
            if (sum > target || index == nums.length) {
                return false;
            }

            if (dfs(index+ 1, sum + nums[index], target, nums)) return true;

            return dfs(index+ 1, sum, target, nums);

        }
    }

}
