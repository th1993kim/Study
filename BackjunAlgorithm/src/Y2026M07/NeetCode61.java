package Y2026M07;

import java.util.ArrayList;
import java.util.List;

public class NeetCode61 {
    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> answer = new ArrayList<>();

            int index = 0;
            while(index < intervals.length && intervals[index][1] < newInterval[0]) {
                answer.add(new int[]{intervals[index][0], intervals[index][1]});
                index++;
            }

            while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
                newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
                index++;
            }
            answer.add(new int[]{newInterval[0], newInterval[1]});

            while (index < intervals.length) {
                answer.add(new int[]{intervals[index][0], intervals[index][1]});
                index++;
            }

            return answer.toArray(new int[answer.size()][]);
        }
    }

}
