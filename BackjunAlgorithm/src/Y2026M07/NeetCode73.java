package Y2026M07;

import java.util.Stack;

public class NeetCode73 {
    static class Solution {
        public boolean checkValidString(String s) {
            Stack<Integer> openStack = new Stack<>();
            Stack<Integer> starStack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if ('(' == s.charAt(i)) {
                    openStack.add(i);
                } else if ('*' == s.charAt(i)) {
                    starStack.add(i);
                } else {
                    if (!openStack.isEmpty()) {
                        openStack.pop();
                    } else if (!starStack.isEmpty()) {
                        starStack.pop();
                    } else {
                        return false;
                    }
                }
            }

            while (!openStack.isEmpty() && !starStack.isEmpty()) {
                if (starStack.pop() < openStack.pop()) {
                    return false;
                }
            }

            return openStack.isEmpty();
        }
    }

}
