package Y2026M09;

import java.util.ArrayList;
import java.util.List;

public class LeetCode236 {
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> answer = new ArrayList<>();

            dfs(0, target, candidates, new ArrayList<>(), answer);

            return answer;
        }

        void dfs(int index, int remain, int[] candidates, List<Integer> subArr, List<List<Integer>> answer) {
            if (remain < 0) {
                return;
            }

            if (remain == 0) {
                answer.add(new ArrayList<>(subArr));
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                subArr.add(candidates[i]);
                dfs(i, remain - candidates[i], candidates, subArr, answer);
                subArr.removeLast();
            }
        }
    }
}
