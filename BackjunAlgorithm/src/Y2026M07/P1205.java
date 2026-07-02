package Y2026M07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1205 {


    static int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] maps = new int[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                maps[i][j] = scanner.nextInt();
            }
        }


        int answer = solution(maps);

        System.out.println(answer);
    }

    private static int solution(int[][] maps) {
        int answer = 0;

        int[][] moveChecker = new int[7][7];
        Queue<Point> queue = new LinkedList<>();
        Point start = new Point(0, 0);
        queue.offer(start);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Point presentPoint = queue.poll();
                if (presentPoint.x == 6 && presentPoint.y == 6) {
                    return answer;
                }
                if (moveChecker[presentPoint.y][presentPoint.x] == 0) {
                    moveChecker[presentPoint.y][presentPoint.x] = 1;
                } else {
                    continue;
                }
                for (int[] move : moves) {
                    Point nextPoint = new Point(presentPoint.x + move[1], presentPoint.y + move[0]);
                    if (nextPoint.x >= 0 && nextPoint.x <= 6 && nextPoint.y >= 0 && nextPoint.y <= 6 && maps[nextPoint.y][nextPoint.x] == 0) {
                        queue.offer(nextPoint);
                    }
                }
            }
            answer++;
        }

        return -1;
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
