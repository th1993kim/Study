package Y2026M06;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P1169re {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] inputs = new int[n];

        for (int i = 0; i < n; i++) {
            inputs[i] = scanner.nextInt();
        }
        String answer = solution(n, inputs);

        System.out.println(answer);
    }

    private static String solution(int n, int[] inputs) {
        Set<Integer> duplicateChecker = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (duplicateChecker.contains(inputs[i])) {
                return "D";
            } else {
                duplicateChecker.add(inputs[i]);
            }
        }

        return "U";
    }
}
