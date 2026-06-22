package Y2026M06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1141 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] answer = solution(n, k, arr);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static int[] solution(int n, int k, int[] arr) {

        int[] answer = new int[n-k+1];
        Map<Integer, Integer> map = new HashMap<>();
        int lt = 0;
        int size = 0;
        int index = 0;
        for (int rt = 0; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            size++;

            while(size > k) {
                int count = map.get(arr[lt]);
                if (count == 1) {
                    map.remove(arr[lt]);
                } else {
                    map.put(arr[lt], count - 1);
                }
                size--;
                lt++;
            }

            if (size == k) {
                answer[index++] = map.size();
            }
        }


        return answer;
    }
}
