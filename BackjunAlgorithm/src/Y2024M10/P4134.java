package Y2024M10;

import java.io.*;

public class P4134 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            long number = Long.parseLong(br.readLine());
            if (number <= 2) {
                sb.append(2).append("\n");
                continue;
            }

            if (number % 2 == 0) {
                number ++;
            }

            while (!isPrime(number)) {
                number += 2;
            }
            sb.append(number).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isPrime(long checkNumber) {

        long sqrt = (long) Math.sqrt(checkNumber);
        for (long i = 2; i <= sqrt; i++) {
            if (checkNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}