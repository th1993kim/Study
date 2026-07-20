package Y2026M07;

import java.util.Stack;

public class NeetCode20 {
    static class Solution {
        public int maxProfit(int[] prices) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < prices.length; i++) {
                stack.add(prices[i]);
            }


            int answer = 0;
            int max = stack.pop();
            while (!stack.isEmpty()) {
                int nx = stack.pop();
                if (nx < max) {
                    answer = Math.max(answer, max - nx);
                }
                max = Math.max(max, nx);
            }

            return answer;
        }
    }

}
