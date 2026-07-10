package Y2026M07;

import java.time.LocalTime;


public class WorkTime {

    public static void main(String[] args) {

        WorkTime workTime = new WorkTime();
        int answer = workTime.solution(
                new int[]{700, 800, 1100},
                new int[][]{{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}},
        5
        );
        System.out.println(answer);
    }

    public int solution(int[] schedules, int[][] timelogs, int startday) {


        int answer = 0;
        final int addTime = 10;
        for (int i = 0; i < timelogs.length; i++) {
            LocalTime wantedTime = getLocalTime(schedules[i]);
            boolean flag = true;
            int day = startday;
            for (int j = 0; j < timelogs[0].length; j++) {
                if (day == 6 || day == 7) {
                    day = addDay(day);
                    continue;
                }
                LocalTime arriveTime = getLocalTime(timelogs[i][j]).minusMinutes(addTime);
                if (arriveTime.isAfter(wantedTime)) {
                    flag = false;
                    break;
                }
                day = addDay(day);
            }
            if (flag) answer++;
        }

        return answer;
    }

    private int addDay(int startday) {
        if (startday == 7) {
            return 1;
        }
        return startday + 1;
    }

    private LocalTime getLocalTime(int time) {
        String timeString = String.valueOf(time);
        if (timeString.length() > 3) {
            return LocalTime.of(Integer.parseInt(timeString.substring(0, 2)), Integer.parseInt(timeString.substring(2, 4)));
        }

        return LocalTime.of(Integer.parseInt(timeString.substring(0, 1)), Integer.parseInt(timeString.substring(1, 3)));
    }


}
