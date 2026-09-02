package Y2026M09;

public class LeetCode209 {
    static class Solution {
        int answer;
        public int minSubArrayLen(int target, int[] nums) {
            // 부분배열을 구하는 문제, 부분배열을 구할때는 Sliding Window, Two Pointer, Prefix Sum을 이용할 수 있다.
            // Sliding Window 기법을 사용하려면 모든 변화가 예측이 가능해야할 수 있다. (ex.모든 값이 양수)


            int left = 0;
            int answer = Integer.MAX_VALUE;
            int n = nums.length;
            int sum = 0;
            for (int right = 0; right < n; right++) {
                sum += nums[right];
                while(sum >= target) {
                    answer = Math.min(answer, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }

            return answer == Integer.MAX_VALUE ? 0 : answer;
        }
    }
}
