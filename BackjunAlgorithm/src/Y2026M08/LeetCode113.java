package Y2026M08;

public class LeetCode113 {
    static class Solution {
        public int reverse(int x) {
            // 현재 결과에 x를 10으로 나눈 나머지를 +해준다.
            // x를 10으로 나누고 0이상인 경우 현재 결과에 *10 해준다.
            // 이를 나눌수 있을때까지 하는데(10의자리수가 남을 수 있을때까지), Max Integer값과, Min Integer값을 10으로 나눈 후 결과와 비교한다.
            // 이때 Max보다 크거나 Min보다 작으면 0을 리턴하는데, 만약 동일한 경우에는 마지막 1의 자리수를 Max, Min의 10으로 나눈 후 마찬가지라 Max보다 크거나 Min보다 작으면 0을 리턴한다.
            int temp = x;
            int direction = x < 0 ? -1 : 1;
            int result = 0;
            while (temp / 10 != 0) {
                result += temp % 10;
                temp /= 10;
                if (temp / 10 != 0) {
                    result *= 10;
                }
            }
            int smallMax = Integer.MAX_VALUE / 10;
            int smallMin = Integer.MIN_VALUE / 10;
            if (temp != 0) {
                if (result > smallMax) {
                    return 0;
                } else if (result == smallMax) {
                    int maxLittle = Integer.MAX_VALUE % 10;
                    if (maxLittle < temp) {
                        return 0;
                    }
                }

                if (result < smallMin) {
                    return 0;
                } else if (result == smallMin) {
                    int minLittle = Integer.MIN_VALUE % 10;
                    if (minLittle > temp) {
                        return 0;
                    }
                }
                result = result * 10 + temp;
            }

            return result;
        }
    }
}
