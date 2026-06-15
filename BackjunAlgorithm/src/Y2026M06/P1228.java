package Y2026M06;

import java.util.Scanner;

public class P1228 {

    static int[] answerArr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        answerArr = new int[number + 2];
        answerArr[1] = 1;
        answerArr[2] = 2;
        int answer = solution(number + 1);
        System.out.println(answer);
    }

    private static int solution(int number) {
        if (answerArr[number] != 0) {
            return answerArr[number];
        }
        int result = solution(number - 2) + solution(number - 1);
        // 5 6
        // 3 4 4 5
        // 1 2 2 3 2 3 3 4
        answerArr[number] = result;
        return result;
    }
}
