package Y2026M05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubSet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n + 1];
        for (int i = 1; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        dfs(1, array, new ArrayList<>());
    }

    private static void dfs(int n, int[] array, List<Integer> subset) {
        if (array.length == n) {
            System.out.println("subset: " + subset);
        } else {
            subset.add(array[n]);
            dfs(n + 1, array, subset);
            subset.remove(subset.size() - 1);
            dfs(n + 1, array, subset);
        }
    }
}
