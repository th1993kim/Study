package Y2026M05;

import java.util.*;

public class P1198 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputs = new int[n];
        int sum = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            inputs[i] = scanner.nextInt();
            total += inputs[i];
        }
        if (total % 2 != 0) {
            System.out.println("NO");
            return;
        }
        System.out.println(solution(0, inputs, sum, total/2) ? "YES" : "NO");

    }

    private static boolean solution(int n, int[] inputs, int sum, int target) {
        if (sum == target) {
            return true;
        }
        if (sum > target || n == inputs.length) {
            return false;
        }

        boolean tempResult = solution(n + 1, inputs, sum + inputs[n], target);
        if (tempResult) {return true;}
        return solution(n + 1, inputs, sum, target);
    }
}
