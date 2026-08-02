package Y2026M07;

import java.util.Queue;

public class NeetCode78 {

    static class Solution {

        private static int[][] move = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        public int orangesRotting(int[][] grid) {
            Queue<int[]> rottenQueue = new ArrayDeque<>();
            int freshCount = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) freshCount++;
                    if (grid[i][j] == 2) {
                        rottenQueue.offer(new int[]{i, j});
                    }
                }
            }

            int answer = 0;
            while (!rottenQueue.isEmpty()) {
                int queueSize = rottenQueue.size();

                for (int i = 0; i < queueSize; i++) {
                    int[] rotten = rottenQueue.poll();
                    int y = rotten[0];
                    int x = rotten[1];

                    for (int k = 0; k < move.length; k++) {
                        int ny = y + move[k][0];
                        int nx = x + move[k][1];

                        if (nx < 0 || ny < 0 || ny > grid.length - 1 || nx > grid[0].length -1) continue;
                        if (grid[ny][nx] == 1) {
                            freshCount--;
                            grid[ny][nx] = 2;
                            rottenQueue.offer(new int[]{ny, nx});
                        }
                    }
                }

                if (!rottenQueue.isEmpty()) answer++;
            }
            return freshCount != 0 ? -1 : answer;
        }
    }

}
