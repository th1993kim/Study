package Y2026M09;

public class LeetCode210 {
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            // 본인을 제외한 좌측 곱셈과 우측 곱셈의 곱을 만들면 본인을 제외한 곱을 만들 수 있다.
            int n = nums.length;

            int[] answer = new int[n];
            answer[0] = 1;
            // answer[0] 는 처음에 왼쪽 곱의 시작 (1이다.) 왜냐하면 아무것도 곱해진게 없기 때문이다.

            for (int i = 1; i < n; i++) {
                answer[i] = answer[i-1] * nums[i-1];
            }


            int right = 1;
            for (int i = n-2; i >= 0; i--) {
                //여기서 right는 이전 숫자를 곱해주면서 진행해주어야한다.
                right = right * nums[i+1];
                // right가 누적곱의 성질을 갖고있기때문에 answer[i]에는 단순히 right를 곱해주면된다.
                answer[i] = answer[i] * right;
            }

            return answer;
        }
    }
}
