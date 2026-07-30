package Y2026M07;

import java.util.ArrayList;
import java.util.List;

public class NeetCode55 {

    static class Solution {

        List<List<Integer>> answer;

        public List<List<Integer>> combinationSum(int[] nums, int target) {
            answer = new ArrayList<>();
            dfs(0, 0, new ArrayList<>(), nums, target);
            return answer;
        }

        private void dfs(int index, int sum, List<Integer> subSet, int[] nums, int target) {
            if (sum == target) {
                answer.add(new ArrayList<>(subSet));
                return;
            }
            if (sum > target) {
                return;
            }

            for (int i = index; i < nums.length; i++) {
                subSet.add(nums[i]);
                dfs(i, sum + nums[i], subSet, nums, target);
                subSet.remove(subSet.size() - 1);
            }
        }
    }

}
