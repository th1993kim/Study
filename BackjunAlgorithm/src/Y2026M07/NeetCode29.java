package Y2026M07;

import java.util.HashSet;
import java.util.Set;

public class NeetCode29 {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int answer = 0;
            // 포인트 2개를 잡는다.
            int lp = 0;
            int rp = 0;
            int count = 0;
            Set<Character> charSet = new HashSet<>();
            // 중복되는 글자가 없을때까지 오른쪽으로 확장한다. 이때 Max 문자수를 갱신한다.
            // 만약 중복되는 글자가 나올경우 해당 글자가 안나올때까지 왼쪽으로 포인트를 이동한다.
            while (rp < s.length()) {
                while (charSet.contains(s.charAt(rp))) {
                    charSet.remove(s.charAt(lp));
                    count--;
                    lp++;
                }

                charSet.add(s.charAt(rp));
                count++;
                rp++;
                answer = Math.max(answer, count);
            }

            return answer;
        }
    }

}
