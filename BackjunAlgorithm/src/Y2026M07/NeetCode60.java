package Y2026M07;

public class NeetCode60 {
    static class Solution {

        private boolean[][] visited;
        private int[][] direction = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        public boolean exist(char[][] board, String word) {
            visited = new boolean[board.length][board[0].length];


            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    visited[i][j] = true;
                    if (dfs(j, i, 0, board, word)) {
                        visited[i][j] = false;
                        return true;
                    }
                    visited[i][j] = false;
                }
            }

            return false;
        }

        private boolean dfs(int x, int y, int index, char[][] board, String word) {
            if (board[y][x] != word.charAt(index)) return false;
            if (index == word.length() - 1) {
                return true;
            }

            for (int i = 0; i < direction.length; i++) {
                int nx = x + direction[i][1];
                int ny = y + direction[i][0];
                if (nx < 0 || ny < 0 || nx >= board[0].length || ny >= board.length) continue;
                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;
                if (dfs(nx, ny, index + 1, board, word)) {
                    visited[ny][nx] = false;
                    return true;
                }
                visited[ny][nx] = false;
            }

            return false;
        }
    }

}
