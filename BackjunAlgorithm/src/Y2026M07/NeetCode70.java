package Y2026M07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NeetCode70 {
    static class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {
            Arrays.sort(hand);

            Map<Integer, Integer> countMap = new HashMap<>();

            for (int i = 0; i < hand.length; i++) {
                countMap.put(hand[i], countMap.getOrDefault(hand[i], 0) + 1);
            }

            for (int i = 0; i < hand.length; i++) {
                int firstCard = hand[i];
                int firstCardCount = countMap.get(firstCard);
                if (firstCardCount == 0) continue;

                for (int rangeCard = firstCard; rangeCard < firstCard + groupSize; rangeCard++) {
                    Integer curCardCount = countMap.get(rangeCard);

                    if (curCardCount == null || curCardCount == 0) return false;

                    countMap.put(rangeCard, curCardCount - 1);
                }
            }

            return true;
        }
    }

}
