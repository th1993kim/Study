package Y2026M05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1205 {

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0 ,-1};
    static int[][] dis, map;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dis = new int[8][8];
        map = new int[8][8];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        solution(1, 1);
        if (dis[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[7][7]);
        }
    }

    private static void solution(int x, int y) {
        Point point = new Point(x, y);
        Queue<Point> queue = new LinkedList<>();
        map[1][1] = 1;
        // dis[1][1] = 1 로하지않는 이유는 출발점이기때문.
        queue.offer(point);
        while (!queue.isEmpty()) {
            Point tempPoint = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tempPoint.x + xMove[i];
                int ny = tempPoint.y + yMove[i];
                if (nx >= 1 && ny >= 1 && nx <= 7 && ny <= 7 && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    dis[nx][ny] = dis[tempPoint.x][tempPoint.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }
}
