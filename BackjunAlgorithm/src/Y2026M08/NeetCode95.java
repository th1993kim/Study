package Y2026M08;

import java.util.*;

public class NeetCode95 {
    static class Solution {

        public int networkDelayTime(int[][] times, int n, int k) {
            Map<Integer, List<int[]>> graph = new HashMap<>();

            for (int i = 0; i < times.length; i++) {
                graph.computeIfAbsent(times[i][0], key -> new ArrayList<>())
                        .add(new int[]{times[i][1], times[i][2]});
            }

            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

            queue.offer(new int[]{k, 0});

            int value[] = new int[n+1];

            for (int i = 0; i < value.length; i++) {
                value[i] = Integer.MAX_VALUE;
            }
            value[k] = 0;
            while(!queue.isEmpty()) {
                int[] current = queue.poll();
                int node = current[0];
                int dist = current[1];
                if (dist > value[node]) continue;

                List<int[]> nextList = graph.get(node);
                if (nextList != null) {
                    for (int[] next : nextList) {
                        int nextNode = next[0];
                        int nextValue = next[1];
                        int nextDist = dist + nextValue;
                        if (value[nextNode] > nextDist) {
                            value[nextNode] = nextDist;
                            queue.offer(new int[]{nextNode, nextDist});
                        }
                    }
                }
            }

            int max = 0;
            for (int i = 1; i < value.length; i++) {
                if (value[i] == Integer.MAX_VALUE) return -1;
                max = Math.max(value[i], max);
            }

            return max;
        }
    }

}
