package Y2026M06;

import java.util.Scanner;

public class P1121 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int student = scanner.nextInt();
        int scoreCount = scanner.nextInt();

        int[][] scoreMatrix = new int[scoreCount][student];

        for (int i = 0; i < scoreCount; i++) {
            for (int j = 0; j < student; j++) {
                scoreMatrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution(student, scoreCount, scoreMatrix));
    }

    private static int solution(int student, int scoreCount, int[][] scoreMatrix) {

        int[][] newScoreMatrix = new int[scoreCount][student];
        for (int i = 0; i < scoreCount; i++) {
            for (int j = 0; j < student; j++) {
                newScoreMatrix[i][scoreMatrix[i][j]-1] = j;
            }
        }

        int answer = 0;
        for (int ownStudent = 0; ownStudent < student; ownStudent++) {

            for (int compareStudent = 0; compareStudent < student; compareStudent++) {
                if (ownStudent == compareStudent) continue;

                boolean isBigger = true;

                for (int i = 0; i < scoreCount; i++) {
                    if (newScoreMatrix[i][ownStudent] < newScoreMatrix[i][compareStudent]) {
                        isBigger = false;
                        break;
                    }
                }
                if (isBigger) answer++;
            }
        }

        return answer;
    }
}
