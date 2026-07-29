package Y2026M07;

import java.util.ArrayList;
import java.util.List;

public class NeetCode54 {

    static class Solution {

        private List<List<Integer>> answer = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {

            dfs(0, new ArrayList<>(), nums);

            return answer;
        }

        private void dfs(int index, List<Integer> subSet, int[] nums) {
            if (index == nums.length) {
                answer.add(new ArrayList<>(subSet));
                return;
            }

            dfs(index + 1, subSet, nums);
            subSet.add(nums[index]);
            dfs(index + 1, subSet, nums);
            subSet.remove(subSet.size() - 1);
        }
    }

}
