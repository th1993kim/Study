package Y2026M07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NeetCode58 {
    static class Solution {
        private List<List<Integer>> answer;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            answer = new ArrayList<>();
            dfs(0, new ArrayList<>(), nums);
            return answer;
        }

        private void dfs(int start, List<Integer> subList, int[] nums) {
            answer.add(new ArrayList(subList));

            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i-1]) continue;

                subList.add(nums[i]);
                dfs(i + 1, subList, nums);
                subList.remove(subList.size() - 1);
            }
        }
    }

}
