package Y2026M08;

import java.util.ArrayList;
import java.util.List;

public class LeetCode116 {

    static class Solution {

        private List<String> answer;
        public List<String> generateParenthesis(int n) {
            answer = new ArrayList<>();


            // dfs의 정의 1: level (N까지 허용), 2: open (, 3: close ) 4 : n
            dfs(0, new StringBuilder(), 0, 0, n);

            return answer;
        }

        // 1. close 할때마다 레벨이 상승한다.
        // 2. open <= n 인경우 까지만 open이 가능하다.
        // 3. close > open 은 불가하다.
        // 4. level이 n에 도달하면 종료한다.
        private void dfs(int level, StringBuilder result, int open, int close, int n) {
            if (open > n) return;
            if (close > open) return;
            if (level == n) {
                answer.add(result.toString());
                return;
            }
            result.append("(");
            dfs(level, result, open + 1, close, n);
            result.deleteCharAt(result.length() - 1);
            result.append(")");
            dfs(level + 1, result, open, close + 1, n);
            result.deleteCharAt(result.length() - 1);
        }
    }
}
