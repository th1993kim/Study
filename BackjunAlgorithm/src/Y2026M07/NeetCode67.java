package Y2026M07;

public class NeetCode67 {
    static class Solution {
        public boolean canJump(int[] nums) {

            // 점프 해서 최대로 간 위치는 다음 징검다리 위치에서 뛸 수 있다.
            int maxIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > maxIndex) {
                    return false;
                }
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }


            return true;
        }
    }

}
