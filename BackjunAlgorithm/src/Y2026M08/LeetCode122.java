package Y2026M08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode122 {

    static class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                set.add(nums[i]);
            }

            int answer = 0;
            for (Integer point : set) {
                if (set.contains(point - 1)) {
                    continue;
                }
                int size = 0;
                while (set.contains(point)) {
                    size++;
                    point++;
                }

                answer = Math.max(answer, size);
            }

            return answer;
        }
    }
}
