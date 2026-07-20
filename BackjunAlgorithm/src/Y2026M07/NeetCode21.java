package Y2026M07;

public class NeetCode21 {
    class Solution {
        public int findMin(int[] nums) {
            int lp = 0;
            int rp = nums.length - 1;
            while (lp < rp) {
                int mid = (lp + rp) / 2;
                if (nums[mid] <= nums[rp]) {
                    rp = mid;
                } else {
                    lp = mid +1;
                }

            }

            return nums[lp];
        }
    }

}
