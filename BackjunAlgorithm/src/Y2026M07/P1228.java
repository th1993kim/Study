package Y2026M07;

import java.util.Scanner;

public class P1228 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int answer = solution(n);
        System.out.println(answer);
    }

    private static int solution(int n) {
        int d = n + 1;
        int[] arr = new int[d+1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= d; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[d];
    }
}
