package Y2026M07;

import java.util.Arrays;

public class NeetCode31 {
    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }
            // s1, s2을 알파벳별로 문자배열에 담는다. s2의 경우 s1의 문자열 길이만큼 담는다.

            int[] target = new int[26];
            int[] origin = new int[26];

            for (int i = 0; i < s1.length(); i++) {
                target[s1.charAt(i) - 'a']++;
                origin[s2.charAt(i) - 'a']++;
            }
            // 초기 비교를 해준다.

            if (Arrays.equals(target, origin)) return true;


            // s2의 마지막 위치를 s1.length부터 시작해서 하나씩 이동하면서 배열을 비교해준다.
            // 일치하는 경우 true를 반환해주고 그렇지 않으면 false를 반환한다.
            for (int i = s1.length(); i < s2.length(); i++) {
                origin[s2.charAt(i) - 'a']++;
                origin[s2.charAt(i-s1.length()) - 'a']--;

                if (Arrays.equals(target, origin)) return true;
            }


            return false;
        }
    }

}
