package Y2026M07;

import java.util.*;

public class NeetCode1 {

    public List<List<String>> groupAnagrams(String[] strs) {

        // 반복문을 생성한다.
        // 목록, 해시를 생성한다. 본인을 제외한 것을 돌면서 아나그램인 경우 목록에 넣어준다.
        // 아나그램 판단을 다르게 해보자.
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            char[] words = word.toCharArray();
            Arrays.sort(words);
            String alignWord = new String(words);
            List<String> list = map.computeIfAbsent(alignWord, k -> new ArrayList<>());
            list.add(word);
        }

        return new ArrayList<>(map.values());
    }

}
