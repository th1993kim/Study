package Y2026M06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P1201 {

    static int answer = Integer.MAX_VALUE;
    static int n,m = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        Integer[] coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        m = scanner.nextInt();
        Arrays.sort(coins, Collections.reverseOrder());
        dfs(0, 0, coins);

        System.out.println(answer);
    }

    private static void dfs(int level, int sum, Integer[] coins) {
        if (answer <= level) {
            return;
        }
        if (sum == m) {
            answer = level;
            return;
        }
        if (sum > m) {
            return;
        } else {
            for (int i = 0; i < n; i++) {
                dfs(level + 1, sum + coins[i], coins);
            }
        }
    }

}
