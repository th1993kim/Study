package Y2026M07;

public class NeetCode80 {
    static class Solution {


        private int[][] move = new int[][]{{0, 1},{-1, 0},{0, -1},{1, 0}};

        public void solve(char[][] board) {
            // 아까와 비슷한 문제인것 같다. boolean 배열을 만들고 바깥에있는 O자표시부터
            // 연결된 O자들을 탐색하면서 (dfs or bfs) boolean배열을 true로 만들고,
            // 이중포문을 한번 더 돌아서 boolean배열 요소가 false인것은 x로 바꿔준다.

            boolean[][] checker = new boolean[board.length][board[0].length];
            for (int i = 0; i < board[0].length; i++) {
                dfs(0, i, checker, board);
                dfs(board.length - 1, i, checker, board);
            }

            for (int i = 0; i < board.length; i++) {
                dfs(i, 0, checker, board);
                dfs(i, board[0].length - 1, checker, board);
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 'O' && !checker[i][j]) board[i][j] = 'X';
                }
            }
        }

        private void dfs(int y, int x, boolean[][] checker, char[][] board) {
            if (board[y][x] == 'X' || checker[y][x]) return;

            checker[y][x] = true;

            for (int i = 0; i < move.length; i++) {
                int ny = y + move[i][0];
                int nx = x + move[i][1];

                if (ny < 0 || nx < 0 || ny > board.length - 1 || nx > board[0].length - 1) {
                    continue;
                }

                if (checker[ny][nx]) continue;

                dfs(ny, nx, checker, board);
            }
        }
    }

}
