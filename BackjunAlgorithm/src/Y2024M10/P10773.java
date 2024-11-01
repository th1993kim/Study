package Y2024M10;

import java.io.*;

public class P10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        Stack stack = new Stack();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                sum -= stack.pop();
            } else {
                sum += number;
                stack.push(number);
            }
        }

        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
        br.close();
    }

    public static class Stack {
        int top = 0;
        private final int[] stackArr = new int[100000];

        public void push(int n) {
            stackArr[top++] = n;
        }

        public int pop() {
            return stackArr[--top];
        }
    }
}
