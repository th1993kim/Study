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

        return recursive(n, arr);
    }

    private static int recursive(int n, int[] arr) {
        if (arr[n] != 0) return arr[n];

        return arr[n] = recursive(n-1, arr) + recursive(n-2, arr);
    }
}
