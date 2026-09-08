package Y2026M09;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode238 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            // dp[i] 는 i전까지 단어사전을 통해 만들 수 있는지에 대한 여부
            Set<String> set = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;

            for (int i = 1; i <= s.length(); i++) { //i전까지 이므로 s.length()까지 포함
                for (int j = 0; j < i; j++) { // j의 위치가 i와 같거나 클 수는 없음
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                    }
                }
            }

            return dp[s.length()];
        }
    }
}
