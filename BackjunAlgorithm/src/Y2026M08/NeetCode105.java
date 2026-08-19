package Y2026M08;

public class NeetCode105 {
    static class Solution {
        public int maxProfit(int[] prices) {
            int hold = -prices[0];
            int sold = Integer.MIN_VALUE;
            int rest = 0;

            for (int i = 1; i < prices.length; i++) {
                int prevHold = hold;
                int prevSold = sold;
                int prevRest = rest;

                hold = Math.max(prevHold, prevRest -prices[i]);
                sold = prevHold + prices[i];
                rest = Math.max(prevRest, prevSold);
            }

            return Math.max(sold, rest);
        }
    }

}
