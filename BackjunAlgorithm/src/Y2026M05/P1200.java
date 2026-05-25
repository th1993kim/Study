package Y2026M05;

import java.util.Scanner;

public class P1200 {

    static int answer = Integer.MIN_VALUE, count, maxTime;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();
        maxTime = scanner.nextInt();
        int[] scoreArr = new int[count];
        int[] timeArr = new int[count];
        for (int i = 0; i < count; i++) {
            scoreArr[i] = scanner.nextInt();
            timeArr[i] = scanner.nextInt();
        }
        solution(0, 0, 0, scoreArr, timeArr);
        System.out.println(answer);
    }

    private static void solution(int level, int sum, int time, int[] scoreArr, int[] timeArr) {
        if (time > maxTime) {
            return;
        }

        if (level == count) {
            answer = Math.max(answer, sum);
        } else {
            solution(level + 1, sum + scoreArr[level], time + timeArr[level], scoreArr, timeArr);
            solution(level + 1, sum, time, scoreArr, timeArr);
        }
    }
}
