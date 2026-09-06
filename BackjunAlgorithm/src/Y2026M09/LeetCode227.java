package Y2026M09;

public class LeetCode227 {
    static class Solution {

        static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        public boolean exist(char[][] board, String word) {
            // 가지치기 + DFS를 이용해보자
            // 이미 방문한곳은 제외
            // 첫글자가 일치하는 부분부터 시작
            // 4방향으로 이동하면서 true가 나오는데까지 이동하고, 그전에 글자 불일치가 나오면 false를 해준다.
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(0, i, j, word, board)) return true;
                }
            }

            return false;
        }

        boolean dfs(int index, int y, int x, String word, char[][] board) {
            if (y < 0 || y >= board.length || x < 0 || x >= board[0].length) return false;
            if (word.charAt(index) != board[y][x]) return false;
            if (index == word.length() - 1) return true;

            char origin = board[y][x];
            board[y][x] = '#';

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][1];
                int ny = y + dir[i][0];

                if (dfs(index + 1, ny, nx, word, board)) {
                    board[y][x] = origin;
                    return true;
                }
            }

            board[y][x] = origin;
            return false;
        }
    }
}
