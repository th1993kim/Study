package Y2026M06;

import java.util.Scanner;
import java.util.Stack;

public class P1152 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        String answer = solution(input);

        System.out.println(answer);
    }

    private static String solution(String input) {
        Stack<Character> stack = new Stack<>();

        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') stack.push(charArray[i]);
            else if (charArray[i] == ')') {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if (stack.isEmpty()) return "YES";

        return "NO";
    }
}
