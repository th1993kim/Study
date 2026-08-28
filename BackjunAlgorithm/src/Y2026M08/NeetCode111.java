package Y2026M08;

public class NeetCode111 {

    private static class Solution {

        public String longestPalindrome(String s) {

            if (s.length() == 1) {
                return s;
            }

            int start = 0;
            int maxLength = 1;

            //홀수인경우 중앙값으로부터
            for (int i = 0; i < s.length(); i++) {
                //홀수 확장
                int len1 = expend(s, i ,i);

                //짝수 확장
                int len2 = expend(s, i, i+1);

                int maxLen = Math.max(len1, len2);

                if (maxLength < maxLen) {
                    start = i - (maxLen - 1) / 2;
                }
            }

            return s.substring(start, maxLength);
        }

        private int expend(String s, int lt, int rt) {
            while(lt >= 0 && rt < s.length() && s.charAt(lt) == s.charAt(rt)) {
                lt--;
                rt++;
            }

            return rt - lt - 1;
        }
    }
}
