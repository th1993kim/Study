package Y2026M06;

import java.util.Scanner;

public class P1202 {

    static int[][] store;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        store = new int[n+1][r+1];

        int answer = solution(n, r);

        System.out.println(answer);
    }

    private static int solution(int n, int r) {

        return recursive(n, r);
    }

    private static int recursive(int n, int r) {
        if (store[n][r] != 0) return store[n][r];
        if (n == r) return 1;
        if (r == 1) return n;
        if (r == 0) return 1;

        return store[n][r] = recursive(n-1, r-1) + recursive(n-1, r);
    }
}
