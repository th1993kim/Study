package Y2026M07;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class NeetCode52 {

    static class Solution {
        public int leastInterval(char[] tasks, int n) {
            // 작업 - 수 를 큐에 넣는다.
            int[] taskArr = new int[26];

            for (char task : tasks) {
                taskArr[task - 'A']++;
            }

            PriorityQueue<Integer> workQueue = new PriorityQueue<>(Comparator.reverseOrder());

            for (int task : taskArr) {
                if (task > 0) {
                    workQueue.offer(task);
                }
            }
            int time = 0;
            // 작업을 큐에서 꺼낸다.
            Queue<int[]> coolQueue = new ArrayDeque<>();
            while (!workQueue.isEmpty() || !coolQueue.isEmpty()) {
                time++;

                if (!coolQueue.isEmpty()) {
                    int[] peek = coolQueue.peek();

                    // 다른 대기열의 시간이 끝나면 깨우고 다시 작업큐에 넣는다.
                    if (peek[1] == time) {
                        workQueue.offer(coolQueue.poll()[0]);
                    }
                }

                if (!workQueue.isEmpty()) {
                    int workCount = workQueue.poll();
                    int remainCount = workCount - 1;
                    // 작업수가 남은 경우 동일한 작업을 진행을 하지 않기 위해서 바로 큐에 넣지 않고 다른 대기열에 넣는다.
                    if (remainCount > 0) {
                        coolQueue.offer(new int[]{remainCount, time + n + 1});
                    }
                }


            }
            return time;

        }
    }

}
