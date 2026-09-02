package Y2026M08;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode124 {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < nums.length; i++) {
                pq.offer(nums[i]);
                //최소 힙으로 선정하는 경우 큰 수가 k개까지 담는 처리를 한 다음
                // pq.poll()을 통해 가장 작은 수를 빼내는 식으로 진행하면 peek()는 k번째로 큰수가 쌓일 수 있다.
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            return pq.peek();
        }
    }
}
