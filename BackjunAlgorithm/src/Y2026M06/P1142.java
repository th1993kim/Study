package Y2026M06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1142 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fullText = scanner.next();
        String word = scanner.next();

        int answer = solution(fullText, word);

        System.out.println(answer);
    }

    private static int solution(String fullText, String word) {

        int answer = 0;
        int lt = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int rt = word.length() - 1; rt < fullText.length(); rt++) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                wordMap.put(word.charAt(i), wordMap.getOrDefault(word.charAt(i), 0) + 1);
            }

            while(rt - lt + 1 > word.length()) {
                lt++;
            }

            for (int i = lt; i <= rt; i++) {
                Integer wordCount = wordMap.get(fullText.charAt(i));
                if (wordCount == null || wordCount <= 1) {
                    wordMap.remove(fullText.charAt(i));
                } else {
                    wordMap.put(fullText.charAt(i), wordCount - 1);
                }
            }
            wordMap.equals()

            if (wordMap.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}
