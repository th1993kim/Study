package Y2026M06;

import java.util.Scanner;

public class P1128 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstArrNum = scanner.nextInt();
        int[] firstArr = new int[firstArrNum];
        for (int i = 0; i < firstArrNum; i++) {
            firstArr[i] = scanner.nextInt();
        }
        int secondArrNum = scanner.nextInt();
        int[] secondArr = new int[secondArrNum];
        for (int j = 0; j < secondArrNum; j++) {
            secondArr[j] = scanner.nextInt();
        }

        int[] answer = solution(firstArr, secondArr);

        for (int k = 0; k < answer.length; k++) {
            System.out.print(answer[k] + " ");
        }
    }

    private static int[] solution(int[] firstArr, int[] secondArr) {

        int maxLength = firstArr.length + secondArr.length;
        int[] sumArr = new int[maxLength];

        int lt =0;
        int rt = 0;
        int index = 0;
        while(lt < firstArr.length && rt < secondArr.length) {
            if (firstArr[lt] <= secondArr[rt]) {
                sumArr[index++] = firstArr[lt++];
            } else {
                sumArr[index++] = secondArr[rt++];
            }
        }

        while(lt < firstArr.length) {
            sumArr[index++] = firstArr[lt++];
        }

        while(rt < secondArr.length) {
            sumArr[index++] = secondArr[rt++];
        }

        return sumArr;
    }
}
