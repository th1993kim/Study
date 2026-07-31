package Y2026M07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NeetCode62 {

    static class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) return new int[0][];
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            List<int[]> result = new ArrayList<>();

            int currentStart = intervals[0][0];
            int currentEnd = intervals[0][1];
            int index = 1;
            while (index < intervals.length) {
                if (intervals[index][0] <= currentEnd) {
                    currentEnd = Math.max(intervals[index][1], currentEnd);
                } else {
                    result.add(new int[]{currentStart, currentEnd});
                    currentStart = intervals[index][0];
                    currentEnd = intervals[index][1];
                }
                index++;
            }
            result.add(new int[]{currentStart, currentEnd});

            return result.toArray(new int[result.size()][]);
        }
    }

}
