package Y2026M09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode230 {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // Map<문자빈도, 문자열목록> 으로 한다면 쉽게 풀 수 있다.

            List<List<String>> answer = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();

            for (String str : strs) {
                int[] count = new int[26];
                for (char word : str.toCharArray()) {
                    count[word - 'a']++;
                }

                StringBuilder keyBuilder = new StringBuilder();
                for (int i = 0; i < count.length; i++) {
                    keyBuilder.append('a' + i)
                            .append(count[i]);
                }
                String key = keyBuilder.toString();
                map.computeIfAbsent(key, k -> new ArrayList<>())
                        .add(str);
            }


            return new ArrayList<>(map.values());

        }
    }
}
