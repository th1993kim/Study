package Y2026M09;

import java.util.ArrayList;
import java.util.List;

public class LeetCode237 {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {

            List<List<Integer>> answer = new ArrayList<>();

            dfs(0, n, k, new ArrayList<>(), answer);
            return answer;
        }

        void dfs(int index, int n, int target, List<Integer> subArr, List<List<Integer>> answer) {
            if (subArr.size() == target) {
                answer.add(new ArrayList<>(subArr));
                return;
            }

            for (int i = index + 1; i <= n; i++) {
                subArr.add(i);
                dfs(i, n, target, subArr, answer);
                subArr.removeLast();
            }
        }
    }
}
