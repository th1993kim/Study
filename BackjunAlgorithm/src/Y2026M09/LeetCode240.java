package Y2026M09;

public class LeetCode240 {

    static class Solution {

        static final int[][] DIRECTION = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        public int numIslands(char[][] grid) {
            // 1을 만나는 지점 도달시 DFS를 통해 모두 0으로 만들어주고,  answer 에 값을 하나씩 누적시키는 방안

            int answer = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        answer++;
                        dfs(i, j, grid);
                    }
                }
            }

            return answer;
        }

        void dfs(int y, int x, char[][] grid) {
            if (y < 0 || x < 0 || y >= grid.length || x >= grid[0].length) return;
            if (grid[y][x] == '0') return;

            grid[y][x] = '0';

            for (int i = 0; i < DIRECTION.length; i++) {
                int ny = y + DIRECTION[i][0];
                int nx = x + DIRECTION[i][1];
                dfs(ny, nx, grid);
            }
        }
    }
}
