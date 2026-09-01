package Y2026M08;

import java.util.Arrays;

public class LeetCode120 {
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {

            // 정렬을 진행한다.
            // 숫자 1개를 고정한다.
            // 나머지 숫자 2개에서 target과 비교후 작으면 왼쪽 ++ 크면 --하는데, 이때 가장가까워지는 값을 갱신해준다.

            Arrays.sort(nums);
            int answer = nums[0] + nums[1] + nums[2];
            int n = nums.length;
            for (int i = 0; i < n; i++) {

                int lt = i + 1;
                int rt = n - 1;

                while (lt < rt) {
                    int sum = nums[i] + nums[lt] + nums[rt];
                    int result = Math.abs(target - sum);
                    int beforeResult = Math.abs(target - answer);
                    answer = result < beforeResult ? sum : answer;

                    if (target == sum) {
                        return answer;
                    } else if (target > sum) {
                        lt++;
                    } else {
                        rt--;
                    }
                }

            }

            return answer;
        }
    }
}
