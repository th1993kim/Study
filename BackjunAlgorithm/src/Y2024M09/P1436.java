package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int number = 665; //665 부터 시작
        String findStr = "666";

        //1씩 증가 시키면서 666 문자열이 일치하는 횟수가 입력값과 동일하게 도착하면 중단하고 해당 숫자를 출력
        while (count < n) {
            number++;
            if (String.valueOf(number).contains(findStr)) {
                count ++;
            }
        }

        System.out.println(number);
    }

    private static void otherSolution(int n) {
        int foundCount = 0;
        int number = 0;

        for (int i=666; i < Integer.MAX_VALUE; i++) {
            if (foundCount == n) {
                break;
            }
            int temp = i;
            int sixContinueCount = 0;
            // 1. temp의 나머지가 6인 경우 6의 연속 개수 카운팅을 1씩 증가시킨다.
            // 2. 아닌 경우 0으로 초기화한다.
            // 3. 만약 6의 연속 개수가 3개면 숫자를 저장하고, 666 발견 횟수를 1씩 증가시킨다.
            // 4. temp를 계속 10으로 나눈다. (0에 도달할때까지)
            while (temp > 0) {
                if (temp % 10 == 6) {
                    sixContinueCount ++;
                } else {
                    sixContinueCount = 0;
                }
                if (sixContinueCount == 3) {
                    number = i;
                    foundCount ++;
                    break;
                }
                temp /= 10;
            }
        }

        System.out.println(number);
    }
}
