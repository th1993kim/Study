package Y2026M08;

public class NeetCode108 {
    static class Solution {

        Boolean[][] memo;

        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) return false;
            memo = new Boolean[s1.length() + 1][s2.length() + 1];
            return dfs(s1, s2, s3, 0, 0);
        }

        private boolean dfs(String s1, String s2, String s3, int i1, int i2) {
            int i3 = i1 + i2;
            if (s3.length() == i3) return true;

            if (memo[i1][i2] != null) return memo[i1][i2];

            boolean result = false;
            if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
                result = dfs(s1, s2 ,s3, i1 + 1, i2);
            }

            if (!result && i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
                result = dfs(s1, s2, s3, i1, i2+1);
            }

            memo[i1][i2] = result;

            return result;
        }
    }

}
