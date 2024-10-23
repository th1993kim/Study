package Y2024M10;

import java.io.*;
import java.util.*;

public class P1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        gptSolution(br,bw);
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = n; i <= m; i++) {
//            if (isPrime(i)) {
//                sb.append(i).append("\n");
//            }
//
//        }
//
//
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//        br.close();
    }

    private static boolean isPrime(int i) {
        if (i == 1) {
            return false;
        }

        if (i == 2 || i == 3) {
            return true;
        }

        int sqrt = (int) Math.sqrt(i);

        for (int j = 2; j <= sqrt; j++) {
            if (i % j == 0) {
                return false;
            }
        }

        return true;
    }

    private static void gptSolution(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        //아리토스테네스의 체 소수구하기
        boolean[] notPrimeArray = new boolean[m + 1];
        notPrimeArray[0] = notPrimeArray[1] = true;

        for (int i = 2; i * i <= m; i++) { // i * i 로 범위를 정하는 것은 소수의 제곱들을 제거하기 위함.
            if (!notPrimeArray[i]) { //현재 소수인 숫자만
                for (int j = i * i; j <= m; j += i) { //현재의 소수의 숫자의 배수들을 소수 목록에서 제거
                    notPrimeArray[j] = true;
                }
            }
        }


        for (int i = n; i <= m; i++) {
            if (!notPrimeArray[i]) {
                sb.append(i).append("\n");
            }

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
