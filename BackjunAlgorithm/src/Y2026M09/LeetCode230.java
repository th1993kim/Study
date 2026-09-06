package Y2026M09;

import java.util.*;

public class LeetCode230 {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // Map<문자빈도, 문자열목록> 으로 한다면 쉽게 풀 수 있다.

            Map<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                char[] word = str.toCharArray();
                Arrays.sort(word);
                String sortStr = new String(word);

                map.computeIfAbsent(sortStr, k -> new ArrayList<>())
                        .add(str);
            }

            return new ArrayList<>(map.values());

        }
    }
}
