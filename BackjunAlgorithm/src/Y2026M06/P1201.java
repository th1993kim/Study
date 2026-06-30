package Y2026M06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1201 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] check = new int[m+1];
        int answer = solution(n, m, coins, check);

        System.out.println(answer);
    }

    private static int solution(int n, int m, int[] coins, int[] check) {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(coins[i]);
            check[coins[i]] = 1;
        }
        int answer = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                int coin = (int) queue.poll();
                if (coin == m) return answer;

                for (int j = 0; j < n; j++) {
                    int nextCoin = coin + coins[j];
                    if (nextCoin <= m && check[nextCoin] == 0) {
                        check[nextCoin] = 1;
                        queue.offer(nextCoin);
                    }
                }
            }
            answer++;
        }

        return answer;
    }
}
