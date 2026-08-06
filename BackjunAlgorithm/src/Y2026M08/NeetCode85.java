package Y2026M08;

public class NeetCode85 {
    static class Solution {
        public String longestPalindrome(String s) {
            int start = 0;
            int maxLength = 1;

            for (int i = 0; i < s.length(); i++) {
                int oddLength = extend(i, i, s);
                int evenLength = extend(i, i+1, s);

                int length = Math.max(oddLength, evenLength);

                if (maxLength < length) {
                    maxLength = length;
                    start = i - (maxLength - 1) / 2;
                }
            }

            return s.substring(start, start + maxLength);
        }


        private int extend(int left, int right, String s) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left --;
                right++;
            }

            return right - left - 1;
        }
    }

}
