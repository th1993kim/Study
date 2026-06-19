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
        int rt = 0;
        sum += numbers[rt++];
        while(lt < n && rt < n) {
            if (sum == m) {
                answer++;
                sum += numbers[rt++];
            } else if (sum < m) {
                sum += numbers[rt++];
            } else {
                sum -= numbers[lt++];
            }
        }

        while (lt < n) {
            if (sum == m) {
                answer++;
            }
            sum -= numbers[lt++];
        }

        return answer;
    }

}
