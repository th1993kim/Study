package Y2026M06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1183 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int e = scanner.nextInt();

        int answer = solution(s, e);

        System.out.println(answer);
    }

    private static int solution(int s, int e) {
        int[] moves = {1, -1, 5};
        int[] check = new int[10001];

        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        check[s] = 1;

        while(!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                Integer x = queue.poll();
                if (x == e) return answer;
                for (int move : moves) {
                    int nextX = x + move;
                    if (nextX >= 1 && nextX <= 10000 && check[nextX] == 0) {
                        check[nextX] = 1;
                        queue.offer(nextX);
                    }
                }
            }
            answer++;
        }

        return answer;
    }

}
