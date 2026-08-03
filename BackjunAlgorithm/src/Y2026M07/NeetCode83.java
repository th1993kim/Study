package Y2026M07;

import java.util.*;

public class NeetCode83 {
    static class Solution {
        public int countComponents(int n, int[][] edges) {
            boolean[] visited = new boolean[n];

            List<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            int countComponents = 0;

            for (int i = 0; i < edges.length; i++) {
                int pre = edges[i][0];
                int back = edges[i][1];

                graph[pre].add(back);
                graph[back].add(pre);
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    countComponents++;
                    bfs(i, visited, graph);
                }
            }

            return countComponents;
        }

        private void bfs(int start, boolean[] visited, List<Integer>[] graph) {

            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(start);
            visited[start] = true;
            while(!queue.isEmpty()) {
                Integer current = queue.poll();
                for (Integer next : graph[current]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    queue.offer(next);
                }
            }

        }
    }

}
