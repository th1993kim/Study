package Y2024M10;

import java.io.*;

public class P2485 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int gcd = 1;
        for (int i = 0; i < n-1; i++) {
            int section = arr[i + 1] - arr[i];
            if (i == 0) {
                gcd = section;
            }

            gcd = gcd(gcd, section);
        }

        int result = 0;
        for (int i = 0; i < n-1; i++) {
            result += (arr[i + 1] - arr[i]) / gcd - 1;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcd(int a, int b) {
        if (b != 0) {
            return gcd(b, a % b);
        }
        return a;
    }


    private static void gptRefactoring(BufferedReader br, BufferedWriter bw) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            bw.write("0");
            bw.flush();
            bw.close();
            br.close();
        }

        int gcd = arr[1] - arr[0];
        for (int i = 1; i < n-1; i++) {
            int section = arr[i + 1] - arr[i];
            gcd = gcd(gcd, section);
        }

        int result = 0;
        for (int i = 0; i < n-1; i++) {
            result += (arr[i + 1] - arr[i]) / gcd - 1;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
