package Y2026M08;

public class NeetCode111 {

    private static class Solution {

        private String answer;
        public String longestPalindrome(String s) {
            if (s.length() == 1) {
                return s;
            }
            answer = s.substring(0, 1);
            //홀수인경우 중앙값으로부터
            for (int i = 0; i < s.length(); i++) {
                //홀수 확장
                expend(s, i ,i);

                //짝수 확장
                expend(s, i, i+1);

            }

            return answer;
        }

        private void expend(String s, int lt, int rt) {
            while(lt >= 0 && rt < s.length() && s.charAt(lt) == s.charAt(rt)) {
                String result = s.substring(lt, rt + 1);
                if (answer.length() < result.length()) {
                    answer = result;
                }

                lt--;
                rt++;
            }
        }
    }
}
