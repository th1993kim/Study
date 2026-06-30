package Y2026M06;

import java.util.Scanner;

public class P1200 {

    static int answer = 0;
    static int n, m = 0;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        int[] scores = new int[n];
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
            times[i] = scanner.nextInt();
        }

        dfs(0, 0, 0, scores, times);

        System.out.println(answer);
    }

    private static void dfs(int level, int sum, int sumTimes, int[] scores, int[] times) {
        if (sumTimes > m) {
            return;
        }
        if (level == n) {
            answer = Math.max(answer, sum);
            return;
        } else {
            dfs(level + 1, sum + scores[level], sumTimes + times[level], scores, times);
            dfs(level + 1, sum, sumTimes, scores, times);
        }
    }
}
