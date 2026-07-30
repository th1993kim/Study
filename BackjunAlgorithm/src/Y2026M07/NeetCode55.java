package Y2026M07;

import java.util.ArrayList;
import java.util.List;

public class NeetCode55 {

    static class Solution {

        List<List<Integer>> answer = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] nums, int target) {
            dfs(0, 0, 0, new ArrayList<>(), nums, target);
            return answer;
        }

        private void dfs(int length, int index, int sum, List<Integer> subSet, int[] nums, int target) {
            if (sum == target) {
                answer.add(new ArrayList<>(subSet));
            }
            if (sum > target) {
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (index <= i) {
                    subSet.add(nums[i]);
                    dfs(length + 1, i, sum + nums[i], subSet, nums, target);
                    subSet.remove(subSet.size() - 1);
                }
            }
        }
    }

}
