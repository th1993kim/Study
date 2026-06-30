package Y2026M06;

import java.util.Scanner;

public class P1199 {

    static int c, n = 0;
    static int answer = 0;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt();
        n = scanner.nextInt();

        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        solution(weights);

        System.out.println(answer);
    }

    private static void solution(int[] weights) {
        dfs(0, 0, weights);
    }

    private static void dfs(int level, int sum, int[] weights) {
        if (sum > c) {
            return;
        } else {
            answer = Math.max(answer, sum);
        }
        if (level == n) {
            return;
        } else {
            dfs(level + 1, sum + weights[level], weights);
            dfs(level + 1, sum, weights);
        }
    }
}
