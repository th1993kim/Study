package Y2026M07;

import java.util.ArrayList;
import java.util.List;

public class NeetCode65 {

    public class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    static class Solution {
        public int minMeetingRooms(List<Interval> intervals) {
            List<int[]> events = new ArrayList<>();
            for (Interval interval : intervals) {
                events.add(new int[]{interval.start, 1});
                events.add(new int[]{interval.end, -1});
            }

            events.sort((a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);

                return Integer.compare(a[1], b[1]);
            });

            int currentRoom = 0;
            int answer = 0;
            for (int[] event : events) {
                currentRoom += event[1];
                answer = Math.max(answer, currentRoom);
            }

            return answer;
        }
    }

}
