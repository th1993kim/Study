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

        int answer = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += sales[i];
        }
        answer = sum;

        for (int i = k; i < n; i++) {
            sum += sales[i] - sales[i-k];
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
