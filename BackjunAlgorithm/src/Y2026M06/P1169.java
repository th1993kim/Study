package Y2026M06;

import java.util.Arrays;
import java.util.Scanner;

public class P1169 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int member = scanner.nextInt();

        int[] favoriteNumbers = new int[member];

        for (int i = 0; i < member; i++) {
            favoriteNumbers[i] = scanner.nextInt();
        }

        System.out.println(solution(favoriteNumbers));


    }

    private static String solution(int[] favoriteNumbers) {
        Arrays.sort(favoriteNumbers);
        for (int i = 0; i < favoriteNumbers.length - 1; i++) {
            if (favoriteNumbers[i] == favoriteNumbers[i + 1]) return "D";
        }
        return "U";
    }
}
