package Y2026M06;

import java.util.Scanner;
import java.util.Stack;

public class P1156 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputs = scanner.next();

        int answer = solution(inputs);

        System.out.println(answer);
    }

    private static int solution(String inputs) {
        Stack<Character> stack = new Stack<>();

        int answer = 0;
        for (int i = 0; i < inputs.length(); i++) {
            if (inputs.charAt(i) == '(') stack.push(inputs.charAt(i));
            else {
                if (inputs.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    answer += 1;
                    stack.pop();
                }

            }
        }

        return answer;
    }
}
