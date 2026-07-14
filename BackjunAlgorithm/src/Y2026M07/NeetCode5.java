package Y2026M07;

import java.util.Stack;

public class NeetCode5 {

    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> stack = new Stack<>();
            int[] answer = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty()) {
                        if (temperatures[stack.peek()] < temperatures[i]) {
                            Integer index = stack.pop();
                            answer[index] = i - index;
                        } else {
                            break;
                        }
                    }
                }
                stack.push(i);
            }
            return answer;
        }

    }
}
