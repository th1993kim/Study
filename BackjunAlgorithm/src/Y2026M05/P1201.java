package Y2026M05;

import java.util.Arrays;
import java.util.Scanner;

public class P1201 {

    static int target;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Integer[] coins = new Integer[count];
        for (int i = 0; i < count; i++) {
            coins[i] = scanner.nextInt();
        }
        target = scanner.nextInt();

        int[] dp = new int[target + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.sort(coins);
        solution(dp, coins);
        System.out.println(dp[target]);
    }

    private static void solution(int[] dp, Integer[] coins) {
        dp[0] = 0;
        for (int money = 1; money <= target; money++) {
            for (int j = 0; j < coins.length; j++) {
                if (money - coins[j] >= 0) {
                    dp[money] = Math.min(dp[money], dp[money - coins[j]] + 1);
                }
            }
        }
    }
}
