package Y2026M05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P1177 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        List<Integer> inputs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            inputs.add(scanner.nextInt());
        }

        solution(inputs, M);
    }

    private static void solution(List<Integer> inputs, int m) {
        inputs.sort(Comparator.naturalOrder());
        for (int i = 0; i < inputs.size(); i++) {
            if (inputs.get(i) == m) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}
