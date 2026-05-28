package Y2026M05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P1217 {

    static int n, answer;
    static List<Time> timeList = new ArrayList<>();

    static class Time implements Comparable<Time>{
        int start, end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time time) {
            if (this.end == time.end) return time.start - this.start;
            else return time.end - this.end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            Time time = new Time(scanner.nextInt(), scanner.nextInt());
            timeList.add(time);
        }

        solution();

        System.out.println(answer);
    }

    private static void solution() {
        Collections.sort(timeList);

        Time max =
        for (Time time : timeList) {

        }
    }
}
