package Y2026M09;

public class LeetCode219 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            // 1. 분할과 정복
            // 2. DP 적 사고방식

            // left index, right index 좌우측을 쪼개보자/
            return divide(nums, 0, nums.length - 1);
        }

        int divide(int[] nums, int left, int right) {
            if (left == right) return nums[left]; // left와 right가 동일한 경우는 1개짜리 이므로 즉시 반환

            int mid = (left + right) / 2;
            int leftMax = divide(nums, left, mid); // 좌측 경계의 배열
            int rightMax = divide(nums, mid + 1, right); // 우측 경계의 배열
            int crossMax = crossMax(nums, left, mid, right); //크로스된 부분의 배열

            return Math.max(
                    Math.max(leftMax, rightMax),
                    crossMax
            );
        }

        int crossMax(int[] nums, int left, int mid, int right) {
            int leftMax = Integer.MIN_VALUE;

            int sum = 0;
            for (int i = mid; i >= left; i--) {
                sum += nums[i];
                leftMax = Math.max(leftMax, sum);
            }

            int rightMax = Integer.MIN_VALUE;
            sum = 0;

            for (int i = mid+1; i <= right; i++) {
                sum += nums[i];
                rightMax = Math.max(rightMax, sum);
            }

            return leftMax + rightMax;
        }
    }
}
