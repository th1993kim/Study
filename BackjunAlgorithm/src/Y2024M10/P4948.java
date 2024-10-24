package Y2024M10;

import java.io.*;

public class P4948 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = new boolean[123456 * 2 + 1];

        arr[0] = arr[1] = true;
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) {
                for (int j = i + i; j < arr.length; j += i) {
                    arr[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int n = 0;
        while((n = Integer.parseInt(br.readLine())) != 0) {
            int result = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (!arr[i]) {
                    result++;
                }
            }

            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
