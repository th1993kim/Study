package Y2026M07;

public class NeetCode17 {
    static class Solution {
        public int[] productExceptSelf(int[] nums) {


            int n = nums.length;
            int[] answer = new int[n];

            answer[0] = 1;
            for (int i = 1; i < n; i++) {
                answer[i] = answer[i-1] * nums[i-1];
            }

            int rightEx = 1;
            for (int i = n -2; i >= 0; i--) {
                rightEx = rightEx * nums[i+1];
                answer[i] = answer[i] * rightEx;
            }

            return answer;

        }
    }

}
