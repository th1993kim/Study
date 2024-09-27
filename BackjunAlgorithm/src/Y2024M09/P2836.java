package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2836 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int dividedFive = n / 5;
        int totalRemain = n - 5 * dividedFive;
        int dividedThree = 0;
        int result = 0;

        // 5의 배수를 뺀 나머지값이 3의 배수인 경우 5의배수값 + 3의배수값을 반환한다.
        // 빠져나가지 못하면 -1을 저장한다.
        for (int i = dividedFive; i >= 0; i--) {
            if (totalRemain % 3 == 0) {
                dividedThree = totalRemain / 3;
                result = i + dividedThree;
                break;
            }
            if (i == 0) {
                result = -1;
            }
            totalRemain += 5;
        }


        System.out.println(result);
    }

    private static void gptSolution(int n) {
        int result = 0;

        while (n >= 0) {
            // 5로 나눈 나머지가 0인 경우  결과값을 출력하는데, 누적된 개수값으로 출력한다.
            if (n % 5 == 0) {
                result += n / 5;
                System.out.println(result);
                return;
            }
            // 3으로 나눈것과 동일한 계산식으로 3씩 빼가면서 카운팅을 1번씩 해준다.
            n -= 3;
            result ++;
        }

        //위에서 return문으로 빠져나온것이 아닌 경우 결과를 -1로 출력한다.
        System.out.println(-1);
    }
}
