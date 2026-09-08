package Y2026M09;

public class LeetCode242 {
    static class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            int count = 0;
            int[] group = new int[n+1];

            for (int i = 1; i <= n; i++) {
                group[i] = i;
                count++;
            }

            for (int i = 0; i < isConnected.length; i++) {
                int start = 0;
                for (int j = 0; j < isConnected[0].length; j++) {
                    if (isConnected[i][j] == 1) {
                        if (start == 0) {
                            start = j + 1;
                        } else {
                            if (union(start, j + 1, group)) {
                                count --;
                                start = j + 1;
                            }
                        }
                    }
                }
            }

            return count;
        }

        int find(int a, int[] group) {
            int groupA = group[a];
            if (groupA == a) return groupA;

            return group[a] = find(groupA, group);
        }

        boolean union(int a, int b, int[] group) {
            int groupA = find(a, group);
            int groupB = find(b, group);

            if (groupA == groupB) return false;

            group[groupA] = groupB;
            return true;
        }
    }
}
