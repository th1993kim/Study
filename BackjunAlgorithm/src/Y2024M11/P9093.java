package Y2024M11;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class P9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                char[] charArray = word.toCharArray();
                for (char charWord : charArray) {
                    stack.push(String.valueOf(charWord));
                }
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }

    public static void otherSolution(BufferedReader br, BufferedWriter bw) throws IOException {

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                sb.append(new StringBuilder(st.nextToken()).reverse()).append(" ");
            }
            n--;
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
