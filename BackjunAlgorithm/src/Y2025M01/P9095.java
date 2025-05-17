package Y2025M01;

import java.io.*;

public class P9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[11];

        answer[1] = 1;
        answer[2] = 2;
        answer[3] = 4;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int quest = Integer.parseInt(br.readLine());
            for (int j = 4; j <= quest; j++) {
                if (answer[j] == 0) {
                    answer[j] = answer[j - 1] + answer[j - 2] + answer[j - 3];
                }
            }
            sb.append(answer[quest]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
