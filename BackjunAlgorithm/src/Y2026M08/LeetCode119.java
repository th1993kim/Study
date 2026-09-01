package Y2026M08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode119 {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> answer = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                int first = nums[i];
                // 이전값을 SET을 사용하지 않고 건너뛰는 방법
                if (i > 0 && nums[i] == nums[i-1]) continue;
                int lt = i + 1;
                int rt = nums.length - 1;
                while (lt < rt) {
                    int sum = first + nums[lt] + nums[rt];
                    if (sum == 0) {
                        answer.add(List.of(first, nums[lt], nums[rt]));

                        // 다음값으로 진행시 앞에 중복된 값인 경우 이러한 방식으로 건너뛸 수 있다.
                        while (lt < rt && nums[lt] == nums[lt + 1]) {
                            lt++;
                        }
                        while (lt < rt && nums[rt] == nums[rt - 1]) {
                            rt--;
                        }
                        lt ++;
                        rt --;
                    } else if (sum < 0) {
                        lt ++;
                    } else {
                        rt --;
                    }
                }
            }

            return answer;
        }
    }
}
