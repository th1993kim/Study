package Y2024M11;

import java.io.*;
import java.util.StringTokenizer;

public class P10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack stack = new Stack(n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push": stack.push(Integer.parseInt(st.nextToken())); break;
                case "pop": sb.append(stack.pop()).append("\n"); break;
                case "size": sb.append(stack.size()).append("\n"); break;
                case "empty": sb.append(stack.empty()).append("\n"); break;
                case "top": sb.append(stack.top()).append("\n"); break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Stack {
        private int[] stack;
        private int cursor = 0;
        private int size = 0;

        public Stack(int command) {
            stack = new int[command];
        }

        public void push(int command) {
            stack[cursor++] = command;
            size++;
        }

        public int pop() {
            if (size == 0) {
                return -1;
            }
            size--;
            return stack[--cursor];
        }

        public int size() {
            return size;
        }

        public int empty() {
            if (size == 0) {
                return 1;
            }
            return 0;
        }

        public int top() {
            if (size == 0) {
                return -1;
            }
            return stack[cursor - 1];
        }
    }
}
