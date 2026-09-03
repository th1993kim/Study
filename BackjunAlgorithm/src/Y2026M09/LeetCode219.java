package Y2026M09;

public class LeetCode219 {
    static class Solution {
        public int maxSubArray(int[] nums) {

            int answer = nums[0];
            int current = nums[0];
            // current를 현재 요소로 할것이냐, 현재까지 누적합으로 할것이냐로 두자.
            for (int i = 1; i < nums.length; i++) {
                current = Math.max(nums[i], current + nums[i]);
                answer = Math.max(answer, current);
            }
            return answer;
        }
    }
}
