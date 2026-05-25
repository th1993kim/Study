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

    static int answer, n , m, size;
    static int[] dis;
    static List<Point> pizzaList, customerList;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

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

        dis = new int[customerList.size() + 1];
        for (int i = 0; i < dis.length; i++) {
            if (i != 0) {
                dis[i] = Integer.MAX_VALUE;
            }
        }
        int[] pizzaSelect = new int[pizzaList.size() + 1];
        dfs(0, pizzaSelect, 0);

        for (int di : dis) {
            answer += di;
        }
        System.out.println(answer);
    }

    private static void dfs(int level, int[] pizzaSelect, int selectSize) {
        if (selectSize > 4 || level >= 6) {
            return;
        } else {
            if (level > 0 && pizzaSelect[level] == 1) {
                Point pizza = pizzaList.get(level - 1);
                for (int i = 0; i < customerList.size(); i++) {
                    dis[i+1] = Math.min(dis[i+1], calculateDis(pizza, customerList.get(i)));
                }
            }
            pizzaSelect[level + 1] = 1;
            dfs(level + 1, pizzaSelect, size + 1);
            pizzaSelect[level + 1] = 0;
            dfs(level + 1, pizzaSelect, size - 1);
        }
    }

    private static int calculateDis(Point pizza, Point customer) {
        return Math.abs(pizza.x - customer.x) + Math.abs(pizza.y - customer.y);
    }
}
