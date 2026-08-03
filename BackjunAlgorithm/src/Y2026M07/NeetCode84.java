package Y2026M07;

public class NeetCode84 {
    static class Solution {
        public int[] findRedundantConnection(int[][] edges) {

            int[] group = new int[edges.length + 1];

            for (int i = 0; i < group.length; i++) {
                group[i] = i;
            }

            for (int i = 0; i < edges.length; i++) {
                int pre = edges[i][0];
                int back = edges[i][1];

                if (!union(pre, back, group)) {
                    return new int[]{pre, back};
                }
            }

            return new int[0];
        }
        private boolean union(int a, int b, int[] group) {
            int groupA = find(a, group);
            int groupB = find(b, group);

            if (groupA == groupB) return false;

            group[groupB] = groupA;
            return true;
        }

        private int find(int a, int[] group) {
            if (group[a] == a) return a;

            return group[a] = find(group[a], group);
        }
    }

}
