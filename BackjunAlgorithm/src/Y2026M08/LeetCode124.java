package Y2026M08;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode124 {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < nums.length; i++) {
                pq.offer(nums[i]);
            }

            int answer = 0;
            for (int i = 0; i < k; i++) {
                answer = pq.poll();
            }

            return answer;
        }
    }
}
