package Y2026M07;

public class NeetCode16 {

    static class Solution {
        public int trap(int[] height) {
            int lt = 0;
            int rt = height.length - 1;
            int maxLt = 0;
            int maxRt = 0;
            int answer = 0;
            while(lt <= rt) {
                if (maxLt <= maxRt) {
                    maxLt = Math.max(maxLt, height[lt]);
                    answer += Math.max(maxLt - height[lt], 0);
                    lt++;
                } else {
                    maxRt = Math.max(maxRt, height[rt]);
                    answer += Math.max(maxRt - height[rt], 0);
                    rt--;
                }
            }

            return answer;
        }
    }

}
