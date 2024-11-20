package Y2024M11;

import java.io.*;
import java.util.StringTokenizer;

public class P1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            min = Math.min(min, input);
            max = Math.max(max, input);
        }

        bw.write(min * max + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
