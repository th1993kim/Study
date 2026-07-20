package Y2026M07;

import java.util.HashSet;
import java.util.Set;

public class NeetCode19 {

    static class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> dupSet = new HashSet<>();
            int answer = 0;
            for (int i = 0; i < nums.length; i++) {
                dupSet.add(nums[i]);
            }

            for (Integer number : dupSet) {
                int sum = 0;
                if (!dupSet.contains(number - 1)) {
                    sum += 1;
                    int nextNumber = number + 1;
                    while (dupSet.contains(nextNumber)) {
                        sum += 1;
                        nextNumber++;
                    }
                }

                answer = Math.max(sum, answer);
            }

            return answer;
        }
    }

}
