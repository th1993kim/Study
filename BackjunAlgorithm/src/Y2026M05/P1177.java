package Y2026M05;

import java.util.Scanner;
import java.util.Arrays;

public class P1177 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] inputs = new int[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = scanner.nextInt();
        }

        System.out.println(solution(inputs, M));
    }

    private static int solution(int[] inputs, int m) {
        Arrays.sort(inputs);
        int lt = 0;
        int rt = inputs.length - 1;
        int ans = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (inputs[mid] == m) {
                ans = mid + 1;
                break;
            } else if(inputs[mid] < m) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return ans;
    }
}
