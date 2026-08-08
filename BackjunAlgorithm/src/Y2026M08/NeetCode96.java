package Y2026M08;

import java.util.PriorityQueue;

public class NeetCode96 {
    static class Solution {

        public int minCostConnectPoints(int[][] points) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            boolean[] isVisited = new boolean[points.length];
            pq.offer(new int[]{0, 0});
            int count = 0;
            int sum = 0;
            while(!pq.isEmpty() && count < points.length) {
                int[] current = pq.poll();
                int currentIndex = current[0];
                int currentValue = current[1];

                if (isVisited[currentIndex]) continue;

                isVisited[currentIndex] = true;
                sum += currentValue;
                count++;

                for (int i = 0; i < points.length; i++) {
                    if (isVisited[i]) continue;
                    int nextValue = Math.abs(points[currentIndex][0] - points[i][0]) +
                            Math.abs(points[currentIndex][1] - points[i][1]);
                    pq.offer(new int[]{i, nextValue});
                }

            }

            return sum;
        }
    }

}
