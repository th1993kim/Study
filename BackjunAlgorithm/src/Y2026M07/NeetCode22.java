package Y2026M07;

public class NeetCode22 {
    static class Solution {
        public int search(int[] nums, int target) {

            int lp = 0;
            int rp = nums.length - 1;
            while (lp < rp) {
                int mid = (lp + rp) / 2;
                if (nums[mid] <= nums[rp]) {
                    rp = mid;
                } else {
                    lp = mid + 1;
                }
            }

            int nlp;
            int nrp;
            if (target >= nums[lp] && target <= nums[nums.length - 1]) {
                nlp = lp;
                nrp = nums.length - 1;
            } else {
                nlp = 0;
                nrp = lp - 1;
            }

            while (nlp <= nrp) {
                int mid = (nlp + nrp) / 2;

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] <= target) {
                    nlp = mid + 1;
                } else {
                    nrp = mid - 1;
                }
            }

            return -1;
        }
    }

}
