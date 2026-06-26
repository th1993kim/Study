package Y2026M06;

import java.util.Scanner;

public class P1178re {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] records = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            records[i] = scanner.nextInt();
            max += records[i];
        }

        int answer = solution(n, m, max, records);

        System.out.println(answer);
    }

    private static int solution(int n, int m, int max, int[] records) {

        int answer = Integer.MAX_VALUE;
        int lt = records[0];
        int rt = max;
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            int count = 1;
            int sum = 0;
            int maxValue = 0;
            for (int j = 0; j < n; j++) {
                if (sum + records[j] > mid) {
                    count++;
                    sum = records[j];
                } else {
                    sum += records[j];
                    maxValue = Math.max(maxValue, sum);
                }
            }
            if (count > m) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
                answer = Math.min(answer, maxValue);
            }
        }

        return answer;
    }
}
