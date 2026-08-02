package Y2026M07;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NeetCode79 {
    static class Solution {

        private final int[][] move = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            boolean[][] pacific = new boolean[heights.length][heights[0].length];
            boolean[][] atlan = new boolean[heights.length][heights[0].length];

            for (int i = 0; i < heights[0].length; i++) {
                dfs(0, i, pacific, heights);
                dfs(heights.length -1, i, atlan, heights);
            }

            for (int i = 0; i < heights.length; i++) {
                dfs(i, 0, pacific, heights);
                dfs(i, heights[0].length - 1, atlan, heights);
            }


            List<List<Integer>> answer = new ArrayList<>();

            for (int i = 0; i < heights.length; i++) {
                for (int j = 0; j < heights[0].length; j++) {
                    if (pacific[i][j] && atlan[i][j]) answer.add(List.of(i, j));
                }
            }

            return answer;
        }

        private void dfs(int y, int x, boolean[][] checker, int[][] heights) {
            if (checker[y][x]) return;

            checker[y][x] = true;

            for (int i = 0; i < move.length; i++) {
                int ny = y + move[i][0];
                int nx = x + move[i][1];

                if (ny < 0 || nx < 0
                        || ny > heights.length - 1 || nx > heights[0].length - 1
                        || heights[ny][nx] < heights[y][x]
                ) {
                    continue;
                }

                if (checker[ny][nx]) continue;
                dfs(ny, nx, checker, heights);
            }
        }

    }

}
