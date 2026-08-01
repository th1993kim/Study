package Y2026M07;

public class NeetCode68 {
    static class Solution {
        public int jump(int[] nums) {
            int jump = 0;
            int currentEnd = 0;
            int nextEnd = 0;

            for (int i = 0; i < nums.length - 1; i++) {

                nextEnd = Math.max(nextEnd, i + nums[i]);
                if (currentEnd == i) {
                    jump++;
                    currentEnd = nextEnd;
                }
            }

            return jump;
        }
    }

}
