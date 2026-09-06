package Y2026M09;

import java.util.ArrayList;
import java.util.List;

public class LeetCode226 {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            // 나선형 움직임이 되는 무한 반복처리. 좌 -> 우  상 -> 하 우 -> 좌  하 -> 상
            // 좌 -> 우 우 <- 좌 모두 불가능 , 상 -> 하 하 -> 상 모두 불가능할때
            List<Integer> answer = new ArrayList<>();
            int minX = 0;
            int maxX = matrix[0].length - 1;
            int minY = 0;
            int maxY = matrix.length - 1;
            // x,y를 위의 변수로 해보자.
            while(minX <= maxX && minY <= maxY) {
                for (int x = minX; x <= maxX; x++) {
                    answer.add(matrix[minY][x]);
                }
                minY++;

                for (int y = minY; y <= maxY; y++) {
                    answer.add(matrix[y][maxX]);
                }
                maxX--;

                if (minY <= maxY) { // 해당 행이 좌측으로 다시 이동 할 수 있는지에 대한 확인
                    for (int x = maxX; x >= minX; x--) {
                        answer.add(matrix[maxY][x]);
                    }
                    maxY--;
                }

                if (minX <= maxX) { // 해당 행이 위로 향할 수 있는지에 대한 확인 (이미 라인이 넘어섰다면 불가능)
                    for (int y = maxY; y >= minY; y--) {
                        answer.add(matrix[y][minX]);
                    }

                    minX++;
                }

            }

            return answer;
        }
    }
}
