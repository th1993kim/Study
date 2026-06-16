package Y2026M06;

import java.util.*;

public class P1168 {

    static int cacheSize, batchSize;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cacheSize = scanner.nextInt();
        batchSize = scanner.nextInt();

        int[] cache = new int[cacheSize];

        for (int i = 0; i < batchSize; i++) {
            int cacheValue = scanner.nextInt();

            int index = -1;
            for (int j = 0; j < cacheSize; j++) {
                if (cacheValue == cache[j]) {
                    index = j;
                    break;
                }
            }

            if (index == -1) {
                for (int j = cacheSize - 2; j >= 0; j--) {
                    cache[j + 1] = cache[j];
                }

            } else if (index != 0) {
                for (int j = index - 1; j >= 0; j--) {
                    cache[j + 1] = cache[j];
                }
            }

            cache[0] = cacheValue;
        }

        for (int i = 0; i < cacheSize; i++) {
            System.out.print(cache[i] + " ");
        }
    }
}
