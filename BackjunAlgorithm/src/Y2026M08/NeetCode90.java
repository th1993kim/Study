package Y2026M08;

import java.util.List;

public class NeetCode90 {

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;


            for (int i = 0; i < s.length(); i++) {
                if(!dp[i]) continue;

                for (String word : wordDict) {
                    if(s.startsWith(word, i)) {
                        dp[i + word.length()] = true;
                    }
                }
            }

            return dp[dp.length - 1];
        }
    }

}
