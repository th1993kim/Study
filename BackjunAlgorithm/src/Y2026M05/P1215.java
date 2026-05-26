package Y2026M05;

import java.util.Scanner;

public class P1215 {

    static int answer = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] inputs = new int[n][2];
        for (int i = 0; i < n; i++) {
            inputs[i][0] = scanner.nextInt();
            inputs[i][1] = scanner.nextInt();
        }

        solution(n, inputs);

        System.out.println(answer);
    }

    private static void solution(int n, int[][] inputs) {
        for (int i = 0; i < n; i++) {
            int weight = inputs[i][0];
            int height = inputs[i][1];
            boolean isPossible = true;
            for (int j = 0; j < n; j++) {
                int compareWeight = inputs[j][0];
                int compareHeight = inputs[j][1];
                if (compareWeight > weight && compareHeight > height) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                answer++;
            }
        }
    }
}
