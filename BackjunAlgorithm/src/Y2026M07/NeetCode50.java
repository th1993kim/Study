package Y2026M07;

import java.util.PriorityQueue;

public class NeetCode50 {
    static class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<Point> queue = new PriorityQueue<>(
                    (a, b) -> Integer.compare(dis(b.x, b.y), dis(a.x, a.y))
            );

            for (int i=0; i < points.length; i++) {
                queue.add(new Point(points[i][0], points[i][1]));
                if (queue.size() > k) {
                    queue.poll();
                }
            }

            int[][] answer = new int[queue.size()][2];

            int index = 0;
            while(!queue.isEmpty()) {
                Point point = queue.poll();
                answer[index][0] = point.x;
                answer[index][1] = point.y;
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

        private int dis(int a, int b) {
            return Math.abs(a * a) + Math.abs(b * b);
        }
    }

}
