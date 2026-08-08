package Y2026M08;

public class NeetCode94 {
    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
            //dp의 상태를 text1에서 i개 선택했을때, text2에서 j개 선택했을때 문자열이 같을때를 비교해준다.

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (text1.charAt(i-1) == text2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                        // 마지막 문자열이 같게되면 +1을 해준다.
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                        // 마지막 문자가 다르면 둘을 동시에 사용할 수 없다.
                        // 따라서 text1의 마지막 문자를 버린 경우와
                        // text2의 마지막 문자를 버린 경우 중
                        // 더 긴 공통 부분수열을 선택한다.
                    }
                    System.out.printf("i=%d, j=%d, dp=%d%n", i, j, dp[i][j]);
                }
            }

            return dp[text1.length()][text2.length()];


        }
    }

}
