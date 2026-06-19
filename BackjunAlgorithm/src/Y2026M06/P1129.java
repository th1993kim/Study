package Y2026M06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P1129 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int far = scanner.nextInt();
        int[] firstArr = new int[far];
        for (int i = 0; i < far; i++) {
            firstArr[i] = scanner.nextInt();
        }

        int sar = scanner.nextInt();
        int[] secondArr = new int[sar];
        for (int j = 0; j < sar; j++) {
            secondArr[j] = scanner.nextInt();
        }

        List<Integer> answer = solution(firstArr, secondArr);

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < answer.size(); k++) {
            if (k > 0) {
                sb.append(' ');
            }
            sb.append(answer.get(k));
        }
        System.out.println(sb);
    }

    private static List<Integer> solution(int[] firstArr, int[] secondArr) {
        Arrays.sort(firstArr);
        Arrays.sort(secondArr);
        List<Integer> answer = new ArrayList<>();
        int lt = 0;
        int rt = 0;
        while(lt < firstArr.length && rt < secondArr.length) {
            if (firstArr[lt] == secondArr[rt]) {
                answer.add(firstArr[lt]);
                lt++;
                rt++;
            } else if (firstArr[lt] < secondArr[rt]) {
                lt++;
            } else {
                rt++;
            }
        }

        return answer;
    }
}
