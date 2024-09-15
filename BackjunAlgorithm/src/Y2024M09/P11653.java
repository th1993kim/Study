package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11653 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        while(number != 1) {
            while (number % 2 == 0) {
                System.out.println(2);
                number = number / 2;
            }

            for (int i = 3; i <= number; i++) {
                if (number % i == 0) {
                    System.out.println(i);
                    number = number / i;
                    break;
                }
            }
        }
    }


    public static void otherSolution(int number) {
        for (int i = 2; i < number; i++) {
            while (number % i == 0) {
                System.out.println(i);
                number /= i;
            }
        }

    }
}
