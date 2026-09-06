package Y2026M09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode231 {
    static class Solution {
        public int[][] merge(int[][] intervals) {

            // 시작 기준 정렬
            // 1 5 2 4
            Arrays.sort(intervals, (a, b) -> {
                return a[0] - b[0];
            });

            int start = intervals[0][0];
            int end = intervals[0][1];
            List<int[]> answer = new ArrayList<>();
            for (int i = 1; i < intervals.length; i++) {
                int ne = intervals[i][1];
                int ns = intervals[i][0];
                if (end < ns) {
                    answer.add(new int[]{start, end});
                    start = ns;
                    end = ne; // 새구간인 경우 MAX값이 아니라, 다음 구간으로 넘어갈 수 있도록 해주어야한다.
                } else {
                    end = Math.max(end, ne); // 연장되는 경우 다음 end와 기존 end를 비교해서 저장한다.
                }
            }

            answer.add(new int[]{start, end});

            return answer.toArray(new int[0][]);
        }
    }
}
