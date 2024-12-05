package Y2024M12;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17299 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] inputs = new int[n];
        int[] counts = new int[10000001];
        int[] results = new int[n];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
            counts[inputs[i]]++;
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && counts[stack.peek()] <= counts[inputs[i]]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                results[i] = -1;
            } else {
                results[i] = stack.peek();
            }

            stack.push(inputs[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(results[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
