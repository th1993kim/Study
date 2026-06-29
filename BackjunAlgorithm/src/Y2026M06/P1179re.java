package Y2026M06;

import java.util.Arrays;
import java.util.Scanner;

public class P1179re {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();

        int[] positions = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            positions[i] = scanner.nextInt();
            max = Math.max(max, positions[i]);
        }

        int answer = solution(n, c, max, positions);

        System.out.println(answer);
    }

    private static int solution(int n, int c, int max, int[] positions) {
        Arrays.sort(positions);

        int lt = 1;
        int rt = max;
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int last = positions[0];
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (positions[i] - last >= mid) {
                    count++;
                    last = positions[i];
                }
            }

            if (count < c) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
                answer = Math.max(answer, mid);
            }
        }

        return answer;

    }
}
