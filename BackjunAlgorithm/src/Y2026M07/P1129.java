package Y2026M07;

import java.util.*;

public class P1129 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers1 = new int[n];
        for (int i = 0; i < n; i++) {
            numbers1[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] numbers2 = new int[m];
        for (int i = 0; i < m; i++) {
            numbers2[i] = scanner.nextInt();
        }

        List<Integer> answer = solution(n, numbers1, m, numbers2);

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

    private static List<Integer> solution(int n, int[] numbers1, int m, int[] numbers2) {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> numberSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            numberSet.add(numbers1[i]);
        }

        for (int i = 0; i < m; i++) {
            if (numberSet.contains(numbers2[i])) {
                answer.add(numbers2[i]);
            }
        }

        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
