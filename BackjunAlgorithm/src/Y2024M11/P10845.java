package Y2024M11;

import java.io.*;
import java.util.StringTokenizer;

public class P10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Queue queue = new Queue(10000);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push": queue.push(Integer.parseInt(st.nextToken()));break;
                case "pop": sb.append(queue.pop()).append("\n"); break;
                case "size": sb.append(queue.size()).append("\n"); break;
                case "empty": sb.append(queue.empty()).append("\n"); break;
                case "front": sb.append(queue.front()).append("\n"); break;
                case "back": sb.append(queue.back()).append("\n"); break;
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }

    private static class Queue {

        int top = 0;
        int bottom = 0;
        int size = 0;
        int[] queue;

        public Queue(int queueSize) {
            queue = new int[queueSize];
        }

        public void push(int value) {
            queue[bottom++] = value;
            size++;
        }

        public int pop() {
            if (size == 0) {
                return -1;
            }
            size--;
            return queue[top++];
        }

        public int size() {
            return size;
        }

        public int empty() {
            return size == 0 ? 1 : 0;
        }

        public int front() {
            if (size == 0) {
                return -1;
            }
            return queue[top];
        }

        public int back() {
            if (size == 0) {
                return -1;
            }
            return queue[bottom - 1];
        }


    }

}
