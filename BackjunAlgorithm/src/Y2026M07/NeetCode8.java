package Y2026M07;

public class NeetCode8 {

    static class Solution {
        public int search(int[] nums, int target) {

            int lt = 0, rt = nums.length - 1;
            while (lt <= rt) {
                int mid = (rt + lt) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }

            return -1;
        }
    }

}
