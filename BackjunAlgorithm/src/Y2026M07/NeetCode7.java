package Y2026M07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NeetCode7 {
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            Map<Integer, Integer> countMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            }

            List<Integer>[]countArray = new List[nums.length + 1];

            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                int number = entry.getKey();
                int count = entry.getValue();

                List<Integer> numberList = countArray[count];
                if (numberList == null) {
                    numberList = new ArrayList<>();
                    countArray[count] = numberList;
                }
                numberList.add(number);
            }

            int[] answer = new int[k];
            int index = 0;
            for (int i = countArray.length - 1; i >= 1; i--) {
                if (countArray[i] == null) continue;

                List<Integer> numberList = countArray[i];
                for (Integer number : numberList) {
                    answer[index++] = number;
                    if (index == k) return answer;
                }
            }
            return answer;
        }
    }

}
