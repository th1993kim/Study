package Y2026M07;

import java.util.Arrays;
import java.util.Stack;

public class NeetCode6 {
    static class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;
            int[][] car = new int[n][2];

            for (int i = 0; i < position.length; i++) {
                car[i][0] = position[i];
                car[i][1] = speed[i];
            }

            Arrays.sort(car, (a, b) -> Integer.compare(b[0], a[0]));

            Stack<Double> arrivalStack = new Stack<>();

            for (int i = 0; i < n; i++) {
                double arrivalTime = ((double)target - car[i][0]) / car[i][1];
                if (arrivalStack.isEmpty() || arrivalStack.peek() < arrivalTime) {
                    arrivalStack.push(arrivalTime);
                }
            }
            return arrivalStack.size();
        }
    }
}
