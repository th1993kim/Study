package Y2026M07;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NeetCode79 {
    static class Solution {

        private final int[][] move = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            Queue<int[]> pacificQueue = new ArrayDeque<>();
            Queue<int[]> atlanticQueue = new ArrayDeque<>();
            boolean[][] pacificArr = new boolean[heights.length][heights[0].length];
            boolean[][] atlanArr = new boolean[heights.length][heights[0].length];

            List<List<Integer>> answer = new ArrayList<>();

            for (int i = 0; i < heights[0].length; i++) {
                pacificArr[0][i] = true;
                pacificQueue.offer(new int[]{0, i});
                atlanArr[heights.length - 1][i] = true;
                atlanticQueue.offer(new int[]{heights.length - 1, i});

            }

            for (int i = 1; i < heights.length; i++) {
                pacificArr[i][0] = true;
                pacificQueue.offer(new int[]{i, 0});
            }

            for (int i = 0; i < heights.length - 1; i++) {
                atlanArr[i][heights[0].length - 1] = true;
                atlanticQueue.offer(new int[]{i, heights[0].length - 1});
            }


            bfs(heights, pacificQueue, pacificArr);
            bfs(heights, atlanticQueue, atlanArr);

            for (int i = 0; i < heights.length; i++) {
                for (int j = 0; j < heights[0].length; j++) {
                    if (pacificArr[i][j] && atlanArr[i][j]) answer.add(List.of(i, j));
                }
            }

            return answer;
        }

        private void bfs(int[][] heights, Queue<int[]> atlanticQueue, boolean[][] atlanArr) {
            while (!atlanticQueue.isEmpty()) {
                int size = atlanticQueue.size();

                for (int i = 0; i < size; i++) {
                    int[] current = atlanticQueue.poll();
                    int y = current[0];
                    int x = current[1];

                    for (int j = 0; j < move.length; j++) {
                        int ny = y + move[j][0];
                        int nx = x + move[j][1];

                        if (nx < 0 || ny < 0
                                || ny > heights.length - 1 || nx > heights[0].length -1
                                || atlanArr[ny][nx])
                            continue;

                        if (heights[ny][nx] >= heights[y][x]) {
                            atlanArr[ny][nx] = true;
                            atlanticQueue.offer(new int[]{ny, nx});
                        }
                    }
                }
            }
        }
    }

}
