package Y2026M08;

public class NeetCode98 {
    static class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result ^= num;
            }


            return result;
        }
    }

}
