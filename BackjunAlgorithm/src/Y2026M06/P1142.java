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
        Map<Character, Integer> resultMap = new HashMap<>();
        Map<Character, Integer> wordMap = new HashMap<>();
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            wordMap.put(word.charAt(i), wordMap.getOrDefault(word.charAt(i), 0) + 1);
        }

        for (int i = 0; i < wordLength - 1; i++) {
            resultMap.put(fullText.charAt(i), resultMap.getOrDefault(fullText.charAt(i), 0) + 1);
        }

        for (int rt = wordLength - 1; rt < fullText.length(); rt++) {
            resultMap.put(fullText.charAt(rt), resultMap.getOrDefault(fullText.charAt(rt), 0) + 1);
            if (resultMap.equals(wordMap)) answer++;
            resultMap.put(fullText.charAt(lt), resultMap.get(fullText.charAt(lt)) - 1);
            if (resultMap.get(fullText.charAt(lt)) == 0) resultMap.remove(fullText.charAt(lt));
            lt++;
        }

        return answer;
    }
}
