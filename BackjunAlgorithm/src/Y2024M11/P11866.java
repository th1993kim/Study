package Y2024M11;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class P11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int k = Integer.parseInt(inputArr[1]);

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int j = 1;

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (j % k == 0) {
                sb.append(poll).append(", ");
                j = 1;
            } else {
                queue.add(poll);
                j++;
            }

        }


        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
