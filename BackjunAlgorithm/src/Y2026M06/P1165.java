package Y2026M06;

import java.util.Scanner;

public class P1165 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputNumbers = new int[n];

        for (int i = 0; i < n; i++) {
            inputNumbers[i] = scanner.nextInt();
        }

        int[] answer = solution(inputNumbers);

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static int[] solution(int[] inputNumbers) {

        for (int i = 0; i < inputNumbers.length; i++) {
            int index = i;
            for (int j = i + 1; j < inputNumbers.length; j++) {
                if (inputNumbers[j] < inputNumbers[index]) {
                    index = j;
                }
            }
            int temp = inputNumbers[i];
            inputNumbers[i] = inputNumbers[index];
            inputNumbers[index] = temp;
        }

        return inputNumbers;
    }
}
