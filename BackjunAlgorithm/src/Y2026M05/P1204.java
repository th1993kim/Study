package Y2026M05;

import java.util.Scanner;

public class P1204 {

    static int answer = 0;
    static int[][] map = new int[8][8];

    static int[] xMove = {-1, 0, 1, 0};
    static int[] yMove = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        map[1][1] = 1;
        solution(1, 1);

        System.out.println(answer);
    }

    private static void solution(int x, int y) {
        if (x == 7 && y == 7) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + xMove[i];
                int ny = y + yMove[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && map[nx][ny] == 0) {
                    map[nx][ny] = 1;
                    solution(nx, ny);
                    map[nx][ny] = 0;
                }
            }
        }
    }
}
