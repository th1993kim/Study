package Y2024M09;

import java.io.IOException;
import java.util.Scanner;

public class P1978 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int count = scan.nextInt();
        int total = 0;

        for (int i = 0; i < count; i++) {
            int input = scan.nextInt();

            boolean isPrime;
            isPrime = true;

            if (input <= 1) {
                isPrime = false;
            } else {
                for (int j = 2; j < input; j++) {
                    if (input % j == 0) {
                        isPrime = false;
                    }
                }
            }

            if (isPrime) {
                total++;
            }
        }

        System.out.println(total);
    }

    public static boolean isPrimeFromGpt(int number) {
        // 1이하 소수아님
        if (number <= 1) {
            return false;
        }
        // 2는 소수
        if (number == 2) {
            return true;
        }
        // 짝수는 소수가 아님 (2제외)
        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
