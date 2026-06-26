package Y2026M06;

import java.util.Arrays;
import java.util.Scanner;

public class P1175re {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        int[] answer = solution(n, heights);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static int[] solution(int n, int[] heights) {
        int[] answer = new int[2];
        int lt = 0;

        int[] clone = heights.clone();
        Arrays.sort(clone);

        for (int i = 0; i < n; i++) {
            if (heights[i] != clone[i]) {
                answer[lt++] = i + 1;
            }
        }

        return answer;
    }
}
