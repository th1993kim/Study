package Y2026M05;

import java.util.HashMap;
import java.util.Scanner;

public class P1140 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String b = scanner.nextLine();


        System.out.println(solution(a, b));
    }

    private static String solution(String a, String b) {

        HashMap<Character, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            wordMap.put(a.charAt(i), wordMap.getOrDefault(a.charAt(i), 0) + 1);
        }
        for (int i = 0; i < b.length(); i++) {
            Integer value = wordMap.getOrDefault(b.charAt(i), 0);
            if (value <= 0) {
                return "NO";
            }

            wordMap.put(b.charAt(i), value - 1);
        }

        return "YES";
    }

}
