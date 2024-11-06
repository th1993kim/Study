package Y2024M11;

import java.io.*;
import java.util.StringTokenizer;

public class P18258 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Queue queue = new Queue(15);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push": queue.push(Integer.parseInt(st.nextToken())); break;
                case "pop": sb.append(queue.pop()).append("\n"); break;
                case "size": sb.append(queue.size()).append("\n"); break;
                case "empty": sb.append(queue.isEmpty()).append("\n"); break;
                case "front": sb.append(queue.front()).append("\n"); break;
                case "back": sb.append(queue.back()).append("\n"); break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Queue {

        private int front = 0;
        private int back = 0;
        private int size = 0;
        private int[] arr;

        public Queue(int size) {
            arr = new int[size];
        }

        public void push(int data) {
            if (size == arr.length) {
                return;
            }
            arr[back] = data;
            back = (back + 1) % arr.length;
            size ++;
        }

        public int pop() {
            if (isEmpty() == 1) {
                return -1;
            }

            int data = arr[front];
            front = (front + 1) % arr.length;
            size --;
            return data;
        }

        public int size() {
            return size;
        }

        public int isEmpty() {
            return size() == 0 ? 1 : 0;
        }

        public int front() {
            if (isEmpty() == 1) {
                return -1;
            }
            return arr[front];
        }

        public int back() {
            if (isEmpty() == 1) {
                return -1;
            }
            return arr[back - 1];
        }
    }
}
