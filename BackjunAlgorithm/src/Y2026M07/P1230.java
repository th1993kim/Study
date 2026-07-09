package Y2026M07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1230 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Block> blocks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            blocks.add(new Block(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
        int answer = solution(n, blocks);

        System.out.println(answer);
    }

    private static int solution(int n, List<Block> blocks) {

        blocks.sort(Block::compareTo);
        int[] dy = new int[n];
        dy[0] = blocks.get(0).height;
        int answer = dy[0];

        for (int i = 1; i < n; i++) {
            dy[i] = blocks.get(i).height;
            for (int j = i - 1; j >= 0; j--) {
                if (blocks.get(j).weight > blocks.get(i).weight) {
                    dy[i] = Math.max(dy[i], dy[j] + blocks.get(i).height);
                }
            }
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    static class Block implements Comparable<Block> {
        int wide;
        int height;
        int weight;

        public Block(int wide, int height, int weight) {
            this.wide = wide;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Block o) {
            return o.wide - this.wide;
        }

    }
}
