package Y2026M06;

import java.util.Scanner;
import java.util.Stack;

public class P1153 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        String answer = solution(input);

        System.out.println(answer);
    }

    private static String solution(String input) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ')') {
                stack.push(input.charAt(i));
            } else {
                while (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if (pop == '(') {
                        break;
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        return answer.reverse().toString();
    }
}
