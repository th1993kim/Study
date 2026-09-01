package Y2026M08;

public class LeetCode123 {
    static class Solution {

        int[][] direction = new int[][]{{0,1}, {1,0}, {0, -1}, {-1, 0}};
        public void solve(char[][] board) {
            // 바깥 테두리에서부터 시작하게 되면, 살릴수있는 'O'를 빠르게 찾을 수 있고, DFS를 통해서 진행해나아가면서 연결된 O를 모두 살릴 수 있다.

            int n = board.length;
            int m = board[0].length;

            for (int i = 0; i < m; i++) {
                if (board[0][i] == 'O') dfs(0, i, board);
                if (board[n-1][i] == 'O') dfs(n-1, i, board);
            }


            for (int i = 1; i < board.length - 1; i++) {
                if (board[i][0] == 'O') dfs(i, 0, board);
                if (board[i][m-1] == 'O') dfs(i, m-1, board);
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j< board[0].length; j++) {
                    if (board[i][j] == 'O') board[i][j] = 'X';
                    if (board[i][j] == 'P') board[i][j] = 'O';
                }
            }

        }

        private void dfs(int y, int x, char[][] board) {
            if (board[y][x] == 'P') return;

            board[y][x] = 'P';

            for (int i = 0; i < direction.length; i++) {
                int nx = x + direction[i][1];
                int ny = y + direction[i][0];
                if (nx >= 0 && nx < board[0].length && ny >= 0 && ny < board.length && board[ny][nx] == 'O') {
                    dfs(ny, nx, board);
                }
            }
        }
    }
}
