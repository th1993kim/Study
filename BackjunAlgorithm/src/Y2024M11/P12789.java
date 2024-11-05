package Y2024M11;

import java.io.*;

import java.util.Stack;

public class P12789 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        String[] stackArray = br.readLine().split(" ");

        int position = 1;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(stackArray[i]);

            while (!stack.isEmpty() && stack.peek().equals(position)) {
                position++;
                stack.pop();
            }

            if (num == position) {
                position++;
            } else {
                stack.push(num);
            }
        }

        while (!stack.isEmpty() && stack.peek().equals(position)) {
            position++;
            stack.pop();
        }

        if (stack.isEmpty()) {
            bw.write("Nice");
        } else {
            bw.write("Sad");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void gptSolution(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        String[] stackArray = br.readLine().split(" ");

        int position = 1;
        for (int i = n - 1; i >= 0; i--) {
            int num = Integer.parseInt(stackArray[i]);

            while (!stack.isEmpty() && stack.peek().equals(position)) {
                position++;
                stack.pop();
            }

            if (num == position) {
                position++;
            } else {
                stack.push(num);
            }
        }

        while (!stack.isEmpty() && stack.peek().equals(position)) {
            position++;
            stack.pop();
        }

        if (stack.isEmpty()) {
            bw.write("Nice");
        } else {
            bw.write("Sad");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
