package Y2026M06;

import java.util.Scanner;

public class P1158 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.next();
        String lettcture = scanner.next();
        String answer = solution(sequence, lettcture);

        System.out.println(answer);
    }

    private static String solution(String sequence, String lettcture) {
        char[] charArray = sequence.toCharArray();

        int index = 0;
        for (int i = 0; i < lettcture.length(); i++) {
            if (charArray[index] == lettcture.charAt(i)) {
                index++;
                if (index == charArray.length) {
                    return "YES";
                }
            }
        }

        return "NO";
    }
}
