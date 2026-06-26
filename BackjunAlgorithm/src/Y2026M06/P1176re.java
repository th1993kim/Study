package Y2026M06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1176re {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(new Point(scanner.nextInt(), scanner.nextInt()));
        }

        List<Point> sortedPoints = solution(points);

        for (Point point : sortedPoints) {
            System.out.println(point.x + " " + point.y);
        }

    }

    private static List<Point> solution(List<Point> points) {
        points.sort(Point::compareTo);
        return points;
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return this.x - o.x == 0 ? this.y - o.y : this.x - o.x;
        }
    }
}
