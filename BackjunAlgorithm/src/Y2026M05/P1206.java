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
    static int total, count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[n][m];

        Queue<List<Point>> queue = new LinkedList<>();
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
                if (arr[i][j] == 1) {
                    pointList.add(new Point(i, j));
                }
                if (arr[i][j] == 0) {
                    total++;
                }
            }
        }
        queue.add(pointList);

        if (total == 0) {
            System.out.println(0);
        }
        solution(queue, arr);
        if (total > 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    private static void solution(Queue<List<Point>> queue, int[][] arr) {
        while(!queue.isEmpty()) {

            List<Point> pointList = queue.poll();
            List<Point> newPointList = new ArrayList<>();
            for (Point point : pointList) {
                for(int i = 0; i < 4; i++) {
                    int dx = point.x + xMove[i];
                    int dy = point.y + yMove[i];

                    if (dx >= 0 && dy >= 0 && dy < arr[0].length && dx < arr.length && arr[dx][dy] == 0) {
                        arr[dx][dy] = 1;
                        total--;
                        newPointList.add(new Point(dx, dy));
                    }
                }
            }
            if (!newPointList.isEmpty()) {
                queue.add(newPointList);
                count++;
            }
        }
    }

}
