package Y2026M06;

import java.util.Scanner;
import java.util.Stack;

public class P1154 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] inputs = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inputs[i][j] = scanner.nextInt();
            }
        }

        int outCount = scanner.nextInt();

        int[] outputs = new int[outCount];

        for (int i = 0; i < outCount; i++) {
            outputs[i] = scanner.nextInt();
        }

        int answer = solution(n, inputs, outCount, outputs);

        System.out.println(answer);
    }

    private static int solution(int n, int[][] inputs, int outCount, int[] moves) {
        Stack<Integer> pullStack = new Stack<>();
        int answer = 0;

        for (int pos = 0; pos < outCount; pos++) {

            for (int i = 0; i < n; i++) {
                if (inputs[i][moves[pos] -1] != 0) {
                    int value = inputs[i][moves[pos] - 1];
                    inputs[i][moves[pos] -1] = 0;

                    if (!pullStack.isEmpty() && pullStack.peek() == value) {
                        pullStack.pop();
                        answer += 2;
                    } else {
                        pullStack.push(value);
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
