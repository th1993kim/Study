package Y2026M07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NeetCode14 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> answer = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {

                if (i > 0 && nums[i] == nums[i-1]) {
                    continue;
                }
                int lt = i + 1;
                int rt = nums.length - 1;

                while (lt < rt) {
                    int sum = nums[lt] + nums[rt];
                    int ltas = - nums[i];
                    if (ltas == sum) {
                        answer.add(List.of(nums[i], nums[lt], nums[rt]));
                        lt++;
                    } else if (sum < ltas){
                        lt++;
                    } else {
                        rt--;
                    }

                    while (lt > i + 1 && lt < rt && nums[lt] == nums[lt -1]) {
                        lt++;
                    }

                    while (rt < nums.length - 2 && rt > lt && nums[rt] == nums[rt+1]) {
                        rt--;
                    }
                }
            }

            return answer;
        }
    }

}
