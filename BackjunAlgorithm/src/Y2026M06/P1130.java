package Y2026M06;

import java.util.Scanner;

public class P1130 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sales = new int[n];
        int k = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            sales[i] = scanner.nextInt();
        }

        int answer = solution(n, k, sales);

        System.out.println(answer);
    }

    private static int solution(int n, int k, int[] sales) {

        int max = 0;
        // i < 7
        for (int i = 0; i < n -k ; i++) {
            int sum = 0;
            // j < 10
            for (int j = i; j < i + k; j++) {
                sum += sales[j];
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}
