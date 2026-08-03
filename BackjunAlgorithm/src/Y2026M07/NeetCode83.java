package Y2026M07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                    dfs(i, visited, graph);
                }
            }

            return countComponents;
        }

        private void dfs(int current, boolean[] visited, List<Integer>[] graph) {
            visited[current] = true;

            for (Integer child : graph[current]) {
                if (!visited[child]) {
                    dfs(child, visited, graph);
                }
            }
        }
    }

}
