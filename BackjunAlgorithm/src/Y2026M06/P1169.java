package Y2026M06;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P1169 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int member = scanner.nextInt();

        Integer[] favoriteNumbers = new Integer[member];

        for (int i = 0; i < member; i++) {
            favoriteNumbers[i] = scanner.nextInt();
        }

        System.out.println(solution(favoriteNumbers));


    }

    private static String solution(Integer[] favoriteNumbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : favoriteNumbers) {
            if (numberSet.contains(number)) return "D";
            numberSet.add(number);
        }
        return "U";
    }
}
