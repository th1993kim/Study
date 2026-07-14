package Y2026M07;

import java.util.Stack;

public class NeetCode4 {
    static class Solution {
        public int evalRPN(String[] tokens) {

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < tokens.length; i++) {

                switch(tokens[i]) {
                    case "+": {
                        stack.push(stack.pop() + stack.pop());
                        break;
                    }
                    case "-": {
                        int back = stack.pop();
                        int front = stack.pop();
                        stack.push(front - back);
                        break;
                    }
                    case "*": {
                        stack.push(stack.pop() * stack.pop());
                        break;
                    }
                    case "/": {
                        int back = stack.pop();
                        int front = stack.pop();
                        stack.push(front / back);
                        break;
                    }
                    default: {
                        stack.push(Integer.valueOf(tokens[i]));
                    }
                }
            }

            return stack.pop();
        }
    }

}
