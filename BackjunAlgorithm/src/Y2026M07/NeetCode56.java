package Y2026M07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NeetCode56 {
    static class Solution {

        private List<List<Integer>> answer;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            answer = new ArrayList<>();

            Arrays.sort(candidates);
            dfs(0, 0, new ArrayList<>(), candidates, target);
            return answer;
        }

        private void dfs(int start, int sum, List<Integer> subList, int[] candidates, int target) {

            if (sum == target) {
                answer.add(new ArrayList<>(subList));
                return;
            }
            if (sum > target) {
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (start < i && candidates[i] == candidates[i-1]) {
                    continue;
                }

                int number = candidates[i];
                if (sum + number > target) break;
                subList.add(number);
                dfs(i + 1, sum + number, subList, candidates, target);
                subList.remove(subList.size() - 1);
            }
        }
    }

}
