package Y2026M07;

import java.util.Stack;

public class NeetCode3 {

    static class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(val, minStack.isEmpty() ? val : minStack.peek()));
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            if (minStack.isEmpty()) return 0;
            return minStack.peek();
        }
    }

}
