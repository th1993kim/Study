package Y2026M07;

public class NeetCode75 {

    static class Solution {

        int[][] dir = new int[][]{
                {0, 1},
                {-1, 0},
                {0, -1},
                {1, 0}
        };

        public int maxAreaOfIsland(int[][] grid) {
            int answer = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        answer = Math.max(answer, dfs(i, j, grid));
                    }
                }
            }
            return answer;
        }

        private int dfs(int y, int x, int[][] grid) {
            int area = 1;
            grid[y][x] = 0;
            for (int i = 0; i < dir.length; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];

                if (ny >= 0 && nx >= 0
                        && ny < grid.length && nx < grid[0].length
                        && grid[ny][nx] == 1) {
                    area += dfs(ny, nx, grid);
                }
            }

            return area;
        }
    }

}
