package Y2026M09;

import java.util.ArrayList;
import java.util.List;

public class LeetCode223 {
    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 사이클이 되는 경우를 찾아야한다. (그래프 탐색)
            // prerequisites[i][1] 은 선행, prerequisites[i][0] 은 다음 수업이된다.
            // 선행 - 후순위목록으로 그래프를 만들어주고 선행 -> 후순위도 순회를 하면서 방문여부를 체크한다.

            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < prerequisites.length; i++) {
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            // visited = 0 미방문
            // visited = 1 방문중
            // visited = 2 방문완료
            int[] visited = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (!dfs(i, graph, visited)) {
                    return false;
                }
            }

            return true;
        }

        boolean dfs(int index, List<List<Integer>> graph, int[] visited) {
            if (visited[index] == 1) {
                return false;
            }

            if (visited[index] == 2) {
                return true;
            }

            visited[index] = 1;

            List<Integer> neiborList = graph.get(index);
            for (Integer neibor : neiborList) {
                if (!dfs(neibor, graph, visited)) {
                    return false;
                }
            }

            visited[index] = 2;

            return true;
        }
    }
}
