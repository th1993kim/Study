package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14215 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a + b <= c) {
            c = a + b - 1;
        } else if (b + c <= a) {
            a = b + c - 1;
        } else if (a + c <= b) {
            b = a + c - 1;
        }

        System.out.println(a + b + c);
    }


    private static void gptAnswer(BufferedReader br) throws IOException {
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 배열로 정렬
            int[] arr = {a, b, c};
            Arrays.sort(arr);
            a = arr[0];
            b = arr[1];
            c = arr[2];

            // 두수의 합이 가장 큰수보다 큰 경우
            if (a + b > c) {
                System.out.println(a + b + c);
            } else {
                // c가 크거나 같은 경우 (a + b) -1 값으로 변경해주어야 하기 때문
                System.out.println((a + b) * 2 - 1);
            }

        }
    }
}
