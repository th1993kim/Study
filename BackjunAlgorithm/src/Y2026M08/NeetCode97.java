package Y2026M08;

import java.util.*;

public class NeetCode97 {
    static class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

            Map<Integer, List<int[]>> dir = new HashMap<>();

            for (int i = 0; i < flights.length; i++) {
                int node = flights[i][0];
                dir.computeIfAbsent(node, key -> new ArrayList<>())
                        .add(new int[]{flights[i][1], flights[i][2]});
            }

            int[] dist = new int[n];
            for (int i = 0; i < dist.length; i++) {
                dist[i] = Integer.MAX_VALUE;
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[2] == b[2]) return a[1] - b[1];

                return a[2] - b[2];
            });

            pq.offer(new int[]{src, 0, 0});


            while(!pq.isEmpty()) {
                int[] current = pq.poll();
                int currentNode = current[0];
                int currentDist = current[1];
                int currentCnt = current[2];

                if (currentDist > dist[currentNode] || currentCnt > k) continue;

                dist[currentNode] = Math.min(currentDist, dist[currentNode]);

                List<int[]> nextList = dir.get(currentNode);
                if (nextList == null) continue;

                for (int[] next : nextList) {
                    int nextNode = next[0];
                    int nextValue = next[1];
                    int nextCount = currentCnt + (nextNode == dst ? 0 : 1);

                    if (dist[nextNode] > currentDist + nextValue && nextCount <= k) {

                        pq.offer(new int[]{nextNode, currentDist + nextValue, nextCount});
                    }
                }
            }

            return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        }
    }

}
