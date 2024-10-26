package Y2024M10;

import java.io.*;

public class P13909 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n + 1];

        for (int i = 2; i < n; i++) {
            for (int j = i; j < n; j *= i) {
                if(arr[j]) {
                    arr[j] = false;
                } else {
                    arr[j] = true;
                }
            }
        }

        int result = 0;
        for (int i=1; i<n; i++) {
            if (!arr[i]) {
                result ++;
            }
        }


        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void gptSolution(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(Math.sqrt(n)));

        bw.flush();
        bw.close();
        br.close();
    }
}
