package Y2024M10;

import java.io.*;
import java.util.StringTokenizer;

public class P1934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a0 = Integer.parseInt(st.nextToken());
            int a1 = Integer.parseInt(st.nextToken());
            int temp = a0;
            if (a0 > a1) {
                a0 = a1;
                a1 = temp;
            }
            int result = 1;
            int j = 1;
            while (a0 >= j) {
                if (a0 % j == 0 && a1 % j == 0) {
                    a0 /= j;
                    a1 /= j;
                    result *= j;
                    j = 1;
                }

                j++;
            }
            result *= a0 * a1;

            sb.append(result).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void gptSolution(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lcm = a * b / gcd(a, b);
            sb.append(lcm).append("\n");
        }
        bw.write(sb.toString());
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
}
