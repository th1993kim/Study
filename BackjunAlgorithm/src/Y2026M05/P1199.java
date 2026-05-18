package Y2026M05;

import java.util.Scanner;

public class P1199 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int max = scanner.nextInt();
        int n = scanner.nextInt();

        int[] array = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(solution(array, max, sum, 0));
    }

    private static int solution(int[] array, int max, int sum, int n) {


        if (sum > max) {
            return 0;
        } else if (n == array.length) {
            return sum;
        } else {
            return Math.max(solution(array, max, sum + array[n], n + 1), solution(array, max, sum, n + 1));
        }
    }
}
