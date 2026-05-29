package Y2026M05;

import java.util.Arrays;
import java.util.Scanner;

public class P1201 {

    static int answer = Integer.MAX_VALUE;
    static int target;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] coins = new int[count];
        for (int i = 0; i < count; i++) {
            coins[i] = scanner.nextInt();
        }
        target = scanner.nextInt();

        dfs(0, coins);
        System.out.println(answer);
    }

    private static void dfs(int level, int[] coins) {

        if (target == 0) {
            answer = Math.min(answer, level);
            return;
        } else {
            for (int i = 0; i < coins.length; i++) {
                if (target - coins[i] >= 0) {
                    target -= coins[i];
                    dfs(level + 1, coins);
                    target += coins[i];
                }
            }
        }
    }

}
