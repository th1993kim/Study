package Y2026M07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1207 {


    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                map[y][x] = scanner.nextInt();
            }
        }

        int answer = solution(n, map);
        System.out.println(answer);
    }

    private static int solution(int n, int[][] map) {

        int answer = 0;
        int[][] checker = new int[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x] == 1 && checker[y][x] == 0) {
                    checker[y][x] = 1;
                    Queue<Point> queue = new LinkedList<>();
                    queue.offer(new Point(x, y));
                    answer++;

                    while (!queue.isEmpty()) {
                        Point presentPoint = queue.poll();

                        for (int j = 0; j < 8; j++) {
                            Point np = new Point(presentPoint.x + dx[j], presentPoint.y + dy[j]);

                            if (np.x >= 0 && np.x < n && np.y >= 0 && np.y < n && checker[np.y][np.x] == 0 && map[np.y][np.x] == 1) {
                                queue.offer(np);
                                checker[np.y][np.x] = 1;
                            }
                        }
                    }

                }
            }
        }
        return answer;
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
