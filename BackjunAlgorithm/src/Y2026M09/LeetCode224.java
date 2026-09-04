package Y2026M09;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode224 {
    static class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // 동일하게 그래프를 이용할 수 있는데,
            // 여기서는 위상정렬을 통해 가장 먼저번에 처리할 수 있는 노드를 선택해서 시작해야한다.
            int[] answer = new int[numCourses];
            List<List<Integer>> graph = new ArrayList<>();
            int[] degree = new int[numCourses]; // 해당 수업을 진행하기 위해 선행되어야하는 수업수
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < prerequisites.length; i++) {
                int pre = prerequisites[i][1];
                int after = prerequisites[i][0];
                graph.get(pre).add(after);
                degree[after]++;
            }

            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (degree[i] == 0) queue.offer(i);
            }

            int index = 0;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                answer[index++] = current;
                List<Integer> nextList = graph.get(current);
                for (Integer next : nextList) {
                    degree[next]--;
                    if (degree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            if (index < numCourses) {
                return new int[0];
            }

            return answer;
        }
    }
}
