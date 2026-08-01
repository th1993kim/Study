package Y2026M07;

import java.util.ArrayDeque;
import java.util.Queue;

public class NeetCode74 {
    static class Solution {
        private int[][] dir = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        private boolean[][] visited;
        public int numIslands(char[][] grid) {

            // 그리드배열을 순회하면서 0인것은 지나가고
            // 1을 만나면 거기서부터 시작하여 이동하면서 1인것들을 방문했다고 색칠해준다.
            // 이떄 방문한적이 없는 1을 만난 경우 횟수를 1증가시킨다.
            visited = new boolean[grid.length][grid[0].length];
            Queue<int[]> queue = new ArrayDeque<>();
            int answer = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        answer++;
                        visited[i][j] = true;
                        queue.offer(new int[]{i, j});

                        while (!queue.isEmpty()) {
                            int[] np = queue.poll();
                            int y = np[0];
                            int x = np[1];

                            for (int k = 0; k < dir.length; k++) {
                                int ny = y + dir[k][0];
                                int nx = x + dir[k][1];

                                if (ny >= 0 && nx >= 0 && ny <= grid.length - 1 && nx <= grid[0].length - 1 && grid[ny][nx] == '1' && !visited[ny][nx]){
                                    visited[ny][nx] = true;
                                    queue.offer(new int[]{ny, nx});
                                }

                            }
                        }

                    }
                }
            }

            return answer;
        }
    }

}
