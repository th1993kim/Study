package Y2026M07;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> wordSet = new HashSet<>();

        int answer = 0;
        int lt = 0;
        for (int rt = 0; rt < s.length(); rt++) {
            char word = s.charAt(rt);
            while (wordSet.contains(word)) {
                wordSet.remove(s.charAt(lt));
                lt++;
            }
            wordSet.add(word);

            answer = Math.max(answer, wordSet.size());
        }

        return answer;
    }
}
