package Y2026M07;

import java.util.*;

public class NeetCode72 {

    static class Solution {
        public List<Integer> partitionLabels(String s) {
            int[] charEndArr = new int[26];

            for (int i = 0; i < s.length(); i++) {
                charEndArr[s.charAt(i) - 'a'] = i;
            }

            List<Integer> answer = new ArrayList<>();

            int start = 0;
            int end = 0;

            for (int i = 0; i < s.length(); i++) {
                end = Math.max(end, charEndArr[s.charAt(i) - 'a']);

                if (end == i) {
                    answer.add(end - start + 1);
                    start = i + 1;
                }
            }
            return answer;
        }
    }

}
