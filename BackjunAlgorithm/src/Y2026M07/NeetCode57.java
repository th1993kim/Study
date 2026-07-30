package Y2026M07;

import java.util.ArrayList;
import java.util.List;

public class NeetCode57 {
    static class Solution {

        private List<List<Integer>> answer;
        private int[] visited;

        public List<List<Integer>> permute(int[] nums) {
            answer = new ArrayList<>();
            visited = new int[21];
            dfs(0, new ArrayList<>(), nums);
            return answer;
        }

        private void dfs(int length, List<Integer> subList, int[] nums) {
            if (length == nums.length) {
                answer.add(new ArrayList<>(subList));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                int visitedNumber = nums[i] + 10;
                if (visited[visitedNumber] == 0) {
                    subList.add(nums[i]);
                    visited[visitedNumber] = 1;
                    dfs(length + 1, subList, nums);
                    subList.remove(subList.size() - 1);
                    visited[visitedNumber] = 0;
                }
            }
        }
    }

}
