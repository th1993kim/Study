package Y2026M07;

import java.util.*;

public class P1220 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Lecture> lectureList = new ArrayList<>();
        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            int money = scanner.nextInt();
            int day = scanner.nextInt();
            maxDay = Math.max(maxDay, day);
            lectureList.add(new Lecture(money, day));
        }

        int answer = solution(maxDay, lectureList);

        System.out.println(answer);
    }

    private static int solution(int maxDay, List<Lecture> lectureList) {

        lectureList.sort(Lecture::compareTo);
        PriorityQueue<Lecture> pq = new PriorityQueue<>(Comparator.comparingInt((Lecture lecture) -> lecture.money).reversed());
        int answer = 0;
        int index = 0;
        for (int i = maxDay; i >= 1; i--) {
            while (index < lectureList.size() && lectureList.get(index).day == i) {
                pq.offer(lectureList.get(index));
                index++;
            }
            if (!pq.isEmpty()) {
                answer += pq.poll().money;
            }
        }

        return answer;
    }

    static class Lecture implements Comparable<Lecture> {
        int money;
        int day;

        public Lecture(int money, int day) {
            this.money = money;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.day - this.day == 0 ? o.money - this.money : o.day - this.day;
        }
    }
}
