package Y2026M08;

public class LeetCode114 {
    static class Solution {
        public int myAtoi(String s) {
            // 부호, 숫자를 읽는 경우를 체크할 마크 변수 추가
            boolean readFirst = false;
            int result = 0;
            int direction = 1;

            for (char word : s.toCharArray()) {
                if (word == ' ') {
                    if (readFirst) {
                        break;
                    }
                    continue;
                }

                if (word == '-')  {
                    if (readFirst) {
                        break;
                    }
                    direction = -1;
                    readFirst = true;
                    continue;
                }

                if (word == '+') {
                    if (readFirst) {
                        break;
                    }
                    readFirst = true;
                    continue;
                }

                if (Character.isDigit(word)) {
                    int digit = word - '0';

                    if (direction == 1 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10  && digit >= Integer.MAX_VALUE % 10))) {
                        return Integer.MAX_VALUE;
                    }

                    if (direction == - 1 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10  && digit >= (Integer.MAX_VALUE % 10 + 1)))) {
                        return Integer.MIN_VALUE;
                    }

                    result = result * 10 + digit;

                    readFirst = true;
                    continue;
                }

                break;
            }

            return result * direction;
        }
    }
}
