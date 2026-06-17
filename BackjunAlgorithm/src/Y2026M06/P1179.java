package Y2026M06;

import java.util.Arrays;
import java.util.Scanner;

public class P1179 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int horseSize = scanner.nextInt();
        int minSize = scanner.nextInt();

        int[] horses = new int[horseSize];

        for (int i = 0; i < horseSize; i++) {
            horses[i] = scanner.nextInt();
        }

        System.out.println(solution(horses, minSize));
    }

    private static int solution(int[] horses, int minSize) {
        int answer = 0;
        Arrays.sort(horses);
        int lt = 1;
        int rt = horses[horses.length - 1];

        while(lt <= rt) {
            int cap = (lt + rt) / 2;

            int position = horses[0];
            int count = 1;
            for (int horse : horses) {
                if (position + cap <= horse) {
                    position = horse;
                    count++;
                }
            }

            if (count >= minSize) {
                answer = cap;
                lt = cap + 1;
            } else {
                rt = cap - 1;
            }
        }
        return answer;
    }
}
