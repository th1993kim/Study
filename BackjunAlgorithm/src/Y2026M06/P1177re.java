package Y2026M06;

import java.util.Arrays;
import java.util.Scanner;

public class P1177re {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = scanner.nextInt();
        }

        int answer = solution(n, m, inputs);

        System.out.println(answer);
    }

    private static int solution(int n, int m, int[] inputs) {
        Arrays.sort(inputs);
        int answer = -1;
        int lt = 0, rt = n - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (inputs[mid] == m) return mid + 1;
            if (inputs[mid] < m) lt = mid + 1;
            else rt = mid - 1;
        }

        return answer;
    }
}
