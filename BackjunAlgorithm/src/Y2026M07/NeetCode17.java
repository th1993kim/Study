package Y2026M07;

public class NeetCode17 {
    static class Solution {
        public int[] productExceptSelf(int[] nums) {


            int[] answer = new int[nums.length];
            int[] leftEx = new int[nums.length];
            int[] rightEx = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    leftEx[i] = 1;
                    rightEx[nums.length - 1] = 1;
                } else {
                    leftEx[i] = leftEx[i-1] * nums[i-1];
                    rightEx[nums.length - i -1] = rightEx[nums.length - i] * nums[nums.length-i];
                }
            }

            for (int i = 0; i < nums.length; i++) {
                answer[i] = leftEx[i] * rightEx[i];
            }

            return answer;
        }
    }

}
