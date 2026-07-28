package Y2026M07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NeetCode49 {
    static class Solution {
        public int lastStoneWeight(int[] stones) {
            // 무게가 큰순인 우선순위 큐를 만든다.
            // 2개씩꺼내면서 큰것에서 작은것을 뺀다.
            // 0이면 넣지 않고 0이상이면 다시 넣는다.
            // 이게 1개 이하로 남을때까지 반복한다.

            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

            for (int number : stones) {
                queue.add(number);
            }

            while (queue.size() > 1) {
                int a = queue.poll();
                int b = queue.poll();
                int remain = Math.abs(a - b);

                if (remain > 0) {
                    queue.add(remain);
                }
            }

            if (queue.size() == 0) return 0;

            return queue.poll();
        }
    }

}
