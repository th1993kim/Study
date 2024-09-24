package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int point = 0;
        for (int i=1; i<input; i++) {
            String iString = String.valueOf(i);
            int length = iString.length();
            int sum = i;
            for (int j = 0; j < length; j++) {
                sum += Integer.parseInt(String.valueOf(iString.charAt(j)));
            }
            if (sum == input) {
                point = i;
                break;
            }
        }
        System.out.println(point);
    }

    public static void gptSolution(int input) {
        int length = String.valueOf(input).length();
        //밑의 9*자리수는 최대 자리수값 (세자리인 경우 999 -> 27)을 제외한 값이 생성자이기 때문)
        int point = 0;
        for (int i=input - 9 * length; i < input; i++) {
            int sum = i;
            int number = i;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }

            if (sum == input) {
                point = i;
                break;
            }
        }

        System.out.println(point);
    }
}
