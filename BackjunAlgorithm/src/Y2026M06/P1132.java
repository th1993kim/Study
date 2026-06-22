package Y2026M06;

import java.util.Scanner;

public class P1132 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int answer = solution(n);

        System.out.println(answer);
    }

    private static int solution(int n) {

        int lt = 1;
        int sum = 0;
        int answer = 0;

        for (int rt = 1; rt < n; rt++) {
            sum += rt;
            while(sum > n) {
                sum -= lt++;
            }

            if (sum == n) answer++;
        }

        return answer;
    }
}
