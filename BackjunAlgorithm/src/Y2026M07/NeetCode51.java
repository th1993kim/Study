package Y2026M07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NeetCode51 {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 우선순위 큐 => 내림차순
            // 배열 순회하면서 큐에 저장한다.
            // 우선순위에서 빼면서 k까지 카운팅한다.
            // 결과 반환해준다.


            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < nums.length; i++) {
                queue.add(nums[i]);
            }

            int count = 0;
            int answer = 0;
            while (count < k) {
                answer = queue.poll();
                count++;
            }

            return answer;
        }
    }

}
