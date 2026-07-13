package Y2026M07;

public class LeetCode1 {

    public static void main(String[] args) {

        LeetCode1 leetCode1 = new LeetCode1();
        int[] inputs = {2, 7, 11, 15};
        int target = 9;
        int[] answers = leetCode1.twoSum(inputs, target);

        for (int answer : answers) {

            System.out.print(answer + " ");

        }
    }

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[2];
    }
}
