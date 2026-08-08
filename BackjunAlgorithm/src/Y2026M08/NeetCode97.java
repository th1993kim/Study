package Y2026M08;

import java.util.*;

public class NeetCode97 {
    static class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

            Map<Integer, List<int[]>> graph = new HashMap<>();

            for (int[] flight : flights) {
                graph.computeIfAbsent(flight[0], key -> new ArrayList<>())
                        .add(new int[]{flight[1], flight[2]});
            }

            int[][] dist = new int[n][k+2];

            for (int[] row : dist) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

            dist[src][0] = 0;

            pq.offer(new int[]{src, 0, 0});

            while(!pq.isEmpty()) {
                int[] current = pq.poll();
                int node = current[0];
                int cost = current[1];
                int count = current[2];

                if (node == dst) return cost;

                if (count == k + 1) continue;

                if (cost > dist[node][count]) continue;

                List<int[]> nextList = graph.get(node);

                if (nextList == null) continue;

                for (int[] next : nextList) {
                    int nextNode = next[0];
                    int nextCost = cost + next[1];
                    int nextCount = count + 1;
                    if (nextCost < dist[nextNode][nextCount]) {
                        dist[nextNode][nextCount] = nextCost;
                        pq.offer(new int[]{nextNode, nextCost, nextCount});
                    }
                }
            }

            return -1;

        }
    }

}
