package Y2026M07;

import java.util.HashSet;
import java.util.Set;

public class NeetCode83 {
    static class Solution {
        public int countComponents(int n, int[][] edges) {
            int[] group = new int[n];



            for (int i = 0; i < n; i ++) {
                group[i] = i;
            }

            for (int i = 0; i < edges.length; i++) {
                int pre = edges[i][0];
                int back = edges[i][1];
                union(pre, back, group);
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < group.length; i++) {
                set.add(find(i, group));
            }

            return set.size();
        }

        private int find(int a, int[] group) {
            if (group[a] == a) return a;

            return group[a] = find(group[a], group);
        }

        private void union(int a, int b, int[] group) {
            int rootA = find(a, group);
            int rootB = find(b, group);
            if (rootA == rootB) return;

            group[rootB] = rootA;
        }
    }

}
