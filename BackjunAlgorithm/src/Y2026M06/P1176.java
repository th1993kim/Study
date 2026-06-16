package Y2026M06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1176 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            points.add(new Point(scanner.nextInt(), scanner.nextInt()));
        }

        points.sort(Point::compareTo);

        for (Point point : points) {
            System.out.println(point.x + " " + point.y);
        }
    }

    static class Point implements Comparable<Point>{
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) return this.y - o.y;

            return this.x - o.x;
        }
    }
}
