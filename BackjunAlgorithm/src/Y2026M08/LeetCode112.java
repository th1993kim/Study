package Y2026M08;

public class LeetCode112 {
    private static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;

            StringBuilder[] sbArr = new StringBuilder[numRows];

            for (int i = 0; i < numRows; i++) {
                sbArr[i] = new StringBuilder();
            }

            int index = 0;
            int direction = 1;
            for (int i = 0; i < s.length(); i++) {
                sbArr[index].append(s.charAt(i));

                if (index == 0) {
                    direction = 1;
                } else if (index == numRows - 1){
                    direction = -1;
                }
                index += direction;
            }

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                answer.append(sbArr[i]);
            }

            return answer.toString();
        }
    }
}
