package Y2026M07;

import java.util.Scanner;

public class P1229 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int answer = solution(arr);

        System.out.println(answer);
    }

    private static int solution(int[] arr) {
        int answer = 0;
        int[] dy = new int[arr.length];
        dy[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            dy[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    dy[i] = Math.max(dy[i], dy[j] + 1);
                }
            }
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }
}
