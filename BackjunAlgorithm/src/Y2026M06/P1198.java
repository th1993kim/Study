package Y2026M06;

import java.util.Scanner;

public class P1198 {

    static int target = 0;
    static String answer = "NO";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
            target += numbers[i];
        }

        solution(numbers);
        System.out.println(answer);
    }

    private static void solution(int[] numbers) {

        if (target % 2 == 1) {
            answer = "NO";
            return;
        }
        dfs(0, 0, numbers);

    }

    private static void dfs(int level, int sum, int[] numbers) {

        if ("YES".equals(answer)) {
            return;
        }
        if (sum == target / 2) {
            answer = "YES";
        }

        if (level == numbers.length || sum > target / 2) {
            return;
        } else {
            dfs(level + 1, sum + numbers[level], numbers);
            dfs(level + 1, sum, numbers);
        }
    }

}
