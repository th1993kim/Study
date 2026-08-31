package Y2026M08;

public class LeetCode117 {
    static class Solution {
        public int search(int[] nums, int target) {
            // mid < target 일때,
            // rt < target인 경우  rt = mid - 1로 시작
            // 그렇지 않은 경우 lt = mid + 1

            int lt = 0;
            int rt = nums.length - 1;

            while (lt <= rt){
                int mid = (rt + lt) / 2;
                if (nums[mid] == target) return mid;

                // 왼쪽 정렬안에 포함되는 경우
                if (nums[lt] <= nums[mid]) {
                    // lt와 mid 안에 값이 존재
                    if (nums[lt] <= target && target <= nums[mid]) {
                        rt = mid - 1;
                    } else {
                        lt = mid + 1;
                    }

                    //우측이 정렬되어있는 경우
                } else {
                    // rt와 mid 사이에 값이 존재
                    if (nums[rt] >= target && target > nums[mid]) {
                        lt = mid + 1;
                    } else {
                        rt = mid - 1;
                    }
                }

            }

            return -1;
        }
    }
}
