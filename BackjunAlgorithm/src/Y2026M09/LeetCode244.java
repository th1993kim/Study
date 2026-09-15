package Y2026M09;

public class LeetCode244 {
    class Solution {
        public String addBinary(String a, String b) {
            // 맨뒤의 글자부터 시작해서 뒤의 글자가 둘다 1, 1 이면 다음에 넘겨줄 값 1을 남겨주고, 0으로
            // 둘중 하나가 1,0 이면 1로
            // 둘다 0이면 0으로
            // 다음자리수부터는 spare가 존재하는 경우 더해주고 2보다 크면 위와 같이 진행
            // 자리수가 모두 남을때까지 진행해주고 그이후로는 한쪽으로 쌓아주는 작업 진행
            int ap = a.length() - 1;
            int bp = b.length() - 1;
            int spare = 0;
            StringBuilder sb = new StringBuilder();
            while (ap >= 0 && bp >= 0) {
                int av = a.charAt(ap) - '0';
                int bv = b.charAt(bp) - '0';
                System.out.println("ap : " + ap + ", av : " + av + " , bv: " + bv);
                int sum = av + bv + spare;
                if (sum >= 2) {
                    sum -= 2;
                    spare = 1;
                } else {
                    spare = 0;
                }
                sb.append(String.valueOf(sum));
                ap--;
                bp--;
            }

            while (ap >= 0) {
                int av = a.charAt(ap) - '0';
                int sum = av + spare;
                if (sum >= 2) {
                    sum -= 2;
                    spare = 1;
                } else {
                    spare = 0;
                }
                sb.append(String.valueOf(sum));
                ap--;
            }


            while (bp >= 0) {
                int bv = b.charAt(bp) - '0';
                int sum = bv + spare;
                if (sum >= 2) {
                    sum -= 2;
                    spare = 1;
                } else {
                    spare = 0;
                }
                sb.append(String.valueOf(sum));
                bp--;
            }

            if (spare >= 1) {
                sb.append("1");
            }

            return sb.reverse().toString();
        }
    }
}
