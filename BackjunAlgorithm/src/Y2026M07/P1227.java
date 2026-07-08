package Y2026M07;

import java.util.Scanner;

public class P1227 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int answer = solution(scanner.nextInt());

        System.out.println(answer);
    }

    private static int solution(int n) {

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i -2];
        }

        return arr[n];
    }
}
