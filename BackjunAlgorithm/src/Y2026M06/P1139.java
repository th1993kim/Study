package Y2026M06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1139 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String student = scanner.next();

        Character answer = solution(student);

        System.out.println(answer);
    }

    private static Character solution(String student) {
        Map<Character, Integer> studentMap = new HashMap<>();

        Character answer = null;
        int max = 0;
        for (int i = 0; i < student.length(); i++) {
            char key = student.charAt(i);
            studentMap.put(key, studentMap.getOrDefault(key, 0) + 1);

            if (max < studentMap.get(key)) {
                max = studentMap.get(key);
                answer = key;
            }
        }

        return answer;
    }
}
