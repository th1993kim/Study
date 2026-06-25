package Y2026M06;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1157 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int answer = solution(n, k);

        System.out.println(answer);
    }

    private static int solution(int n, int k) {

        Queue<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        while (deque.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                deque.offer(deque.poll());
            }
            deque.poll();
        }

        return deque.poll();
    }
}
