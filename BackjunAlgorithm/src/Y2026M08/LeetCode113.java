package Y2026M08;

public class LeetCode113 {
    static class Solution {
        public int reverse(int x) {
            // 현재 결과에 x를 10으로 나눈 나머지를 +해준다.
            // x를 10으로 나누고 0이상인 경우 현재 결과에 *10 해준다.
            // 이를 나눌수 있을때까지 하는데(10의자리수가 남을 수 있을때까지), Max Integer값과, Min Integer값을 10으로 나눈 후 결과와 비교한다.
            // 이때 Max보다 크거나 Min보다 작으면 0을 리턴하는데, 만약 동일한 경우에는 마지막 1의 자리수를 Max, Min의 10으로 나눈 후 마찬가지라 Max보다 크거나 Min보다 작으면 0을 리턴한다.
            int temp = x;
            int result = 0;
            while (temp != 0) {
                int digit = temp % 10;
                temp /= 10;

                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                    return 0;
                }

                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < Integer.MIN_VALUE % 10)) {
                    return 0;
                }

                result = result * 10 + digit;
            }

            return result;
        }
    }
}
