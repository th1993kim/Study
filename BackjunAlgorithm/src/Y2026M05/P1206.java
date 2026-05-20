package Y2026M05;

import java.util.*;

public class P1206 {

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] xMove = {1, 0, -1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static int n,m;
    static int total, answer;
    static int[][] board, dis;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        board = new int[n][m];
        dis = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
                if (board[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
                if (board[i][j] == 0) {
                    total++;
                }
            }
        }

        if (total == 0) {
            System.out.println(0);
        }
        solution();
        if (total > 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }
    }

    private static void solution() {
        while(!queue.isEmpty()) {

            Point point = queue.poll();

            for(int i = 0; i < 4; i++) {
                int dx = point.x + xMove[i];
                int dy = point.y + yMove[i];

                if (dx >= 0 && dy >= 0 && dy < m && dx < n && board[dx][dy] == 0) {
                    board[dx][dy] = 1;
                    total--;
                    queue.add(new Point(dx, dy));
                    dis[dx][dy] = dis[point.x][point.y] + 1;
                }
            }

        }
    }

}
