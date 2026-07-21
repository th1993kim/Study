package Y2026M07;

public class NeetCode30 {
    static class Solution {
        public int characterReplacement(String s, int k) {

            // 포인트 2개를 잡는다.
            int lp = 0;
            int rp = 0;
            // 문자별로 빈도수를 센다.
            int[] frequency = new int[26];
            // rp를 증가하면서 문자별 빈도수를 누적시킨다.
            int answer = 0;
            int maxFrequency = 0;
            // 최대 빈도수를 갱신한다. 여기서 최대 빈도수를 초기화하지 않는 이유는, '상한선' 이라는 이유로 생각해보아야한다.
            // 윈도우의 길이 - 최대 빈도수 가 K를 넘어서기 시작하면 윈도우가 커진것으로 lp를 증가시킨다.
            // 해당 문자열의 빈도를 줄인다.
            // 결과에 윈도우의 길이 최대값을 갱신한다.
            while (rp < s.length()) {
                int index = (int) (s.charAt(rp) - 'A');
                frequency[index]++;
                maxFrequency = Math.max(maxFrequency, frequency[index]);

                while ((rp - lp + 1) - maxFrequency > k) {
                    frequency[s.charAt(lp) - 'A']--;
                    lp++;
                }

                answer = Math.max(answer, rp - lp + 1);
                rp++;
            }

            return answer;
        }
    }

}
