package Y2026M06;

import java.util.*;

public class P1143 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int answer = solution(n, k, list);
        System.out.println(answer);
    }

    private static int solution(int n, int k, List<Integer> list) {

        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    set.add(list.get(i) + list.get(j) + list.get(l));
                }
            }
        }

        int count = 1;
        for (int sum : set) {
            if (count == k) {
                return sum;
            }
            count ++;
        }

        return -1;
    }
}
