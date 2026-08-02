package Y2026M07;

public class NeetCode77 {
    static class Solution {

        private int[][] move = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        private static final int INF = 2147483647;
        public void islandsAndTreasure(int[][] grid) {
            Queue<int[]> dsQ = new ArrayDeque<>();

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) dsQ.offer(new int[]{i, j});
                }
            }
            int distance = 0;
            while (!dsQ.isEmpty()) {
                int queueSize = dsQ.size();
                for (int k = 0; k < queueSize; k++) {
                    int[] current = dsQ.poll();
                    int y = current[0];
                    int x = current[1];

                    for (int i = 0; i < move.length; i++) {
                        int ny = y + move[i][0];
                        int nx = x + move[i][1];

                        if (ny < 0 || nx < 0 || ny > grid.length -1 || nx > grid[0].length - 1) continue;

                        if (grid[ny][nx] != INF) continue;

                        grid[ny][nx] = distance + 1;
                        dsQ.offer(new int[]{ny, nx});
                    }
                }
                distance++;
            }

        }
    }

}
