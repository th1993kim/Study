package Y2026M07;

import java.util.ArrayList;
import java.util.List;

public class NeetCode82 {

    static class Solution {

        public boolean validTree(int n, int[][] edges) {
            boolean[] visited = new boolean[n];
            List<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < edges.length; i++) {
                int pre = edges[i][0];
                int back = edges[i][1];

                graph[pre].add(back);
                graph[back].add(pre);
            }


            boolean result = hasCycle(visited, 0, -1, graph);

            for (int i = 0; i < n; i++) {
                if(!visited[i]) return false;
            }
            return result;
        }

        private boolean hasCycle(boolean[] visited, int root, int parent, List<Integer>[] graph) {
            if (visited[root]) return false;

            visited[root] = true;
            for (Integer sub : graph[root]) {
                if (sub == parent) continue;
                if (!hasCycle(visited, sub, root, graph)) return false;
            }

            return true;
        }
    }

}
