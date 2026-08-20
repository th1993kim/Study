package Y2026M08;

import java.util.HashMap;
import java.util.Map;

public class NeetCode107 {

    static class Solution {
        Map<String, Integer> memo;
        public int findTargetSumWays(int[] nums, int target) {
            memo = new HashMap<>();
            return dfs(nums, target, 0, 0);
        }

        private int dfs(int[] nums, int target, int index, int sum) {
            if (index == nums.length) {
                return sum == target ? 1 : 0;
            }

            String key = index + "," + sum;
            if (memo.containsKey(key)) return memo.get(key);


            int plus = dfs(
                    nums,
                    target,
                    index + 1,
                    sum + nums[index]
            );

            int minus = dfs(
                    nums,
                    target,
                    index + 1,
                    sum - nums[index]
            );

            int result = plus + minus;
            memo.put(key, result);

            return result;
        }
    }

}
