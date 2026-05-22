package Y2026M05;

import java.util.Arrays;
import java.util.Scanner;

public class P1204 {

    static int answer = 0;
    static int[][] map = new int[8][8];

    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        map[1][1] = 1;
        solution(new Point(1, 1), map);

        System.out.println(answer);
    }

    private static void solution(Point point, int[][] beforeMove) {
        if (point.x == 7 && point.y == 7) {
            answer ++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = point.x + xMove[i];
                int ny = point.y + yMove[i];

                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && beforeMove[nx][ny] == 0) {
                    int[][] newMap = beforeMove.clone();
                    System.out.println("x : " + point.x + " y : " +  point.y + " nx :" +nx + "ny : " + ny  + " move : ?" + beforeMove[nx][ny]);
                    newMap[nx][ny] = 1;
                    solution(new Point(nx, ny), newMap);
                }
            }
        }
    }
}
