package Y2024M11;

import java.io.*;
import java.util.StringTokenizer;

public class P10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque deque = new Deque(n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front": deque.pushFront(Integer.parseInt(st.nextToken())); break;
                case "push_back": deque.pushBack(Integer.parseInt(st.nextToken())); break;
                case "pop_front": sb.append(deque.popFront()).append("\n"); break;
                case "pop_back": sb.append(deque.popBack()).append("\n"); break;
                case "size": sb.append(deque.size()).append("\n"); break;
                case "empty": sb.append(deque.empty()).append("\n"); break;
                case "front": sb.append(deque.front()).append("\n"); break;
                case "back": sb.append(deque.back()).append("\n"); break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Deque {


        private int head;
        private int tail;
        private int[] deque;
        private int size = 0;


        public Deque(int dequeSize) {
            deque = new int[dequeSize];
            head = dequeSize/2;
            tail = dequeSize/2;
            if (dequeSize != 1) {
                tail += 1;
            }
        }

        public void pushFront(int n) {
            deque[head--] = n;
            size++;
            if (head < 0) {
                head = deque.length - 1;
            }
        }

        public void pushBack(int n) {
            deque[tail++] = n;
            size++;
            if (tail > deque.length - 1) {
                tail %= deque.length;
            }
        }

        public int popFront() {
            if (size == 0) {
                return -1;
            }

            size--;
            return deque[++head];
        }


        public int popBack() {
            if (size == 0) {
                return -1;
            }

            size--;
            return deque[--tail];
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

            return deque[head + 1];
        }

        public int back() {
            if (size == 0) {
                return -1;
            }

            return deque[tail - 1];
        }
    }

    private static class GptDeque {
        private int[] deque;
        private int head;
        private int tail;
        private int size;

        public GptDeque(int capacity) {
            deque = new int[capacity];
            head = capacity/2;
            tail = capacity/2;
            size = 0;
        }

        private void resize() {
            int newCapacity = deque.length * 2;
            int[] newDeque = new int[newCapacity];

            int start = newCapacity / 4;
            for (int i = 0; i < size; i++) {
                newDeque[start + i] = deque[i] = deque[(head + i) % deque.length];
            }

            head = start - 1;
            tail = start + size;
            deque = newDeque;

        }

        public void pushFront(int n) {
            if (size ==  deque.length - 1) {
                resize();
            }
            head = (head - 1 + deque.length) % deque.length;
            deque[head] = n;
            size++;
        }

        public void pushBack(int n) {
            if (size == deque.length - 1) {
                resize();
            }

            deque[tail] = n;
            tail = (tail + 1) % deque.length;
            size++;
        }

        public int isEmpty() {
            return size == 0 ? 1 : 0;
        }

        public int popFront() {
            if (isEmpty() == 1) {
                return -1;
            }
            int value = deque[head];
            head = (head + 1) % deque.length;
            size --;

            return value;
        }

        public int popBack() {
            if (isEmpty() == 1) {
                return -1;
            }

            tail = (tail - 1 + deque.length) % deque.length;
            size --;
            return deque[tail];
        }

        public int front() {
            return isEmpty() == 1 ? -1 : deque[head];
        }

        public int back() {
            return isEmpty() == 1 ? -1 : deque[(tail - 1 + deque.length) % deque.length];
        }

        public int size() {
            return size;
        }
    }
}
