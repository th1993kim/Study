package Y2026M07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1232 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Problem> problemList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            problemList.add(new Problem(scanner.nextInt(), scanner.nextInt()));
        }

        int answer = solution(n, m, problemList);

        System.out.println(answer);
    }

    private static int solution(int n, int m, List<Problem> problemList) {
        int[] score = new int[m + 1];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int[] previousScore = Arrays.copyOf(score, score.length);
            for (int j = 0; j <= m; j++) {
                if (j >= problemList.get(i).time) {
                    score[j] = Math.max(previousScore[j], previousScore[j - problemList.get(i).time] + problemList.get(i).score);
                }
                answer = Math.max(answer, score[j]);
            }
        }

        return answer;
    }

    static class Problem {
        int score;
        int time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}


