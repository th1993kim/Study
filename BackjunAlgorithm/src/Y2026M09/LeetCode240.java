package Y2026M09;

public class LeetCode240 {

    static class Solution {

        public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            int[] group = new int[n*m];
            int[] size = new int[n*m];

            int answer = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int index = i * m + j;
                    if (grid[i][j] == '1'){
                        group[index] = index;
                        size[index]++;
                        answer++;
                    } else {
                        group[index] = -1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '0') continue;

                    int current = i * m + j;

                    if (j + 1 < m && grid[i][j+1] == '1') {
                        if (union(current, current + 1, group, size)) answer--;
                    }

                    if (i + 1 < n && grid[i+1][j] == '1') {
                        if (union(current, (i+1) * m + j, group, size)) answer--;
                    }
                }
            }

            return answer;
        }

        int find(int a, int[] group) {
            int groupNo = group[a];
            if (groupNo == a) {
                return groupNo;
            }

            return group[a] = find(groupNo, group);
        }

        boolean union(int a, int b, int[] group, int[] size) {
            int groupA = find(a, group);
            int groupB = find(b, group);
            if (groupA == groupB) return false;

            if (size[groupA] < size[groupB]) {
                group[groupA] = groupB;
                size[groupB] += size[groupA];
            } else {
                group[groupB] = groupA;
                size[groupA] += size[groupB];
            }

            return true;
        }

    }
}
