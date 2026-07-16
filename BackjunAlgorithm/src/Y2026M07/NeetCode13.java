package Y2026M07;

public class NeetCode13 {

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {

            int lt = 0;
            int rt = numbers.length - 1;

            while(lt < rt) {
                int sum = numbers[lt] + numbers[rt];
                if (sum == target) {
                    return new int[]{lt + 1, rt + 1};
                } else if (sum > target) {
                    rt--;
                } else {
                    lt++;
                }

            }

            return new int[2];
        }
    }

}
