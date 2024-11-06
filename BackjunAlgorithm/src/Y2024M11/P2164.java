package Y2024M11;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class P2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>(n);

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int number = 1;
        while (queue.size() > 1) {

            if (number++ % 2 == 1) {
                queue.remove();
            } else {
                queue.add(queue.remove());
            }
        }

        bw.write(String.valueOf(queue.remove()));

        bw.flush();
        bw.close();
        br.close();
    }
}
