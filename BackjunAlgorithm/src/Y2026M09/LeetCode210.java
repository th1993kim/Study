package Y2026M09;

public class LeetCode210 {
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            // 본인을 제외한 좌측 곱셈과 우측 곱셈의 곱을 만들면 본인을 제외한 곱을 만들 수 있다.
            int n = nums.length;

            int[] left = new int[n];
            left[0] = 1;
            // left[1] = left[0] * nums[0];
            int[] right = new int[n];
            right[n-1] = 1;
            // right[n-2] = right[n-1] * nums[n-1];
            int[] answer = new int[n];

            for (int i = 1; i < n; i++) {
                left[i] = left[i-1] * nums[i-1];
            }

            for (int i = n-2; i >= 0; i--) {
                right[i] = right[i+1] * nums[i+1];
            }

            for (int i = 0; i < n; i++) {
                answer[i] = left[i] * right[i];
            }


            return answer;
        }
    }
}
