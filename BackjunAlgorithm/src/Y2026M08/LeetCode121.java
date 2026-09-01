package Y2026M08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode121 {
    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> answer = new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;
            // 투포인터를 사용하기 위해 정렬하고
            // 2가지 숫자는 겹치지 않는 방식으로 지정한다.
            // 이후 나머지 2숫자에 대해서는 투포인트 방식으로 접근하여 합이 일치하는 값들을 배열에 넣어주면된다.
            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i] == nums[i-1]) continue;
                for (int j = i + 1; j < n; j++) {
                    if (j > i + 1 && nums[j] == nums[j-1]) continue;

                    int lt = j + 1;
                    int rt = n - 1;

                    while (lt < rt) {
                        long sum = (long) nums[i] + nums[j] + nums[lt] + nums[rt];

                        if (sum >= Integer.MAX_VALUE) {
                            break;
                        }
                        if (sum < target) {
                            lt++;
                        } else if (sum > target) {
                            rt--;
                        } else {
                            answer.add(List.of(nums[i], nums[j], nums[lt], nums[rt]));

                            while(lt < rt && nums[lt] == nums[lt + 1]) {
                                lt++;
                            }
                            while(lt < rt && nums[rt] == nums[rt - 1]) {
                                rt--;
                            }
                            lt++;
                            rt--;
                        }
                    }
                }

            }
            return answer;
        }
    }
}
