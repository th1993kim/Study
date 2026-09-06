package Y2026M09;

public class LeetCode225 {
    static class Solution {
        public String multiply(String num1, String num2) {
            int n = num1.length();
            int m = num2.length();

            int[] answer = new int[n+m];
            for (int i = n - 1; i >= 0; i--) {
                int i1 = num1.charAt(i) - '0';
                for (int j = m - 1; j >= 0; j--) {
                    int j1 = num2.charAt(j) - '0';
                    int p1 = i + j;
                    int p2 = i + j + 1;
                    int total = i1 * j1 + answer[p2];

                    answer[p2] = total % 10;
                    answer[p1] += total / 10;
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < answer.length; i++) {
                if (sb.isEmpty() && answer[i] == 0) continue;

                sb.append(answer[i]);
            }

            return sb.isEmpty() ? "0" : sb.toString();
        }
    }
}
