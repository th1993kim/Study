package Y2026M07;

import java.util.Comparator;
import java.util.List;

public class NeetCode64 {

    public class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    static class Solution {
        public boolean canAttendMeetings(List<Interval> intervals) {
            if (intervals.size() == 0) return true;
            intervals.sort(Comparator.comparingInt(interval -> interval.start));

            int currentEnd = intervals.get(0).end;
            int index = 1;
            while (index < intervals.size()) {
                int nextStart = intervals.get(index).start;
                if (nextStart < currentEnd) return false;

                currentEnd = intervals.get(index).end;
                index++;
            }

            return true;
        }
    }

}
