package Y2026M07;

public class NeetCode66 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            // 그냥 막연하게 현재 num까지 더했을때 0 이하면 부분배열을 종료하면 어떨까?
            int answer = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                int current = nums[i];
                if (sum + current < current) {
                    sum = current;
                } else {
                    sum += current;
                }
                answer = Math.max(sum, answer);
            }

            return answer;
        }
    }

}
