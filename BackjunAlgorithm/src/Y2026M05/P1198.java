package Y2026M05;

import java.util.*;

public class P1198 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = scanner.nextInt();
        }
        System.out.println(solution(0, inputs, new ArrayList<>()) ? "YES" : "NO");

    }

    private static boolean solution(int n, int[] inputs, List<Integer> list) {
        int sum = Arrays.stream(inputs).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int match = sum / 2;
        int result = 0;
        for (Integer i : list) {
            result += i;
        }
        if (result == match) {
            return true;
        } else if (n >= inputs.length) {
            return false;
        }

        list.add(inputs[n]);
        boolean tempResult = solution(n + 1, inputs, list);
        if (tempResult) {return true;}
        list.remove(list.size() - 1);
        tempResult = solution(n + 1, inputs, list);
        if (tempResult) {return true;}
        return false;
    }
}
