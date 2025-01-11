package Y2025M01;

import java.io.*;
import java.util.StringTokenizer;

public class P2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        StringTokenizer st = new StringTokenizer(word);

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int gcd = gcd(a,b);

        StringBuilder sb = new StringBuilder();
        sb.append(gcd).append("\n");
        sb.append(a * b / gcd).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcd(int a, int b) {
        int mod = a % b;

        if (mod == 0) {
            return b;
        }

        return gcd(b, mod);
    }
}
