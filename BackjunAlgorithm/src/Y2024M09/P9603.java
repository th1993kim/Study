package Y2024M09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9603 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int maxX = -10000;
        int minX = 10000;
        int maxY = -10000;
        int minY = 10000;

        for (int i = 0; i < count; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());

            if (maxX < x) {
                maxX = x;
            }

            if (minX > x) {
                minX = x;
            }


            int y = Integer.parseInt(tokenizer.nextToken());

            if (maxY < y) {
                maxY = y;
            }

            if (minY > y) {
                minY = y;
            }

        }

        System.out.println((maxX - minX) * (maxY - minY));
    }
}
