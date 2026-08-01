package Y2026M07;

public class NeetCode71 {
    static class Solution {
        public boolean mergeTriplets(int[][] triplets, int[] target) {

            int tx = target[0];
            int ty = target[1];
            int tz = target[2];

            int maxX = 0;
            int maxY = 0;
            int maxZ = 0;
            for (int i = 0; i < triplets.length; i++) {
                int x = triplets[i][0];
                int y = triplets[i][1];
                int z = triplets[i][2];

                if (x <= tx && y <= ty && z <= tz) {
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                    maxZ = Math.max(maxZ, z);
                }
            }

            return tx == maxX && ty == maxY && tz == maxZ;
        }
    }

}
