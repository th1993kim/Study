package Y2026M06;

import java.util.Scanner;

public class P1120 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int row = 6;
        int col = number + 1;
        int[][] meetings = new int[col][row];

        for (int i = 1; i< col; i++) {
            for (int j = 1; j< row; j++) {
                meetings[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution(meetings));

    }

    private static int solution(int[][] meetings) {

        int max = -1;
        int maxNumber = -1;
        for (int ownPerson = 1; ownPerson < meetings.length; ownPerson++) {
            int count = 0;
            for (int comparePerson = 1; comparePerson < meetings.length; comparePerson++) {
                if (ownPerson == comparePerson) continue;

                for (int grade = 1; grade < meetings[0].length; grade++) {
                    if (meetings[ownPerson][grade] == meetings[comparePerson][grade]) {
                        count++;

                        break;
                    }
                }

                if (count > max) {
                    max = count;
                    maxNumber = ownPerson;
                }
            }
        }
        return maxNumber;
    }
}
