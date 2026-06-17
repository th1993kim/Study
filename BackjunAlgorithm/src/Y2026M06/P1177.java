package Y2026M06;

import java.util.Arrays;
import java.util.Scanner;

public class P1177 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println(solution(n, target, numbers));
    }

    private static int solution(int n, int target, int[] numbers) {
        Arrays.sort(numbers);
        int lt = 0;
        int rt = n - 1;
        while(lt != rt) {
            int mid = (lt + rt) / 2;
            if (numbers[mid] == target) return mid + 1;
            else if (numbers[mid] < target) lt = mid + 1;
            else rt = mid - 1;
        }

        return lt + 1;
    }
}
