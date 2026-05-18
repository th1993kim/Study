package Y2026M05;

import java.util.Scanner;

public class P1199 {

    static int answer = Integer.MIN_VALUE, n, max;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        max = scanner.nextInt();
        n = scanner.nextInt();

        int[] array = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        solution(0, array, sum);
        System.out.println(answer);
    }

    private static void solution(int level, int[] array, int sum) {


        if (sum > max) {
            return;
        } else if (n == level) {
            answer = Math.max(answer, sum);
        } else {
            solution(level + 1, array, sum + array[level]);
            solution(level + 1, array, sum);
        }
    }
}
