package Y2026M07;

import java.util.Stack;

public class NeetCode2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) == '['
                    || s.charAt(i) == '('
                    || s.charAt(i) == '{'
            ) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                char word = stack.pop();
                if (s.charAt(i) == ']') {
                    if (word != '[') return false;
                } else if (s.charAt(i) == ')') {
                    if (word != '(') return false;
                } else {
                    if (word != '{') return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
