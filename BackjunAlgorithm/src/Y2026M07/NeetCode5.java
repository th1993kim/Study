package Y2026M07;

import java.util.Stack;

public class NeetCode5 {

    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Temp> stack = new Stack<>();
            int[] answer = new int[temperatures.length];
            for (int i = 0 ; i < temperatures.length; i++) {
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty()) {
                        if (stack.peek().temp < temperatures[i]) {
                            Temp temp = stack.pop();
                            answer[temp.index] = i - temp.index;
                        } else {
                            break;
                        }
                    }
                }
                stack.push(new Temp(temperatures[i], i));
            }
            return answer;
        }

        static class Temp {
            int temp;
            int index;
            public Temp(int temp, int index) {
                this.temp = temp;
                this.index = index;
            }
        }
    }

}
