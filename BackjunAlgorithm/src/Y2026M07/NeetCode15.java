package Y2026M07;

import java.util.HashMap;
import java.util.Map;

public class NeetCode15 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxArea(new int[]{1,7,1,1,1,1,2,5,12,3,500,50,7,8,4,7,38,9,10,12,6});
    }
    static class Solution {
        public int maxArea(int[] heights) {
            int lt = 0;
            int rt = heights.length - 1;
            int answer = 0;
            while (lt < rt) {
                int area = Math.min(heights[lt], heights[rt]) * (rt - lt);
                answer = Math.max(answer, area);

                if (heights[lt] > heights[rt]) {
                    rt--;
                } else {
                    lt++;
                }
            }

            return answer;
        }
    }

}
