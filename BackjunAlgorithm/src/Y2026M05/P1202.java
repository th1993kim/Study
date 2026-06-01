package Y2026M05;

import java.util.Scanner;

public class P1202 {

    static int[][] memorization;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int r = scanner.nextInt();

        memorization = new int[n+1][r+1];
        int answer = solution(n, r);
        System.out.println(answer);
    }

    private static int solution(int n, int r) {
        if (r == 0 || n == r) {
            memorization[n][r] = 1;
            return 1;
        }
        if (memorization[n][r] != 0) {
            return memorization[n][r];
        }
        return memorization[n][r] = solution(n - 1, r) + solution(n - 1 , r - 1);
    }
}
