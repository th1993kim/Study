package Y2026M07;

public class NeetCode9 {
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

            int n = matrix[0].length;
            int maxIndex = n - 1;
            int lt = 0, rt = matrix.length - 1;
            int firstIndex = 0;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                int first = matrix[mid][0];
                int last = matrix[mid][maxIndex];
                if (first <= target && target <= last) {
                    firstIndex = mid;
                    break;
                } else if (target < first) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            }
            lt = 0;
            rt = matrix[0].length - 1;
            while (lt <= rt) {
                int mid = (rt + lt) / 2;
                if (matrix[firstIndex][mid] == target) {
                    return true;
                } else if (matrix[firstIndex][mid] < target) {
                    lt = mid + 1;
                } else {
                    rt = mid -1;
                }
            }

            return false;
        }
    }

}
