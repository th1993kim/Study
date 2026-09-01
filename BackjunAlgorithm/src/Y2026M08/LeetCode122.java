package Y2026M08;

import java.util.HashMap;
import java.util.Map;

public class LeetCode122 {

    static class Solution {
        public int longestConsecutive(int[] nums) {
            // 각 배열의 숫자에 대해서 그룹번호를 만들고, 다시 반복문을 돌면서 해당 번호 +1 혹은 -1 했을때
            // 일치하는 번호가 존재하는 경우 union을 해준다.
            // 이때 union 하면서 길이를 갱신해준다.
            // 그룹번호가 너무 큰값까지 나올 수 있기때문에 Map형태로 해볼까?
            // Map<Integer, Integer> 해당 값, 그룹번호
            // Map<Integer, Integer> 그룹번호, 개수
            int answer = 0;
            Map<Integer, Integer> group = new HashMap<>();
            Map<Integer, Integer> sizeMap = new HashMap<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                group.put(nums[i], nums[i]);
                sizeMap.put(nums[i], 1);
            }

            for (int i = 0; i < n; i++) {

                union(nums[i], nums[i] + 1, group , sizeMap);
                union(nums[i], nums[i] - 1, group , sizeMap);

                answer = Math.max(answer, sizeMap.get(find(nums[i], group)));
            }

            return answer;
        }

        private Integer find(int num, Map<Integer, Integer> group) {
            Integer groupNo = group.get(num);
            if (groupNo == null) return null;

            if (groupNo == num) {
                return groupNo;
            }
            Integer result = find(groupNo, group);
            group.put(num, result);
            return result;
        }

        private void union(int num1, int num2, Map<Integer, Integer> group, Map<Integer, Integer> sizeMap) {
            Integer group1 = find(num1, group);
            Integer group2 = find(num2, group);

            if (group1 == null || group2 == null) {
                return;
            }

            if (!group1.equals(group2)) {
                group.put(group1, group2);
                int size = sizeMap.get(group1) + sizeMap.get(group2);
                sizeMap.put(group2, size);
            }
        }
    }
}
