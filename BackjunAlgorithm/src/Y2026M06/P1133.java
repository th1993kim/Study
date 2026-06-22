package Y2026M06;

import java.util.Scanner;

public class P1133 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int answer = solution(n, k, numbers);

        System.out.println(answer);
    }

    private static int solution(int n, int k, int[] numbers) {
        int sum = 0;
        int change = 0;
        int[] changeArr = new int[n];
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            if (numbers[rt] == 0) {
                numbers[rt] = 1;
                changeArr[rt] = 1;
                change++;
            }

            while (change > k) {
                if (changeArr[lt] == 1) {
                    numbers[lt] = 0;
                    changeArr[lt] = 0;
                    change--;
                }
                lt++;
            }

            sum = Math.max(sum, rt - lt + 1);
        }



        return sum;
    }
}
