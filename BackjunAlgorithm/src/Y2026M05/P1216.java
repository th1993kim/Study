package Y2026M05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P1216 {

    static int answer, n;
    static List<TimeRange> timeRangeList = new ArrayList<>();
    static class TimeRange implements Comparable<TimeRange>{
        int start, end;
        TimeRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(TimeRange timeRange) {
            if (this.end == timeRange.end) return this.start - timeRange.start;
            else return this.end - timeRange.end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            timeRangeList.add(new TimeRange(scanner.nextInt(), scanner.nextInt()));
        }

        solution();
        System.out.println(answer);
    }

    private static void solution() {
        Collections.sort(timeRangeList);
        int endTime = 0;
        for (TimeRange timeRange : timeRangeList) {
            if (timeRange.start >= endTime) {
                answer ++;
                endTime = timeRange.end;
            }
        }
    }

}
