package Y2026M09;

public class LeetCode209 {
    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            // 부분배열을 구하는 문제, 부분배열을 구할때는 Sliding Window, Two Pointer, Prefix Sum을 이용할 수 있다.
            // Sliding Window 기법을 사용하려면 모든 변화가 예측이 가능해야할 수 있다. (ex.모든 값이 양수)

            int answer = Integer.MAX_VALUE;
            // 0개부터 N개까지의 합을 저장
            int n = nums.length;
            int[] prefixSum = new int[n + 1];

            for (int i = 0; i < n; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }

            // prefixSum[right] - prefixSum[left] 를 하게 되면 특정 구간의 누적합을 구할 수 있다.
            // ex prefixSum[5] - prefixSum[0] --> num[4] ~ num[0] 까지의 합
            // prefixSum[5] - prefixSum[1] --> num[1] ~ num[4] 까지의
            // 누적합으로 오름차순이 보장되어있기때문에 이를 이용한 Binary Search를 이용할 있다.

            for (int left = 0; left < n; left++) {
                // prefixSum[left]는 빼야할 구간이기때문에 최소 left + 1부터 시작해야한다.
                int lp = left + 1;
                int rp = n;
                // prefixSum[right]  >= target + prefixSum[left] 만큼 값이 되는 목표치를 찾는다.
                int required = target + prefixSum[left];
                while (lp <= rp) {

                    int mid = (lp + rp) / 2;
                    int sum = prefixSum[mid];

                    if (sum >= required) {
                        answer = Math.min(answer, mid - left);
                        rp = mid - 1;
                    } else {
                        lp = mid + 1;
                    }

                }

            }

            return answer == Integer.MAX_VALUE ? 0 : answer;
        }
    }
}
