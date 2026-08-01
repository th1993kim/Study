package Y2026M07;

import java.util.*;

public class NeetCode72 {

    static class Solution {
        public List<Integer> partitionLabels(String s) {

            Map<Character, Integer> chMap = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                chMap.put(s.charAt(i), chMap.getOrDefault(s.charAt(i), 0) + 1);
            }

            Set<Character> set = new HashSet<>();

            List<Integer> answer = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char word = s.charAt(i);
                set.add(word);
                int remainCount = chMap.get(word) - 1;
                chMap.put(word, remainCount);
                count++;
                if (remainCount == 0) set.remove(word);

                if (set.isEmpty()) {
                    answer.add(count);
                    count = 0;
                }
            }

            return answer;

        }
    }

}
