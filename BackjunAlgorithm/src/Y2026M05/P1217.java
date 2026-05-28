package Y2026M05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P1217 {

    static int n, answer;
    static List<Time> timeList = new ArrayList<>();

    static class Time implements Comparable<Time>{
        int time;
        String state;

        public Time(int time, String state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time time) {
            if (this.time == time.time) {
                if (this.state.equals(time.state)) return 0;
                if (this.state.equals("OUT")) return -1;
                else return 1;
            }
            return this.time - time.time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            Time inTime = new Time(scanner.nextInt(), "IN");
            timeList.add(inTime);
            Time outTime = new Time(scanner.nextInt(), "OUT");
            timeList.add(outTime);
        }

        solution();

        System.out.println(answer);
    }

    private static void solution() {
        Collections.sort(timeList);

        int cnt = 0;
        for (Time time : timeList) {
            if ("IN".equals(time.state)) {
                cnt++;
                answer = Math.max(answer, cnt);
            } else {
                cnt--;
            }
        }
    }
}
