package Y2025M01;

import java.io.*;

public class P11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        arr[1] = 1;
        if (n > 1) {
            arr[2] = 2;
        }

        for (int i = 3; i <= n; i++) {

            arr[i] = arr[i-1] + arr[i-2];

        }


        bw.write(String.valueOf(arr[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
