package Y2026M07;

import java.util.PriorityQueue;

public class NeetCode50 {
    static class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(
                    (a, b) -> Integer.compare(dis(b), dis(a))
            );

            for (int i=0; i < points.length; i++) {
                queue.add(new int[]{points[i][0], points[i][1]});
                if (queue.size() > k) {
                    queue.poll();
                }
            }

            int[][] answer = new int[queue.size()][2];

            int index = 0;
            while(!queue.isEmpty()) {
                answer[index] = queue.poll();
                index++;
            }

            return answer;
        }

        private static class Point {
            private int x;
            private int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        private int dis(int[] point) {
            return point[0] * point[0] + point[1] * point[1];
        }
    }

}
