package Y2026M07;

import java.util.ArrayList;
import java.util.List;

public class NeetCode59 {
    static class Solution {
        List<String> answer;
        public List<String> generateParenthesis(int n) {
            answer = new ArrayList<>();
            dfs(0, 0, new StringBuilder(), n);
            return answer;
        }

        private void dfs(int left, int right, StringBuilder sb, int total) {
            if (right == total) {
                answer.add(sb.toString());
                return;
            }

            if (left < total) {
                sb.append("(");
                dfs(left + 1, right, sb, total);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (left > right) {
                sb.append(")");
                dfs(left, right + 1, sb, total);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}
