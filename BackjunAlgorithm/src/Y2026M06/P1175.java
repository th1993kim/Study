package Y2026M06;

import java.util.Arrays;
import java.util.Scanner;

public class P1175 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        solution(n, heights);
    }

    private static void solution(int n, int[] heights) {
        int[] compareHeights = Arrays.copyOf(heights, n);
        Arrays.sort(compareHeights);

        for (int i = 0; i < n; i++) {
            if (compareHeights[i] != heights[i]) {
                System.out.print(i + 1 + " ");
            }
        }
    }
}
