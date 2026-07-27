package Y2026M07;

import java.util.PriorityQueue;

public class NeetCode48 {
    static class KthLargest {

        private PriorityQueue<Integer> minHeap;
        private int maxHeapSize;
        public KthLargest(int k, int[] nums) {
            maxHeapSize = k;
            minHeap = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            minHeap.offer(val);
            if (minHeap.size() > maxHeapSize) {
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }

}
