package Y2026M07;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NeetCode81 {
    static class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            int[] indegree = new int[numCourses];
            List<Integer>[] graph = new ArrayList[numCourses];

            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < prerequisites.length; i++) {
                int course = prerequisites[i][0];
                int pre = prerequisites[i][1];
                indegree[course]++;
                graph[pre].add(course);
            }

            Queue<Integer> queue = new ArrayDeque<>();

            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) queue.add(i);
            }


            int[] answer = new int[numCourses];
            int index = 0;
            while(!queue.isEmpty()) {
                int course = queue.poll();
                answer[index++] = course;

                List<Integer> subList = graph[course];
                for (Integer sub : subList) {
                    indegree[sub]--;
                    if (indegree[sub] == 0) {
                        queue.offer(sub);
                    }
                }
            }


            return index == numCourses ? answer : new int[0];
        }
    }

}
