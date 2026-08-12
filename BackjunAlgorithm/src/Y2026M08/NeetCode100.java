package Y2026M08;

public class NeetCode100 {
    static class Solution {
        public int missingNumber(int[] nums) {

            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                result ^= i;
                result ^= nums[i];
            }

            result ^= nums.length;

            return result;
        }
    }

}
