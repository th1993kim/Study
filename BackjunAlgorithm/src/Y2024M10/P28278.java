package Y2024M10;

import java.io.*;
import java.util.StringTokenizer;

public class P28278 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack stack = new Stack();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                int command = Integer.parseInt(st.nextToken());

                switch (command) {
                    case 1:
                        stack.push(Integer.parseInt(st.nextToken()));
                        break;
                    case 2:
                        sb.append(stack.pop()).append("\n");
                        break;
                    case 3:
                        sb.append(stack.size()).append("\n");
                        break;
                    case 4:
                        sb.append(stack.isEmpty()).append("\n");
                        break;
                    case 5:
                        sb.append(stack.print()).append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Stack {

        private int top = 0;
        private int[] stack = new int[1000000];

        public void push(int n) {
            stack[top++] = n;
        }

        public int pop() {
            if (top == 0) return -1;
            return stack[--top];
        }

        public int isEmpty() {
            if (top == 0) return 1;

            return 0;
        }

        public int size() {
            return top;
        }

        public int print() {
            if (top == 0) return -1;
            return stack[top - 1];
        }

    }
}
