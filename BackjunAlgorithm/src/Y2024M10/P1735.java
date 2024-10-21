package Y2024M10;

import java.io.*;
import java.util.StringTokenizer;

public class P1735 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        n = n * z + x * m;
        m = m * z;

        int gcd = gcd(n, m);

        bw.write(n / gcd + " " + m / gcd);

        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcd(int n, int m) {
        if (m != 0) {
            return gcd(m, n % m);
        }
        return n;
    }
}
