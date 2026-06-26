package Y2026M06;

import java.util.Scanner;

public class P1168re {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cacheSize = scanner.nextInt();
        int workSize = scanner.nextInt();

        int[] works = new int[workSize];

        for (int i = 0; i < workSize; i++) {
            works[i] = scanner.nextInt();
        }

        int[] answer = solution(cacheSize, workSize, works);

        for (int n = 0; n < answer.length; n++) {
            System.out.print(answer[n] + " ");
        }
    }

    private static int[] solution(int cacheSize, int workSize, int[] works) {

        int[] answer = new int[cacheSize];
        for (int i = 0; i < workSize; i++) {
            int work = works[i];
            int index = -1;
            for (int j = 0; j < cacheSize; j++) {
                if (answer[j] == work) {
                    index = j;
                    break;
                }
            }
            if (index == 0) {
                continue;
            }
            if (index != -1) {
                for (int j = index - 1; j >= 0; j--) {
                    answer[j + 1] = answer[j];
                }
            } else {
                for (int j = cacheSize - 2; j >= 0; j--) {
                    answer[j + 1] = answer[j];
                }
            }
            answer[0] = work;
        }
        return answer;
    }
}
