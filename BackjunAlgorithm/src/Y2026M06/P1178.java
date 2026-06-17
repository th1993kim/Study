package Y2026M06;

import java.util.Scanner;

public class P1178 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int maxSize = scanner.nextInt();
        int[] movies = new int[count];

        int max = 0;
        int sum = 0;
        for (int i = 0; i < count; i++) {
            movies[i] = scanner.nextInt();
            max = Math.max(max, movies[i]);
            sum += movies[i];
        }

        System.out.println(solution(maxSize, movies, max, sum));
    }

    private static int solution(int maxSize, int[] movies, int max, int sum) {

        int answer = 0;
        int lt = max;
        int rt = sum;
        while (lt <= rt) {
            int cap = (lt + rt) / 2;
            if (isReceivable(movies, maxSize, cap)) {
                rt = cap - 1;
                answer = cap;
            } else {
                lt = cap + 1;
            }
        }

        return answer;
    }

    private static boolean isReceivable(int[] movies, int maxSize, int cap) {

        int token = 1;
        int sum = 0;
        for (int movie : movies) {
            sum += movie;
            if (sum > cap) {
                token ++;
                sum = movie;
            }
        }
        return token <= maxSize;
    }
}
