package Y2024M11;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int count = 1;
        while (!deque.isEmpty()) {
            if (count++ % k == 0) {
                sb.append(deque.pollFirst());
                if (!deque.isEmpty()) {
                    sb.append(", ");
                }
            } else {
                deque.addLast(deque.pollFirst());
            }
        }
        sb.append(">");
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private void otherSolution(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        LinkedList<Integer> linkedList = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int count = 1;
        for (int i = 1; i <= n; i++) {
            linkedList.add(i);
        }

        while (!linkedList.isEmpty()) {
            if (count++ % k == 0) {
                sb.append(linkedList.remove());
            } else {
                linkedList.add(linkedList.remove());
            }
        }
        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
