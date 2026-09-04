package Y2026M09;

public class LeetCode221 {
    class Solution {
        public int countPrimes(int n) {
            // 배열을 만들고 그배열의 값안에서 배수값이 존재하는 경우 1로 만들어준다.
            // 배열안에서 0인 것들의 합을 구한다.

            boolean[] primes = new boolean[n];

            for (int i = 2; i < Math.sqrt(n); i++) {
                if (primes[i]) continue;
                for (int j = i * i; j < n; j += i) {
                    primes[j] = true;
                }
            }

            int answer = 0;
            for (int i = 2; i < n; i++) {
                if (!primes[i]) answer++;
            }

            return answer;
        }
    }
}
