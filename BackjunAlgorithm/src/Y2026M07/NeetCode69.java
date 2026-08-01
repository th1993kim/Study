package Y2026M07;

public class NeetCode69 {
    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int total = 0;
            int tank = 0;
            int startIndex = 0;

            for (int i = 0; i < gas.length; i++) {
                int remain = gas[i] - cost[i];
                total += remain;
                tank += remain;

                if (tank < 0) {
                    startIndex = i + 1;
                    tank = 0;
                }
            }

            return total >= 0 ? startIndex : -1;
        }
    }

}
