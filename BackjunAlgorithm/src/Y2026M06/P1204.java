package Y2026M06;

import java.util.Scanner;

public class P1204 {

    static int answer = 0;
    static int[][] visited = new int[7][7];
    static int[][] moves = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] roads = new int[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                roads[i][j] = scanner.nextInt();
            }
        }

        visited[0][0] = 1;
        dfs(0, 0, roads);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int[][] roads) {

        if (x == 6 && y == 6) {
            answer++;
            return;
        }

        if (roads[y][x] == 1) {
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int moveX = x + moves[i][1];
                int moveY = y + moves[i][0];
                if (moveX >= 0 && moveX <= 6 && moveY >= 0 && moveY <= 6 && visited[moveY][moveX] == 0) {
                    visited[moveY][moveX] = 1;
                    dfs(moveX, moveY, roads);
                    visited[moveY][moveX] = 0;
                }
            }
        }
    }
}
