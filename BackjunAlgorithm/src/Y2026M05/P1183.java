package Y2026M05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1183 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int source = scanner.nextInt();
        int target = scanner.nextInt();

        System.out.println(solution(source, target));
    }

    private static int solution(int source, int target) {

        int[] check = new int[10001];
        int[] trip = {1, 5, -1};
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;
        queue.offer(source);
        while(!queue.isEmpty()) {

            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Integer position = queue.poll();
                for (int k : trip) {
                    int nextPosition = position + k;
                    if (nextPosition == target) return level + 1;
                    if (nextPosition >= 1 && nextPosition <= 10000 && check[nextPosition] == 0) {
                        check[nextPosition] = 1;
                        queue.offer(nextPosition);
                    }
                }
            }

            level++;
        }

        return level;
    }
}
