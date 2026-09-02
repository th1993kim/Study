package Y2026M09;

public class LeetCode209 {
    static class Solution {
        int answer;
        public int minSubArrayLen(int target, int[] nums) {
            // 숫자를 낮게 정렬하고
            // 반복문을 돌면서 숫자하나를 고정으로 하고 그 이후 DFS를 통해 숫자들을 선택하면서 target에 도달하는지 체크한다.
            // 길이가 가장 짧은 값이 나올때마다 갱신해준다.

            int n = nums.length;
            answer = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                dfs(i + 1, 1, nums[i], nums, target);
            }

            return answer == Integer.MAX_VALUE ? 0 : answer;
        }

        void dfs(int index, int count, int sum, int[] nums, int target) {

            if (sum >= target) {
                answer = Math.min(answer, count);
                return;
            }
            if (index >= nums.length) {
                return;
            }
            dfs(index + 1, count + 1, sum + nums[index], nums, target);
        }
    }
}
