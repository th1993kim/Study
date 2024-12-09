package Y2024M12;

import java.io.*;
import java.util.Stack;

public class P1918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        String line = br.readLine();

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        char[] charArray = line.toCharArray();
        for (char c : charArray) {
            //연산자의 경우
            if (Character.isAlphabetic(c)) {
                result.append(c);
            } else if (c == '(') { // 여는 괄호
                stack.push(c);
            } else if (c == ')') { // 닫는 괄호
                while (!stack.isEmpty()) {
                    Character popCharacter = stack.pop();
                    if (popCharacter == '(') {
                        break;
                    }
                    result.append(popCharacter);
                }
            } else { //연산자의 경우
                while (!stack.isEmpty() && priority(c) < priority(stack.peek())) {
                    result.append(stack.pop()); // 연산자중 우선순위가 낮은 경우의 이전 연산자들을 모두 꺼낸다.
                }

                stack.push(c); // 연산자를 스택에 저장
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        bw.write(result.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static int priority(Character c) {
        switch (c) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            default: return 0;
        }
    }
}
