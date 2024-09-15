package Y2024M09;

import java.util.Scanner;

public class P2581 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        int max = scanner.nextInt();

        int totalSum = 0;
        int minResult = 0;

        for (int i = min; i <= max; i++) {
            if (isPrime(i)) {
                totalSum += i;
                if (minResult == 0) {
                    minResult = i;
                }
            }
        }

        if (totalSum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(totalSum);
            System.out.println(minResult);
        }

    }

    private static boolean isPrime(int i) {
        if (i <= 1) {
            return false;
        }

        if (i != 2 && i % 2 == 0) { // 2를 제외한 짝수인경우
            return false;
        }
        for (int j = 3; j <= Math.sqrt(i); j += 2) { // 3을 제외한 홀 수인 경우
            if (i % j == 0) {
                return false;
            }
        }

        return true;
    }
}
