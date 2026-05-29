package Y2026M05;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P1201 {

    static int answer = Integer.MAX_VALUE;
    static int target;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Integer[] coins = new Integer[count];
        for (int i = 0; i < count; i++) {
            coins[i] = scanner.nextInt();
        }
        target = scanner.nextInt();

        Arrays.sort(coins, Collections.reverseOrder());
        dfs(0, 0, coins);
        System.out.println(answer);
    }

    private static void dfs(int level, int sum, Integer[] coins) {

        if (sum > target) {
            return;
        }
        if (level >= answer) {
            return;
        }

        if (sum == target) {
            answer = level;
        } else {
            for (int i = 0; i < coins.length; i++) {
                dfs(level + 1, sum + coins[i], coins);
            }
        }
    }

}
