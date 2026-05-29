package Y2026M05;

import java.util.Arrays;
import java.util.Scanner;

public class P1201 {

    static int answer;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] coins = new int[count];
        for (int i = 0; i < count; i++) {
            coins[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        solution(coins, target);
        System.out.println(answer);
    }

    private static void solution(int[] coins, int target) {
        Arrays.sort(coins);


        for (int i = coins.length - 1; i >= 0 ; i--) {
            int maxCoin = 0;
            while (target - coins[i] >= 0 || maxCoin + coins[i] <= 100) {
                target = target - coins[i];
                answer++;
                maxCoin += coins[i];
            }
        }
    }
}
