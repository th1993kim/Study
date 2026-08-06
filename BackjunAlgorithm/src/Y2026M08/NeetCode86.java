package Y2026M08;

public class NeetCode86 {
    static class Solution {
        public int countSubstrings(String s) {

            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += count(i, i, s);
                sum += count(i, i+1, s);
            }

            return sum;
        }

        private int count(int left, int right, String s) {
            int count = 0;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }

            return count;
        }
    }

}
