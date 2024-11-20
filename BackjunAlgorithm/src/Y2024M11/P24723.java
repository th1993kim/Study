package Y2024M11;

import java.io.*;

public class P24723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 2;
        }
        bw.write("" + result);

        bw.flush();
        bw.close();
        br.close();
    }
}
