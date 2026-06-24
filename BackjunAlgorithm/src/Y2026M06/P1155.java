package Y2026M06;

import java.util.Scanner;
import java.util.Stack;

public class P1155 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputs = scanner.next();

        int answer = solution(inputs);

        System.out.println(answer);
    }

    private static int solution(String inputs) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < inputs.length(); i++) {
            if (Character.isDigit(inputs.charAt(i))) {
                stack.push(Character.getNumericValue(inputs.charAt(i)));
                continue;
            }

            Integer firstPop = stack.pop();
            Integer beforePop = stack.pop();
            switch (inputs.charAt(i)) {
                case '*': {
                    stack.push(beforePop * firstPop);
                    break;
                }
                case '/': {
                    stack.push(beforePop / firstPop);
                    break;
                }
                case '+': {
                    stack.push(beforePop + firstPop);
                    break;
                }
                case '-': {
                    stack.push(beforePop - firstPop);
                    break;
                }
                default: break;
            }
        }

        return stack.pop();
    }
}
