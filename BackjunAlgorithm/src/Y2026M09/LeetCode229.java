package Y2026M09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode229 {
    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            // N개중 1개, N-1개중 한개, 이걸 visited로 해야하나?
            // 정렬을 통해서 이전의 같은 숫자는 방문하지 않도록 해야한다. (동일한 순열이 발생할 수 있음)
            List<List<Integer>> answer = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            Arrays.sort(nums);

            dfs(nums,  visited, new ArrayList<>(), answer);

            return answer;
        }

        void dfs(int[] nums, boolean[] visited, List<Integer> subArr, List<List<Integer>> answer) {
            if (subArr.size() == nums.length) {
                answer.add(new ArrayList<>(subArr));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) continue;
                if (i > 0 && nums[i] == nums[i-1] && visited[i-1]) continue;
                visited[i] = true;
                subArr.add(nums[i]);
                dfs(nums, visited, subArr, answer);
                visited[i] = false;
                subArr.removeLast();
            }
        }
    }
}
