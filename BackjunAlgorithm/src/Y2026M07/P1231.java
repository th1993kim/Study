package Y2026M07;

import java.util.Scanner;

public class P1231 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();

        int answer = solution(n, m, coins);

        System.out.println(answer);
    }

    private static int solution(int n, int m, Integer[] coins) {

        int[] dy = new int[ m + 1 ];  // dy[]는 해당 목표금액의 최소 동전 갯수

        for (int i = 0; i <= m; i++) {
            dy[i] = Integer.MAX_VALUE;
        }
        dy[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coins[i]] + 1);
            }
        }

        return dy[m];
    }
}
