package Y2026M06;

import java.util.LinkedList;
import java.util.Queue;
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

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < charArray.length; i++) queue.offer(charArray[i]);
        for (int i = 0; i < lettcture.length(); i++) {
            char schedule = lettcture.charAt(i);
            if (queue.contains(schedule)) {
                if (!queue.poll().equals(schedule)) {
                    return "NO";
                }
            }
        }

        if (!queue.isEmpty()) return "NO";


        return "YES";
    }
}
