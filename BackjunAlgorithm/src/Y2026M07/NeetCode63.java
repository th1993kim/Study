package Y2026M07;

import java.util.Arrays;
import java.util.Comparator;

public class NeetCode63 {

    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int answer = 0;

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
            int index = 0;
            int currentEnd = intervals[index][1];
            index++;
            while (index < intervals.length) {
                int nextStart = intervals[index][0];
                int nextEnd = intervals[index][1];

                if (nextStart < currentEnd) {
                    answer++;
                } else {
                    currentEnd = nextEnd;
                }
                index++;
            }

            return answer;
        }
    }

}
