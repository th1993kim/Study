package Y2026M05;

import java.util.*;

public class P1208 {

    static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static int answer = Integer.MAX_VALUE;
    static int n, m;
    static List<Point> pizzaList, customerList;
    static int[] selected;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        selected = new int[m];
        pizzaList = new ArrayList<>();
        customerList = new ArrayList<>();
        for (int i=1; i<=4; i++) {
            for (int j=1; j<=4; j++) {
                int input = scanner.nextInt();
                if (input == 2) {
                    pizzaList.add(new Point(i, j));
                }

                if (input == 1) {
                    customerList.add(new Point(i, j));
                }
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int level, int startPoint) {
        if (level == 4) {
            int sum = 0;

            for (Point customer : customerList) {

                int dis = Integer.MAX_VALUE;
                for (int i : selected) {
                    Point pizza = pizzaList.get(i);
                    dis = Math.min(dis, calculateDis(pizza, customer));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = startPoint; i < pizzaList.size(); i++) {
                selected[level] = i;
                dfs(level + 1, i + 1);
            }
        }
    }

    private static int calculateDis(Point pizza, Point customer) {
        return Math.abs(pizza.x - customer.x) + Math.abs(pizza.y - customer.y);
    }
}
