package Y2026M09;

public class LeetCod211 {
    static class Solution {
        public int numTrees(int n) {

            return count(n);
        }

        private int count(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }

            int result = 0;
            //노드가 1부터 N까지 존재하므로 모든 노드들을 도는 반복문을 시행한다.
            for (int i = 1; i <= n; i++) {
                // i를 선택한 기준으로 좌측은 i-1개의 노드가 존재한다.
                int left = i - 1;
                // i를 선택한 기준으로 우측은 n-i개만큼 존재한다.
                int right = n - i;
                int leftCount = count(left);
                int rightCount = count(right);

                result += leftCount * rightCount;
            }

            return result;
        }
    }
}
