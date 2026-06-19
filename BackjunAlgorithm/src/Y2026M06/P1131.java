package Y2026M06;

import java.util.Scanner;

public class P1131 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        int answer = solution(n, m, numbers);
        System.out.println(answer);
    }

    private static int solution(int n, int m, int[] numbers) {

        int answer = 0;
        int sum = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += numbers[rt];
            if (sum == m) answer++;

            while (sum >= m) {
                sum -= numbers[lt++];
                if (sum == m) answer++;
            }
        }
        return answer;
    }

}
