package Y2026M06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1159 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }


        int answer = solution(n, k, scores);

        System.out.println(answer);
    }

    private static int solution(int n, int k, int[] scores) {

        Queue<Person> queue = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            queue.offer(new Person(i, scores[i]));
        }

        while (!queue.isEmpty()) {
            Person person = queue.poll();
            boolean isWinner = true;
            for (Person other : queue) {
                if (person.score < other.score) {
                    isWinner = false;
                    break;
                }
            }

            if (!isWinner) {
                queue.offer(person);
            } else {
                answer++;
                if (person.index == k) {
                    break;
                }
            }
        }

        return answer;
    }

    static class Person {
        int index;
        int score;

        public Person(int index, int score) {
            this.index = index;
            this.score = score;
        }
    }
}
