package Y2025M01;

import java.io.*;

public class P1461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int [] dp = new int[n + 1]; //dp 배열
        dp[1] = 0; // 1일때 초기값 설정

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // 기본적으로 1을 빼는 경우 + 1 카운트

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 2로 나눈 경우와 1을 빼는 경우의 처리와 비교해서 작은 값
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 3으로 나눈 경우와 1을 빼는 경우 처리 중 최소값
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
