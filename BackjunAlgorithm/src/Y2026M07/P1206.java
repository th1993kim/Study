package Y2026M07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1206 {

    static int n, m;
    static int[][] tomatos;
    static int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();

        Queue<Point> even = new LinkedList<>();
        tomatos = new int[n][m];

        int total = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                int status = scanner.nextInt();
                tomatos[y][x] = status;
                if (status != -1) {
                    total++;
                }
                if (status == 1) {
                    even.add(new Point(x, y));
                }
            }
        }

        int answer = solution(even, total);

        System.out.println(answer);
    }

    private static int solution(Queue<Point> even, int total) {

        int answer = 0;
        int sum = 0;
        while(!even.isEmpty()) {
            int evenSize = even.size();

            for (int i = 0; i < evenSize; i++) {
                Point point = even.poll();
                sum ++;
                if (sum == total) {
                    return answer;
                } else {
                    for (int[] move : moves) {
                        Point np = new Point(point.x + move[1], point.y + move[0]);
                        if (np.x >= 0 && np.x < m && np.y >= 0 && np.y < n && tomatos[np.y][np.x] == 0) {
                            even.add(np);
                            tomatos[np.y][np.x] = 1;
                        }
                    }
                }
            }
            answer++;
        }

        return -1;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
