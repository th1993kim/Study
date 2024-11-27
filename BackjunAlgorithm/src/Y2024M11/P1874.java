package Y2024M11;

import java.io.*;
import java.util.Stack;

public class P1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int n = Integer.parseInt(br.readLine());
        boolean isNotCreatable = false;
        int m = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int needNumber = Integer.parseInt(br.readLine());
            while(stack.peek() < needNumber) {
                if (m > needNumber) {
                    isNotCreatable = true;
                    break;
                }
                sb.append("+").append("\n");
                stack.push(m++);
            }
            while (stack.peek() >= needNumber) {
                sb.append("-").append("\n");
                stack.pop();
            }

            if (isNotCreatable) {
                sb = new StringBuilder("NO");
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void otherSolution(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());


            while (num >= count) {
                stack.push(count++);
                sb.append("+\n");
            }

            if (num == stack.peek()) {
                stack.pop();
                sb.append("-\n");
            } else {
                sb = new StringBuilder("NO");
                break;
            }
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
