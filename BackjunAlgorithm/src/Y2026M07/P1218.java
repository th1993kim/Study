package Y2026M07;

import java.util.Scanner;

public class P1218 {

    static int[] group;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        group = new int[n+1];

        for (int i = 1; i <= n; i++) {
            group[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            union(a,b);
        }

        int fa = find(scanner.nextInt());
        int fb = find(scanner.nextInt());

        if (fa == fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static int find(int a) {
        if (group[a] == a) return a;
        return group[a] = find(group[a]);
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            group[fa] = fb;
        }
    }
}
